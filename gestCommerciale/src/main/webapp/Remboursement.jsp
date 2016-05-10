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
	<title>Bijouuuuuuuuuux</title>
	
	<link href="ressources/css/menu_mobile.css" rel="stylesheet" type="text/css"/>
	<link rel="stylesheet" type="text/css" href="ressources/css/generale.css" />
	<link rel="stylesheet" type="text/css" href="ressources/css/entete.css" />
	<link rel="stylesheet" type="text/css" href="ressources/css/menu.css" />
	<link rel="stylesheet" type="text/css" href="ressources/css/accordeon.css" />
	<link rel="stylesheet" type="text/css" href="ressources/css/liste1.css" />	
	<link rel="stylesheet" type="text/css" href="ressources/css/modules.css" />
	<link rel="stylesheet" type="text/css" href="ressources/css/formulaires.css" />
	<link rel="stylesheet" type="text/css" href="ressources/css/loading.css" />
	
	<!--[if lt IE 9]>
		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	
    <script language="JavaScript" src="ressources/jQuery/jquery-1.3.2.min.js"></script>
	<script language="JavaScript" src="ressources/jQuery/jquery.columnfilters.js"></script>
    		

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
	</script>
	
</head>
<body>

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
		<h1>Retour produits</h1>
<!-- 		<form action=""> -->
<!-- 			<input type="text"> -->
<!-- 		</form> -->
		
		<h3>Derniers achats</h3>
		<jsp:include page="listes/Lst_factures.jsp"/>
		
	
<!-- 		    <div class="liste_achats"> -->
<!-- 				<table class="BlogEntry"> -->
<!-- 					<tr> -->
<!-- 						<td rowspan="2" width="65px"> -->
<!-- 							<div class="BlogEntryImg"> -->
<!-- 								<img class="img_recette" src=""/> -->
<!-- 							</div> -->
<!-- 						</td>	 -->
<!-- 						<td> -->
<!-- 							<b><a href="">Bague</a></b> -->
<!-- 						</td> -->
<!-- 						<td rowspan="2" style="width:25px; text-align: center;" > -->
<!-- 							<div class="supprimer">X</div> -->
<!-- 						</td> -->
<!-- 						<td class="BlogEntryQtePrix" rowspan="2" style="width:120px; text-align: center;" > -->
<!-- 							3 x 250 -->
<!-- 						</td> -->
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						<td class="BlogEntryNotes"> -->
<!-- 							<span class="texte_bleu_ciel">Marque </span>Miss J. -->
<!-- 				        </td> -->
<!-- 					</tr> -->
<!-- 				</table> -->
			
<!-- 				<table class="BlogEntry"> -->
<!-- 					<tr> -->
<!-- 						<td rowspan="2" width="65px"> -->
<!-- 							<div class="BlogEntryImg"> -->
<!-- 								<img class="img_recette" src=""/> -->
<!-- 							</div> -->
<!-- 						</td>	 -->
<!-- 						<td> -->
<!-- 							<b><a href="">Montre</a></b> -->
<!-- 						</td> -->
<!-- 						<td class="BlogEntryQtePrix" rowspan="2" style="width:25px; text-align: center;" > -->
<!-- 							<div class="supprimer">X</div> -->
<!-- 						</td> -->
<!-- 						<td class="BlogEntryQtePrix" rowspan="2" style="width:120px; text-align: center;" > -->
<!-- 							10 x 80 -->
<!-- 						</td> -->
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						<td class="BlogEntryNotes"> -->
<!-- 							<span class="texte_bleu_ciel">Marque </span>Miss J. -->
<!-- 				        </td> -->
<!-- 					</tr> -->
<!-- 				</table> -->
				
<!-- 				<table class="recapitulatif" cellspacing="0px" cellpadding="4"> -->
<!-- 				<tr> -->
<!-- 					<td style="text-align: right;">Totale des Achats</td> -->
<!-- 					<td class="tatale">3200</td> -->
<!-- 				</tr> -->
<!-- 				</table> -->
				
<!-- 				<form action=""> -->
<!-- 					<input type="button" value="Valider" class="bt_valider"> -->
<!-- 				</form> -->
<!-- 			</div> -->
			</div>
			
		</div>

</body>
</html>