<%@page import="com.jawhara.dao.TypeProduitDao"%>
<%@page import="com.jawhara.entity.TypeProduit"%>
<%@page import="java.util.List"%>
<script>
// 	afficherla formulaire
	function frmAjouterProduit(){
		document.getElementById('frm_produit').style.display='inline';
		$("#tabRech").find("tr").remove();
		//hidden caché
		document.getElementById('resultat_recherche').style.visibility='hidden';
	}
	

</script>

<div id="frm_produit" class="frm_container">
	<div class="frm_wrapper">
		<table width="100%">
			<tr>
				<td>Code à barres</td>
			</tr>
			<tr>
				<td><input type="text" name="txt_code" id="txt_code" required="required"></td>
			</tr>
			<tr>
				<td>Type</td>
			</tr>
			<tr>
				<td>
				<select name="select_type" id="select_type">
					<%List<TypeProduit> typeProduits=new TypeProduitDao().findAll();
			    	  for(TypeProduit typeProduit : typeProduits){
			    	%>
			    		<option value="<%=typeProduit.getRefTypeProduit()%>">
			    			<%=typeProduit.getNomTypeProduit() %>
			    		</option>
			    	<%} %>
				</select>
				</td>
			</tr>
			<tr>
				<td>Catégorie</td>
			</tr>
			<tr>
				<td>
				<select name="select_categorie" id="select_categorie">
					<option value="Femme">Homme</option>
					<option value="Femme">Femme</option>
					<option value="Femme">Enfants</option>
					<option value="Femme">Homme/Femme</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>
					<div class="opt_form">	
						<input type="button" onclick="javascript:document.getElementById('frm_produit').style.display='none';" value="Annuler"/>
						<input type="submit" value="Ajouter"  class="bt_valider2" onclick="ajouterProduit()" style="width: 45%; float: right;">
					</div>
					<br>
				</td>
			</tr>
		</table>
	</div>

</div>