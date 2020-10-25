<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Elige un empleado</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="style/bootstrap.min.css">
<link rel="icon" type="image/ico" href="img/favicon.ico">
	</head>
	<body>
		<h2>Eliga según que parámetro desea buscar</h2>
		<div class="container">
		<div class="row">
			<div class="col-l-6">
				<label>Nombre:</label><br>
				<label>DNI:</label><br>
				<label>Sexo:</label><br>
				<label>Categoria:</label><br>
				<label>Años trabajados:</label><br>			
			</div>
			<div class="col-l-6">
				<form action="mainServlet" method="get">
					<input type="hidden" name="action" value="5">
					<input type="text" name="nombre" placeholder="Escribe el nombre y los apellidos"><br>
					<input type="text" name="dni" placeholder="Escribe el dni" maxlength=9><br>
					<input type="text" name="sexo" placeholder="Escribe H o M" maxlength=1><br>
					<input type="text" name="categoria" placeholder="Escribe la categoria del empleado" maxlength="2"><br>
					<input type="text" name="anyo" placeholder="Escribe los años trabajados"><br>
					<input type="submit">
				</form>
			</div>

		</div>
		</div>
<script type="text/javascript" src="style/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="style/popper.min.js"></script>
<script type="text/javascript" src="style/bootstrap.min.js"></script>
	</body>
</html>