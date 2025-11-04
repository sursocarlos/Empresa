<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Empleado</title>
</head>
<body>
	<h1>Editar Empleado</h1>
	<form action="empleados" method="post">
		<c:set var="empleado" value="${empleado}"></c:set>
		<input type="hidden" name="opcion" value="editar"> <input
			type="hidden" name="dni" value="${empleado.dni}">
		<table border="1">
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="nombre" size="50"
					value="${empleado.nombre}"></td>
			</tr>

			  
			<tr>
				<td>Sexo:</td>
				<td><input type="text" name="sexo" size=1 value="${empleados.sexo}">
				</td>
			</tr>	
			

			
			<tr>
				<td>Años:</td>
				<td><input type="text" name="anyos" size="50"
					value="${empleado.anyos}"></td>
			</tr>
			<tr>
				<td>Categoria:</td>
				<td><input type="text" name="categoria" size="50"
					value="${empleado.categoria}"></td>
			</tr>
		</table>
		<br> <input type="submit" value="Guardar">
		<button type="button"
			onclick="window.location.href='empleados?opcion=listar'">Volver</button>


	</form>
</body>
</html>
