<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Sueldo de empleado</title>
		<link rel="stylesheet" href="style/bootstrap.min.css">
		<link rel="icon" type="image/ico" href="img/favicon.ico">
		
	</head>
	<body>
	<%@ page import="modelo.Empleado" %>
	<%@ page import="java.util.List" %>
	<%	Empleado empleado= (Empleado)request.getAttribute("empleado"); %>
	<%if(empleado.equals(null)) {%>
		<label>El empleado no existe</label>
		<%} else{ %>	
		<label>El sueldo del empleado: <%=empleado.nombre%> es <%=request.getAttribute("sueldo") %> Euros</label>	
		<%}%>
		
		<script type="text/javascript" src="style/jquery-3.5.1.min.js"></script>
		<script type="text/javascript" src="style/popper.min.js"></script>
		<script type="text/javascript" src="style/bootstrap.min.js"></script>
	</body>
</html>