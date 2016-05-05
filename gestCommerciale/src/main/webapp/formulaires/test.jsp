<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
</head>
<body>
<input type="button" id="1" value="1" onClick="javaScript:update('1');"/>
<input type="button" id="2" value="2" onClick="javaScript:update('2');"/>
<%
int value=1;
%>
<div id="refresh">
<%=value %>
</div>
<script type="text/javascript">

function update(input)
{
        value=input;
        alert(value);
}

</script>
</body>
</html>