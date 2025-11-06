<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Salario del Empleado</title>
</head>
<body>
    <h1>Salario del empleado</h1>

    <p><b>DNI:</b> <c:out value="${empleado.dni}"/></p>
    <p><b>Nombre:</b> <c:out value="${empleado.nombre}"/></p>
    <p><b>Categoría:</b> <c:out value="${empleado.categoria}"/></p>
    <p><b>Años trabajados:</b> <c:out value="${empleado.anyos}"/></p>
    <p><b>Salario:</b> <c:out value="${salario}"/></p>

    <br>
    <button type="button" onclick="window.location.href='index.jsp'">Volver</button>
</body>
</html>
