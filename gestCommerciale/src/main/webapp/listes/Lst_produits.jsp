<%@page import="com.jawhara.dao.ProduitDao"%>
<%@page import="com.jawhara.entity.Produit"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<div class="liste_produits">
<%
	List<Produit> produits = new ProduitDao().findAll();
	for(Produit produit: produits){
		if(request.getParameter("type").equals(produit.getTypeProduit().getNomTypeProduit())){
%>
		<table class="BlogEntry">
			<tr>
				<td rowspan="2" width="85px">
					<div class="BlogEntryImg">
						<img src="ressources/img/produits/<%=produit.getRefProduit()%>.jpg"/>
					</div>
				</td>	
				<td>
					<b><a href=""><%=produit.getTypeProduit().getNomTypeProduit() %></a></b>
				</td> 
				<td rowspan="2" style="width:25px; text-align: center;" >
					<div class="supprimer" onclick="enleverProduit(<%=produit.getRefProduit()%>)">X</div>
				</td>
				<td class="BlogEntryQtePrix" rowspan="2" style="width:25px; text-align: center;" >
					<div class="supprimer" onclick="enleverProduit(<%=produit.getRefProduit()%>)">O</div>
				</td>
			</tr>
			<tr>
				<td class="BlogEntryNotes">
					<span class="texte_bleu_ciel">Code </span><%=produit.getCodeProduit() %>
					<span class="texte_bleu_ciel">Prix </span><%=produit.getPrixVenteProduit() %>
		        </td>
			</tr>
		</table>
	
<%}} %>
</div>
