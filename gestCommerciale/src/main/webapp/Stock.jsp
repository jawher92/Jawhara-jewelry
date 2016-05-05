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
	<link rel="stylesheet" type="text/css" href="ressources/css/loading.css" />
	
	<!--[if lt IE 9]>
		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	
	<!--********* SWAL ********-->
	<script src="http://tristanedwards.me/u/SweetAlert//lib/sweet-alert.js"></script>
  	<link rel="stylesheet" type="text/css" href="http://tristanedwards.me/u/SweetAlert//lib/sweet-alert.css">
  	
	
<!-- 	<script language="JavaScript" src="ressources/jQuery/jquery-1.3.2.min.js"></script> -->
	<script language="JavaScript" src="ressources/jQuery/jquery.columnfilters.js"></script>
	<script type="text/javascript" src="ressources/jQuery/jquery-2.2.0.min.js"></script>
	
	

	<script>
//********* menu mobile **********//
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
					javascript:document.getElementById('frm_produit').style.display='none';
			});
			javascript:document.getElementById('frm_produit').style.display='none';
// 			javascript:document.getElementById('loading_page').style.display='none';
			alert("Produit ajouté");
// 			$('#catalogue_produits').load('listes/Lst_produits.jsp');
		}

// 		ajouter un produit a la liste
		function ajouterProduitFournisseur(){
			$.get("Choisir_prod_fournisseur", {id : $('#txt_id_produit').val(), code : $('#txt_code_produit').val(), 
						type : $('#txt_type_produit').val(), prix : $('#txt_prix_produit').val(), 
						marque : $('#txt_marque_produit').val(), qte : $('#txt_qte').val()}, function(response) {
			});
			
		//$('#lite_produits').load('formulaires/Produits_fournisseur.jsp');
			alert("Produit ajouté dans la liste");
			$('#lite_produits').load('formulaires/Produits_fournisseur.jsp');
			document.getElementById('resultat_recherche').style.visibility='hidden';
			$("#tabRech > tr").remove();
		}
		
// 		elever un produit x de la liste
		function enleverProduit(idP){
			$.get("Enlever_prod_fournisseur", {id : idP}, function(response) {		});
			
			$('#lite_produits').load('formulaires/Produits_fournisseur.jsp');
			alert("Produit enlevé dans la liste");
		}
		
		
// 		rechercher un produit par Code a barres
		function rechercherProduit(){
		  //afficher la zone de recherche
			document.getElementById('resultat_recherche').style.visibility='visible';
		  //afficher le loading
			document.getElementById('load_recherche').style.display='inherit';
			id=''; code=''; type=''; prix=''; marque='';
			i=0;
			var donnees = []; 
			$.get("RechercheProduitParCode", {code : $('#txt_recherche_code').val()}, function(responseJson) {
				var $tab = $("#tabRech");   
				$tab.find("tr").remove();

				var $tr = $("<tr>");
				
				if(responseJson!=''){//afficher la resultat
					$.each(responseJson, function(index, item) {
						$("<td>").text(item).appendTo($tr);
						donnees[i]=item;
						i++;
					});
	
				//le boutton et les champs des texte
					$('<td><input type="text" id="txt_id_produit" style="display: none;">').appendTo($tr);
					$('<td><input type="text" id="txt_code_produit" style="display: none;">').appendTo($tr);
					$('<td><input type="text" id="txt_type_produit" style="display: none;">').appendTo($tr);
					$('<td><input type="text" id="txt_marque_produit" style="display: none;">').appendTo($tr);
					$('<td>Prix:<input type="text" id="txt_prix_produit" style="width: 100px">').appendTo($tr);
					$('<td>Qte:<input type="number" id="txt_qte" value="1" style="width: 50px">').appendTo($tr);
					$('<td><input type="button" value="Confirmer" onclick="ajouterProduitFournisseur()">').appendTo($tr);
					$tr.appendTo($tab);
					
					document.getElementById('txt_id_produit').value = donnees[0];
					document.getElementById('txt_code_produit').value = donnees[1];
					document.getElementById('txt_type_produit').value = donnees[2];
					document.getElementById('txt_marque_produit').value = donnees[3];
					document.getElementById('txt_prix_produit').value = donnees[4];
				
				}else{
					var $ajouter = $("<tr>");
					$('<td>Produit inexistant <a style="cursor:pointer; color: #02a7b1;" onclick="frmAjouterProduit();">Ajouter</a>').appendTo($ajouter);
					$ajouter.appendTo($tab);
				}
				
			//masquer loading
				document.getElementById('load_recherche').style.display='none';
			});
		}
		
