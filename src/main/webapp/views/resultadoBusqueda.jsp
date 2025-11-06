<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Resultado de la búsqueda</title>
</head>
<body>
	<h1>Empleados encontrados</h1>

	<c:if test="${empty lista}">
		<p>No se encontraron empleados con los datos proporcionados.</p>
	</c:if>

	<c:if test="${not empty lista}">
		<table border="1">
			<tr>
				<th>DNI</th>
				<th>Nombre</th>
				<th>Sexo</th>
				<th>Categoría</th>
				<th>Años</th>
				<th>Salario</th>
			</tr>

			<c:forEach var="empleado" items="${lista}">
				<tr>
					<td>${empleado.dni}</td>
					<td>${empleado.nombre}</td>
					<td>${empleado.sexo}</td>
					<td>${empleado.categoria}</td>
					<td>${empleado.anyos}</td>
					<td>${empleado.salario}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

	<br>
	<button type="button" onclick="window.location.href='views/buscarEmpleados.jsp'">Nueva búsqueda</button>
</body>
</html>
