<%@page import="java.util.List"%>
<%@page import="com.jawhara.dao.FournisseurDao"%>
<%@page import="com.jawhara.entity.Fournisseur"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    

<h1>Choix du fournisseur</h1>


<i> Si le fournisseur ne figure pas sur la liste, vous pouvez l'ajouter en cliquant 
<a style="cursor:pointer; color: #02a7b1;" onclick="frmAjouterFournisseur();">ici</a> </i>

<!-- <div class="select_fournisseur"> -->
<!-- 	<input type="text" id="txt_recherche_code"> -->
<!-- 	<input type="button" id="recherche" value="Recherche fournisseur" onclick="rechercherProduit()"> -->
<!-- </div> -->

<table id="filterTable" class="table_liste" cellspacing="0" cellpadding="0">
<thead>
	<tr>
		<th>Nom</th><th class="case_opt2">Adresse</th><th></th>
	</tr>
	</thead>
	<%
	FournisseurDao fournisseurDao=new FournisseurDao();
	List<Fournisseur> fournisseurs=fournisseurDao.findAll();
	for (Fournisseur fournisseur : fournisseurs) {%>
	<tr>
		<td><%=fournisseur.getNomFr()%></td>
		<td class="case_opt2"><%=fournisseur.getAdrFr()%></td>
		<td>
			<form action="Choisir_fournisseur" method="post">
				<input type="text" name="id" value="<%=fournisseur.getIdFr()%>" style="display: none;">
				<input type="text" name="nom" value="<%=fournisseur.getNomFr()%>" style="display: none;">
				
				<input type="button" value ="x" class ="next" onclick="supprimerFournisseur(<%=fournisseur.getIdFr()%>, '<%=fournisseur.getNomFr()%>');">
				<input type="submit" value="►" class="next">
			</form>
		</td>
	</tr>
	<%} %>
</table>


<script>
	$(document).ready(function() {
		$('table#filterTable').columnFilters({alternateRowClassNames:['rowa','rowb'], wildCard:'*',notCharacter:'!', excludeColumns:[2]});
	});
</script>

