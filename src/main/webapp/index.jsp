<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath"
       value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">

    <title>Caballos</title>
</head>
<body>
<h1>Caballos </h1>
<form  action="${contextPath}/miPrimerServlet" method="post">
    <label for="name">Nombre:</label>
    <input type="text" id="name" name="name">
    <label for="origen">Origen:</label>
    <input type="text" id="origen" name="origen">
    <label for="color">Color:</label>
    <input type="text" id="color" name="color">
    <label for="edad">Edad:</label>
    <input type="number" id="edad" name="edad">
    <label for="velocidad">Velocidad máxima:</label>
    <input type="number" id="velocidad" name="velocidad">

    <button type="submit">Submit</button>
</form>
</body>
</html>