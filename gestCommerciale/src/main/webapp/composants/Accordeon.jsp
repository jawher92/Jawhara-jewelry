<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <label for="checkbox_left" class="close_left_container">X</label>
    
    <%=session.getAttribute("agence_utilisateur") %>
    
    <div class="recette">
	    <p class="recette_jour">Recette du Jour : 3500.0 Dt</p>
	    <p class="ma_recette">Ma Recette : 3500.0 Dt</p>
    </div>
    
	<div class="accordion">
		<div id="tab-1">
			<a href="#tab-1" class="tab">Meilleurs articles vendus</a>
			<div class="content">
				<ul>
					<li>Bage ...</li>
					<li>Bracelet ...</li>
					<li>Montre ... </li>
				</ul>
			</div>
		</div>
		<div id="tab-2">
			<a href="#tab-2" class="tab">Articles non vendus</a>
			<div class="content">
				<ul>
					<li>Alliance ...</li>
					<li>Bage ...</li>
					<li>Bracelet ...</li>
					<li>Montre ...</li>
				</ul>	
			</div>
		</div>
		<div id="tab-3">
			<a href="#tab-3" class="tab">Vendeurs</a>
			<div class="content">
				<ul>
					<li>AYMEN</li>
					<li>IBTISSAM</li>
				</ul>	
			</div>			
		</div>
	</div>
