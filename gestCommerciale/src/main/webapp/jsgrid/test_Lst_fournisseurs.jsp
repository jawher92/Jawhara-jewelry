<%@page import="java.util.List"%>
<%@page import="com.jawhara.dao.FournisseurDao"%>
<%@page import="com.jawhara.entity.Fournisseur"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>jsGrid - Basic Scenario</title>
    <link rel="stylesheet" type="text/css" href="demos.css" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300,600,400' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" type="text/css" href="css/jsgrid.css" />
    <link rel="stylesheet" type="text/css" href="css/theme.css" />

    <script src="src/jquery/jquery-1.8.3.js"></script>
    
    <script src="src/jsgrid.core.js"></script>
    <script src="src/jsgrid.load-indicator.js"></script>
    <script src="src/jsgrid.load-strategies.js"></script>
    <script src="src/jsgrid.sort-strategies.js"></script>
    <script src="src/jsgrid.field.js"></script>
    <script src="src/fields/jsgrid.field.text.js"></script>
    <script src="src/fields/jsgrid.field.number.js"></script>
    <script src="src/fields/jsgrid.field.select.js"></script>
    <script src="src/fields/jsgrid.field.checkbox.js"></script>
    <script src="src/fields/jsgrid.field.control.js"></script>
	
	<script>
	(function() {

    var db = {

        loadData: function(filter) {
            return $.grep(this.fournisseurs, function(fournisseur) {
                return (!filter.Name || fournisseur.Name.indexOf(filter.Name) > -1)
                    && (!filter.Age || fournisseur.Age === filter.Age)
                    && (!filter.Adress || fournisseur.Adress.indexOf(filter.Adress) > -1)
                    && (!filter.Country || fournisseur.Country === filter.Country)
                    && (filter.Married === undefined || fournisseur.Married === filter.Married);
            });
        },

        insertItem: function(insertingFour) {
            this.fournisseurs.push(insertingFour);
        },

        updateItem: function(updatingFour) { },

        deleteItem: function(deletingFour) {
            var fourIndex = $.inArray(deletingFour, this.fournisseurs);
            this.fournisseurs.splice(fourIndex, 1);
        }

    };

    window.db = db;


    db.countries = [
        { Name: "", Id: 0 },
        { Name: "Tunisia", Id: 1 },
        { Name: "Canada", Id: 2 },
        { Name: "United Kingdom", Id: 3 },
        { Name: "France", Id: 4 },
        { Name: "Brazil", Id: 5 },
        { Name: "China", Id: 6 },
        { Name: "Russia", Id: 7 }
    ];

    db.fournisseurs = [//fournisseurs
<%
	FournisseurDao fournisseurDao=new FournisseurDao();
	List<Fournisseur> fournisseurs=fournisseurDao.findAll();
	for (Fournisseur fournisseur : fournisseurs) {%>
<%-- 		<td><%=fournisseur.getMailFr() %></td> --%>
        {

            "Nom fournisseur": "<%=fournisseur.getNomFr()%>",
            "Numéro de téléphone": "<%=fournisseur.getTelFr() %>",
            "Adresse": "<%=fournisseur.getAdrFr()%>",
            
            "Adresse électronique": "<%=fournisseur.getMailFr() %>"
            
        },
<%}%>
    ];


}());
	
	</script>
	
</head>
<body>
    <h1>Basic Scenario</h1>
    <div id="jsGrid"></div>

    <script>
        $(function() {

            $("#jsGrid").jsGrid({
                height: "70%",
                width: "100%",
                filtering: true,
                editing: true,
                inserting: true,
                sorting: true,
                paging: true,
                autoload: true,
                pageSize: 15,
                pageButtonCount: 5,
                deleteConfirm: "Voulez vous vraiment supprimer ce fournisseur ?",
                controller: db,
                fields: [
                    { name: "Nom fournisseur", type: "text", width: 150 },
                    { name: "Numéro de téléphone", type: "number", width: 60 },
                    { name: "Adresse", type: "text", width: 200 },
                    { name: "Adresse électronique", type: "text", width: 200 },
                    { type: "control" }
                ]
            });

        });
    </script>
</body>
</html>
