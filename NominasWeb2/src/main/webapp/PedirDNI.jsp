<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Introduzca el DNI del empleado</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="style/bootstrap.min.css">
<link rel="icon" type="image/ico" href="img/favicon.ico">
	</head>
	<body>
		<form action="mainServlet" method="get">
			<label>Introduzca el DNI del empleado</label><br>
			<input type="hidden" name="action" value="4">
			<input type="text" name="dni" placeholder="ej: 12345678A"><br>
			<input type="submit" value="Aceptar">
		</form>
<script type="text/javascript" src="style/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="style/popper.min.js"></script>
<script type="text/javascript" src="style/bootstrap.min.js"></script>
	</body>
</html>