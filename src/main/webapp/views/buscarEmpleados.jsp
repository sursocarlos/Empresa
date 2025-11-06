<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buscar Empleados</title>
</head>
<body>
	<h1>Buscar Empleados</h1>
	<!--<form action="empleados" method="get">  -->
	<form action="${pageContext.request.contextPath}/empleados" method="get">
		<input type="hidden" name="opcion" value="buscarEmpleado"> <label>Buscar
			por DNI, nombre, categoría o años:</label><br> <br> <input
			type="text" name="criterio"
			placeholder="Introduce un dato del empleado" required> <br>
		<br>

		<button type="submit">Buscar</button>
	</form>

	<br>
	<button type="button" onclick="window.location.href='../index.jsp'">Volver</button>
</body>

</html>
