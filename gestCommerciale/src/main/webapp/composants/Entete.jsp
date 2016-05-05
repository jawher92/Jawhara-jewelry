<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<div id="main-nav">
	<img style="position:absolute ;" src="ressources/img/logo.png" class="logo">
	<ul id="nav">
        <li class="dropdown">
			<%=session.getAttribute("nom_utilisateur") %> 
<form action="Login" method="post">
	<input type="submit" id="bt_deconnexion" name="bt_deconnexion">
</form>
            <ul class="dropdown-list">
            	<li class="a">Profile</li>
                <li onclick="deconnexion()" class="a"><label for="bt_deconnexion">Déconnexion</label></li>
            </ul>
		</li>
		<li class="mobile-inner-header-icon mobile-inner-header-icon-out" style="line-height: 15px;">
			Menu
		</li>
	</ul>
</div>