<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Empleado"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<title>Nomina-Web-Mostrar empleados</title>
		<link rel="stylesheet" href="style/bootstrap.min.css">
		<link rel="icon" type="image/ico" href="img/favicon.ico">
	</head>
	<body>
	<h2>Resultado de la busqueda</h2>
		<table border=1>
			<tr>
				<th>Nombre</th>
				<th>DNI</th>
				<th>Sexo</th>
				<th>Categoria</th>
				<th>años Trabajados</th>
			</tr>
	<%@ page import="java.util.List" %>
	<%@ page import="modelo.Empleado" %>
	<% 
	List<Empleado> list= (List<Empleado>)request.getAttribute("listEmpleados");
	for(Empleado empleadoSelect : list){
	%>
			<tr>
				<td><%=empleadoSelect.nombre %></td>
				<td><%=empleadoSelect.dni%></td>
				<td><%=empleadoSelect.sexo %>
				<td><%=empleadoSelect.getCategoria()%></td>
				<td><%=empleadoSelect.anyos%></td>
			</tr>		
	<%	
	}
	%>
	
	
		</table>
	<script type="text/javascript" src="style/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="style/popper.min.js"></script>
	<script type="text/javascript" src="style/bootstrap.min.js"></script>
	</body>
</html>