<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear Empleado</title>
</head>
<body>
	<h1>Crear Empleado</h1>
	<form action="empleados" method="post">
		<input type="hidden" name="opcion" value="guardar">
		<table border="1">
			<tr>
				<td>DNI:</td>
				<td><input type="text" name="dni" size="50"></td>
			</tr>
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="nombre" size="50"></td>
			</tr>
			<tr>
				<td>Sexo:</td>
				<td><select type="text" name="sexo">
						<option value="M">M</option>
						<option value="F">F</option>
				</select></td>
			</tr>
			<tr>
				<td>Categoria:</td>
				<td><input type="number" name="categoria" size="50" min="1" max="10"></td>
			</tr>
			<tr>
				<td>Años:</td>
				<td><input type="number" name="anyos" size="50" min="1" max="30"></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="Guardar">
		
		<button type="button" onclick="window.location.href='index.jsp'">Volver</button>
	</form>

	
</body>
</html>