//		ajouter un fournisseur a la BD
		function ajouterFournisseur(){
			// 	Une vérification de l'existance du fournisseur est faite avant l'ajout dans la BD
			javascript:document.getElementById('loading_page').style.display='inline';
			$.post("Ajouter_fournisseur", {txt_nom : $('#txt_nom').val(), txt_adr : $('#txt_adr').val(), 
				email : $('#email').val(), num_tel : $('#num_tel').val()},
				function(response) {
					if(response=='OK'){//afficher la resultat
						//swal = alerte personalisée
						swal("Fournisseur ajouté !", "", "success")
					}else{
						swal("Le fournisseur n'a pas été ajouté, Un fournisseur avec le meme nom et adresse existe dèja", "Erreur", "error")
					}
					
			});
			javascript:document.getElementById('frm_fournisseur').style.display='none';
//			alert("Fournisseur ajouté");
		}
		
		function supprimerFournisseur(idF, nomF){

// 			javascript:document.getElementById('loading_page').style.display='inline';

		
 			swal("Etes-vous sur de vouloir supprimer "+nomF+" ?", "", "warning")
			
			$.post("Supprimer_fournisseur", {id : idF},
				function(response) {
					if(response=='OK'){//afficher la resultat
						//swal = alerte personalisée
						swal("Fournisseur supprimé !", "", "success")
					}else{
						swal("Le fournisseur n'a pas été supprimé", "Erreur", "error")
					}
					
			});
// 			javascript:document.getElementById('frm_fournisseur').style.display='none';
		}
			 
	</script>
	
</head>
<body>

<jsp:include page="composants/Loading_page.jsp"/>
<jsp:include page="formulaires/Form_produit.jsp"/>
<jsp:include page="formulaires/Form_fournisseur.jsp"/>

<header class="header">
	<jsp:include page="composants/Entete.jsp"/>
</header>

<div class="mobile-inner">
	<jsp:include page="composants/Menu_mobile.jsp"/>
</div>

<div class="menu_container">
	<jsp:include page="composants/Menu.jsp"/>
</div>
<%-- <jsp:include page="listes/Lst_fournisseurs.jsp"/> --%>
<div class="body_container">
<%-- 	<jsp:include page="listes/Lst_fournisseurs.jsp"/> --%>
	<input type="checkbox" name="checkbox_left" class="checkbox_left" id="checkbox_left" style="display: none">
	<label for="checkbox_left" class="open_left_container">||</label>

	<div class="left_container">
		<jsp:include page="composants/Accordeon.jsp"></jsp:include>
	</div>
	
	<div class="right_container">
		<%if(session.getAttribute("fournisseur")==null){ %>
<!-- 		si l'on a pas encore choisi de fournisseur  -->
			<jsp:include page="listes/Lst_fournisseurs.jsp"/>
		<%}else{ %>
<!-- 		sinon, on affiche la liste des produits (fournisseur stocké dans la session) -->
			<div class="select_produit">
				<input type="text" id="txt_recherche_code">
				<input type="button" id="recherche" value="Recherche" onclick="rechercherProduit()">
			</div>
			
			<div id="resultat_recherche">
				<div id="load_recherche">
					<jsp:include page="composants/Loading.jsp"/>
				</div>
				
				<table id="tabRech" style="margin: auto;">
					
				</table>
			</div>
			
			<div id="lite_produits">
				<jsp:include page="formulaires/Produits_fournisseur.jsp"/>
			</div>
		<%} %>
	</div>
</div>



</body>
</html>