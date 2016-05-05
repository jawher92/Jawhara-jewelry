<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<!-- verifier l'identité -->
<%if(session.getAttribute("type_utilisateur")!=null){
	response.sendRedirect("Index.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="shortcut icon" href="ressources/img/icone.ico" type="image/x-icon" />
	<title>Bijouterie</title>

	<meta name="viewport" content="width = device-width, initial-scale=1, maximum-scale=1"/>
	
<!-- 	<link rel="stylesheet" type="text/css" href="ressources/css/generale.css" /> -->
	<link rel="stylesheet" type="text/css" href="ressources/css/login.css" />
	
	<!--[if lt IE 9]>
		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
</head>
<body>

<header class="header">
	<div class="dashed">
		<img src="ressources/img/logo.png" class="logo">
	</div>
</header>

<div class="content">
    <div id="login">
        <form action="Login" method="post">
                <h2>Authentification</h2>
                <p><span class="fontawesome-user"></span><input type="text" name="txt_login" value="Identifiant" onBlur="if(this.value == '') this.value = 'Identifiant'" onFocus="if(this.value == 'Identifiant') this.value = ''" required></p> <!-- JS because of IE support; better: placeholder="Username" -->
                <p><span class="fontawesome-lock"></span><input type="password" name="txt_mdp"  value="Password" onBlur="if(this.value == '') this.value = 'Password'" onFocus="if(this.value == 'Password') this.value = ''" required></p> <!-- JS because of IE support; better: placeholder="Password" -->
                <p><input type="submit" value="Login"></p>
        </form>
     </div>   

</div>
<%String msg=request.getParameter("msg"); %>
    <%if(msg!=null){ %>
    <center style="color: red; font-weight: bold; margin-top: 15px; font-size: large;"><%=msg %></center>
    <%} %>
<!-- pied -->
<!-- 	<footer class="pied"> -->
<!-- 		Tous les droits reservées  -->
<!-- 	</footer> -->

</body>
</html>