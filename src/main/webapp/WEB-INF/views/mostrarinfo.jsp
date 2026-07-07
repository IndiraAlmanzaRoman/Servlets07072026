<%--
  Created by IntelliJ IDEA.
  User: Helena
  Date: 06/07/2026
  Time: 08:43 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">

    <title>Caballos</title>
</head>
<body>
<h1>Caballos</h1>
<p>Nombre: ${caballos.name} </p>
<p>Origen: ${caballos.origen} </p>
<p>Color: ${caballos.color} </p>
<p>Edad: ${caballos.edad} </p>
<p>Velocidad máxima: ${caballos.velocidad} </p>

</body>
</html>
