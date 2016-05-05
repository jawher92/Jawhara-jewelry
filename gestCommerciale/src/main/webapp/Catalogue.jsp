<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<!-- verifier l'identité -->
<%if(session.getAttribute("type_utilisateur")==null){
	response.sendRedirect("Login.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="shortcut icon" href="ressources/img/icone.ico" type="image/x-icon" />
	<meta name="viewport" content="width = device-width, initial-scale=1, maximum-scale=1"/>
	<title>Bijouterie</title>
	
	<link href="ressources/css/menu_mobile.css" rel="stylesheet" type="text/css"/>
	<link rel="stylesheet" type="text/css" href="ressources/css/generale.css" />
	<link rel="stylesheet" type="text/css" href="ressources/css/entete.css" />
	<link rel="stylesheet" type="text/css" href="ressources/css/menu.css" />
	<link rel="stylesheet" type="text/css" href="ressources/css/accordeon.css" />
	<link rel="stylesheet" type="text/css" href="ressources/css/modules.css" />
	<link rel="stylesheet" type="text/css" href="ressources/css/formulaires.css" />
	<link rel="stylesheet" type="text/css" href="ressources/css/liste1.css" />
		<!-- appliquer qq modifs sur style 1 --> 
	<link rel="stylesheet" type="text/css" href="ressources/css/liste2.css" />
	<link rel="stylesheet" type="text/css" href="ressources/css/loading.css" />
	<link rel="stylesheet" type="text/css" href="ressources/css/loading_page.css" />
	
	<!--[if lt IE 9]>
		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	
	
	<script type="text/javascript" src="ressources/jQuery/jquery-2.2.0.min.js"></script>

	<script>
		$(window).load(function () {
		
		$(".mobile-inner-header-icon").click(function(){
			$(this).toggleClass("mobile-inner-header-icon-click mobile-inner-header-icon-out");
			$(".mobile-inner-nav").slideToggle(250);
			
		});
		
		
		  $(".mobile-inner-nav a").each(function( index ) {
		  	$( this ).css({'animation-delay': (index/10)+'s'});
		  });
				
		});
		
		//*********** ajax ***********//
		
//		ajouter un produit a la BD
		function ajouterProduit(){
			javascript:document.getElementById('loading_page').style.display='inline';
			$.post("Ajouter_produit", {txt_code : $('#txt_code').val(), select_type : $('#select_type').val(), 
				select_categorie : $('#select_categorie').val(), marque : $('#txt_marque_produit').val()},
				function(response) {
			});
			javascript:document.getElementById('frm_produit').style.display='none';
			javascript:document.getElementById('loading_page').style.display='none';
			alert("Produit ajouté");
			$('#catalogue_produits').load('listes/Lst_produits.jsp');
		}
		
//		supprimer un produit x de la BD
		function enleverProduit(idP){
			javascript:document.getElementById('loading_page').style.display='inline';
			$.post("Supprimer_produit", {id : idP}, function(response) {		});
			
			javascript:document.getElementById('frm_produit').style.display='none';
			javascript:document.getElementById('loading_page').style.display='none';
			alert("Produit supprimé");
			$('#catalogue_produits').load('listes/Lst_produits.jsp');
		}

	</script>
	
</head>
<body>

<jsp:include page="composants/Loading_page.jsp"/>
<jsp:include page="formulaires/Form_produit.jsp"/>

<header class="header">
	<jsp:include page="composants/Entete.jsp"/>
</header>

<div class="mobile-inner">
	<jsp:include page="composants/Menu_mobile.jsp"/>
</div>

<div class="menu_container">
	<jsp:include page="composants/Menu.jsp"/>
</div>

<div class="body_container">
	
	<input type="checkbox" name="checkbox_left" class="checkbox_left" id="checkbox_left" style="display: none">
	<label for="checkbox_left" class="open_left_container">||</label>

	<div class="left_container">
		<jsp:include page="composants/Accordeon.jsp"></jsp:include>
	</div>
	
	<div class="right_container">
		<h1>Nos <%=request.getParameter("type") %>s</h1>
		<a style="cursor:pointer; color: #02a7b1;" onclick="frmAjouterProduit();">Ajouter</a>
		<div id="catalogue_produits">
			<jsp:include page="listes/Lst_produits.jsp"/>
		</div>
	</div>
</div>



</body>
</html>