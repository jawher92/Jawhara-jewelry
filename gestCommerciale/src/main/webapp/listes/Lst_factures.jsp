
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
	
<table id="filterTable" class="table_liste" cellspacing="0" cellpadding="0">
	<thead>
		<tr>
			<th>N° facture</th><th class="case_opt2">Client</th><th></th>
		</tr>
	</thead>

	<tr>
		<td></td>
		<td ></td>
		<td>

		</td>
	</tr>

</table>


<script>
	$(document).ready(function() {
		$('table#filterTable').columnFilters({alternateRowClassNames:['rowa','rowb'], wildCard:'*',notCharacter:'!', excludeColumns:[2], "bSearchable": false});
	});
</script>
	
	
	

	
<%-- 		<% --%>
<!-- // 	FactureDao facturerDao=new FactureDao(); -->
<!-- // 	List<Facture> factures=factureDao.findAll(); -->
<%-- 	for (Facture facture : factures) {%> --%>
<!-- 	<tr> -->
<%-- 		<td><%=facture.getId()%></td> --%>
<%-- 		<td class="case_opt2"><%=fournisseur.getAdrFr()%></td> --%>
<!-- 		<td> -->
<!-- 			<form action="Choisir_fournisseur" method="post"> -->
<%-- 				<input type="text" name="id" value="<%=fournisseur.getIdFr()%>" style="display: none;"> --%>
<%-- 				<input type="text" name="nom" value="<%=fournisseur.getNomFr()%>" style="display: none;"> --%>
				
<%-- 				<input type="button" value ="x" class ="next" onclick="supprimerFournisseur(<%=fournisseur.getIdFr()%>, '<%=fournisseur.getNomFr()%>');"> --%>
<!-- 				<input type="submit" value="►" class="next"> -->
<!-- 			</form> -->
<!-- 		</td> -->
<!-- 	</tr> -->
<%-- 	<%} %>	 --%>