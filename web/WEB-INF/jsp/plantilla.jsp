<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="<c:url value="recursos/css/css.css" />" rel="stylesheet">
        <link href="<c:url value="recursos/css/bootstrap.css" />" rel="stylesheet">
        <link href="<c:url value="recursos/css/bootstrap-theme.css" />" rel="stylesheet">
        <script src="<c:url value="recursos/js/jquery-1.11.3.js" />"></script>
        <script src="<c:url value="recursos/js/jquery-1.11.3.min.js" />"></script>
        <script src="<c:url value="recursos/js/jquery-2.1.4.js" />"></script>
        <script src="<c:url value="recursos/js/bootstrap.js" />"></script>
        <script src="<c:url value="recursos/js/bootstrap.min.js" />"></script>
        <script src="<c:url value="recursos/js/dropdown.js" />"></script>
        <script src="<c:url value="recursos/js/buscarNombre.js" />"></script>
        <script src="<c:url value="recursos/js/pillaCorreos.js" />"></script>
        <script src="<c:url value="recursos/js/pillaCorreosEditar.js" />"></script>
        <script>var rutajs = "${pageContext.request.contextPath}"</script>
        <title><spring:message code="etiqueta.tituloNavegador" /></title>
</head>
<body>
        <!-- Menu Cabecera. Fijo -->      
	<tiles:insertAttribute name="cabecera" />
         <!-- Cuerpo con los distintos jsp. Variable -->
	<div id="container">
		<tiles:insertAttribute name="cuerpo" />
	</div>
         <!-- Pie. Footer. Fijo -->
	<tiles:insertAttribute name="pie" />
</body>
</html>