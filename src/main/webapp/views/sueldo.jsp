<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buscar Empleado y Salario</title>
</head>
<body>
	<h1>Buscar Empleado</h1>

	<form action="empleados" method="get">
		<input type="hidden" name="opcion" value="buscar">
		<table>
			<tr>
				<td>DNI:</td>
				<td><input type="text" name="dni" size="20"></td>
			</tr>
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="nombre" size="50"></td>
			</tr>
			<tr>
				<td>Sexo:</td>
				<td><select name="sexo">
						<option value="">--Todos--</option>
						<option value="M">Masculino</option>
						<option value="F">Femenino</option>
				</select></td>
			</tr>
			<tr>
				<td>Categoría:</td>
				<td><input type="number" name="categoria" size="5"></td>
			</tr>
			<tr>
				<td>Años:</td>
				<td><input type="number" name="anyos" size="5"></td>
			</tr>
		</table>
		<br> <input type="submit" value="Buscar">
	</form>

	<hr>

	<c:if test="${not empty lista}">
		<h2>Resultados de la búsqueda</h2>
		<table border="1">
			<tr>
				<th>DNI</th>
				<th>Nombre</th>
				<th>Sexo</th>
				<th>Categoría</th>
				<th>Años</th>
				<th>Sueldo</th>
			</tr>
			<c:forEach var="empleado" items="${lista}">
				<tr>
					<td>${empleado.dni}</td>
					<td>${empleado.nombre}</td>
					<td>${empleado.sexo}</td>
					<td>${empleado.categoria}</td>
					<td>${empleado.anyos}</td>
					<td>
						<%-- Calculamos el sueldo según la categoría y años trabajados --%>
						<c:set var="sueldo"
							value="${empleado.categoria * 1000 + empleado.anyos * 50}" />
						${sueldo}
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

	<br>
	<button type="button"
		onclick="window.location.href='empleados?opcion=listar'">Volver</button>

</body>
</html>
