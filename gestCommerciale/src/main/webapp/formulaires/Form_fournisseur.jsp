<%@page import="com.jawhara.dao.TypeProduitDao"%>
<%@page import="com.jawhara.entity.TypeProduit"%>
<%@page import="java.util.List"%>
<script>

	// 	afficherla formulaire
	function frmAjouterFournisseur(){
		document.getElementById('frm_fournisseur').style.display='inline';
		$("#tabRech").find("tr").remove();
		document.getElementById('resultat_recherche').style.visibility='hidden'; //caché
	}
	
</script>

<div id="frm_fournisseur" class="frm_container">
	<div class="frm_wrapper">
		<table width="100%">
		
			<tr>
				<td>Nom du fournisseur</td>
			</tr>
			<tr>
				<td><input type="text" name="txt_nom" id="txt_nom" required="required"></td>
			</tr>
			
			<tr>
				<td>Adresse</td>
			</tr>
			<tr>
				<td><input type="text" name="txt_adr" id="txt_adr" required="required"></td>
			</tr>
			
			<tr>
				<td>Adresse électronique</td>
			</tr>
			<tr>
				<td><input type="email" name="email" id="email" required="required"></td>
			</tr>
			
			<tr>
				<td>Numéro de téléphone</td>
			</tr>
			<tr>
			<td>
<!-- 				<input type="number" name="num_tel" id="num_tel" required="required"> -->
			<input type="tel" name="num_tel" id="num_tel" pattern="^((\+\d{1,3}(-| )?\(?\d\)?(-| )?\d{1,5})|(\(?\d{2,6}\)?))(-| )?(\d{3,4})(-| )?(\d{4})(( x| ext)\d{1,5}){0,1}$" required="required">
			</td>
			</tr>
			
			<tr>
				<td>
					<div class="opt_form">	
						<input type="button" onclick="javascript:document.getElementById('frm_fournisseur').style.display='none';" value="Annuler"/>
						<input type="submit" value="Enregistrer"  class="bt_valider2" onclick="ajouterFournisseur()" style="width: 45%; float: right;">
					</div>
					<br>
				</td>
			</tr>
		</table>
	</div>

</div>