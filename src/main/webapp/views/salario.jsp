<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Buscar Salario</title>
</head>
<body>
    <h1>Buscar salario de un empleado</h1>

    <form action="empleados" method="post">
        <input type="hidden" name="opcion" value="buscarSalario">
        <label>DNI del empleado:</label>
        <input type="text" name="dni" required>
        <input type="submit" value="Mostrar salario">
    </form>

    <c:if test="${not empty mensaje}">
        <p style="color:red;"><c:out value="${mensaje}"/></p>
    </c:if>

    <br>
    <button type="button" onclick="window.location.href='index.jsp'">Volver</button>
</body>
</html>
