<%@page import="com.jawhara.dao.TypeProduitDao"%>
<%@page import="com.jawhara.entity.TypeProduit"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<div id="categories_mobile">
	<div class="categories_mobile_wrapper">
	<a onclick="document.getElementById('categories_mobile').style.display='none';">Fermer</a>
	<br>
	<ul>
	<%List<TypeProduit> typeProduits=new TypeProduitDao().findAll();
    	for(TypeProduit typeProduit : typeProduits){
    %>
    	<li><a href="Catalogue.jsp?type=<%=typeProduit.getNomTypeProduit() %>">
    		<%=typeProduit.getNomTypeProduit() %></a>
    	</li>
    <%} %>
    </ul>
    </div>
</div>


<div class="mobile-inner-nav">
	<a href="Index.jsp">Accueil</a>
    <a href="Vente.jsp">Nouvelle Vente</a>
    <a href="Remboursement.jsp">Remboursement</a>
    <a href="Stock.jsp">Gerer le Stock</a>
	<a onclick="document.getElementById('categories_mobile').style.display='inline';">Catalogue des Produits</a>
</div>