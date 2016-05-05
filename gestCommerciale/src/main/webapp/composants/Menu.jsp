<%-- <%@ page language="java" contentType="text/html; charset=utf-8" npageEncoding="ISO-8859-1"%> --%>
	<%@page import="com.jawhara.dao.TypeProduitDao"%>
<%@page import="com.jawhara.entity.TypeProduit"%>
<%@page import="java.util.List"%>
<nav>
    <ul class="menu">
    	<li class="home"><a href="Index.jsp"><span>Accueil</span></a></li>
    	<li><a href="Vente.jsp"><span>Nouvelle Vente</span></a></li>
    	<li><a href="Remboursement.jsp"><span>Remboursement</span></a>
    	<li><a href="Stock.jsp"><span>Gerer le Stock</span></a></li>
		<li><a href="#"><span>Catalogue des Produits</span></a>
    		<ul class="sub-menu">
    		<%List<TypeProduit> typeProduits=new TypeProduitDao().findAll();
    		  for(TypeProduit typeProduit : typeProduits){
    		%>
    			<li><a href="Catalogue.jsp?type=<%=typeProduit.getNomTypeProduit() %>">
    				<%=typeProduit.getNomTypeProduit() %></a>
    			</li>
    		<%} %>
            </ul>
		</li>
	</ul>
	</nav>
 