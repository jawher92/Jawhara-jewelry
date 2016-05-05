<%@page import="com.jawhara.objetsUtiles.ProduitSession"%>
<%@page import="com.jawhara.entity.Fournisseur"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
	<%
		Fournisseur fournisseur=new Fournisseur();
		fournisseur=(Fournisseur)session.getAttribute("fournisseur");
		
		List<ProduitSession> produitSessions = (List<ProduitSession>)session.getAttribute("ProduitsFournisseur"); 
		float totale=0;
		
		if(produitSessions.size()>0){
	%>
    <p class="titre">Produits achetés auprès du <%=fournisseur.getNomFr() %></p>
    <div class="liste_achats">    
		
		<%
		for (ProduitSession produitSession : produitSessions) {%>
			<table class="BlogEntry">
				<tr>
					<td rowspan="2" width="65px">
						<div class="BlogEntryImg">
							<img class="img_recette" src="ressources/img/produits/<%=produitSession.getId()%>.jpg"/>
						</div>
					</td>	
					<td>
						<b><a href=""><%=produitSession.getLibType() %></a></b>
					</td> 
					<td rowspan="2" style="width:25px; text-align: center;" >
						<div class="supprimer" onclick="enleverProduit(<%=produitSession.getId()%>)">X</div>
					</td>
					<td class="BlogEntryQtePrix" rowspan="2" style="width:120px; text-align: center;" >
						<%totale=totale+(produitSession.getQte()*produitSession.getPrix()); %>
						<%=produitSession.getQte() %> x <%=produitSession.getPrix()%> €
					</td>
				</tr>
				<tr>
					<td class="BlogEntryNotes">
						<span class="texte_bleu_ciel">Code </span><%=produitSession.getCode() %>
						<span class="texte_bleu_ciel">Marque </span><%=produitSession.getLibMarque() %>
			        </td>
				</tr>
			</table>
		<%} %>	

		
		<table class="recapitulatif" cellspacing="0px" cellpadding="4">
		<tr>
			<td style="text-align: right;">Total des Achats</td>
			<td class="tatale"><%=totale%> €</td>
		</tr>
		</table>
		
		
		<form action="Annuler_stock" method="post">
			<input type="submit" value="Annuler" class="bt_annuler">
			<input type="button" value="Valider" class="bt_valider" id="valider">
		</form>
	</div>
	
	<%}else{%>
		<form action="Annuler_stock" method="post" style="margin: 50px auto; text-align: center">
			<input type="submit" value="Annuler" class="bt_annuler">
		</form>
	<%}%>