<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<div id="container">      
    <nav class="navbar navbar-default">
      <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="${pageContext.request.contextPath}/"><spring:message code="etiqueta.proyecto" /></a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav">
            <li><a href="${pageContext.request.contextPath}/"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>  <spring:message code="etiqueta.inicio" /> </a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>&nbsp;<spring:message code="etiqueta.grupo" /> <span class="caret"></span></a>  
              <ul class="dropdown-menu">
                  <li><a href="${pageContext.request.contextPath}/crearGrupos"><spring:message code="etiqueta.creargrupo" /></a></li>
                <li><a href="${pageContext.request.contextPath}/listarGrupos"><spring:message code="etiqueta.listargrupo" /></a></li>
              </ul>
            </li>                    
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>  <spring:message code="etiqueta.contacto" /> <span class="caret"></span></a>  
              <ul class="dropdown-menu">
                  <li><a href="${pageContext.request.contextPath}/crearContacto"><spring:message code="etiqueta.crearcontacto" /></a></li>
                <li><a href="${pageContext.request.contextPath}/listarContacto"><spring:message code="etiqueta.listarcontacto" /></a></li>
              </ul>
            </li>                              
            <li><a href="${pageContext.request.contextPath}/autores"><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>  <spring:message code="etiqueta.autor" /> </a></li>              
            <li class="dropdown">
              <c:if test="${pageContext.response.locale == 'es'}">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><img style="width:25% !important;height: auto !important;" src="<c:url value="recursos/imagenes/es.png"/>" /> <spring:message code="etiqueta.idiomaEs" /><span class="caret"></span></a>
              </c:if>
              <c:if test="${pageContext.response.locale == 'en'}">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><img style="width:25% !important;height: auto !important;" src="<c:url value="recursos/imagenes/en.png"/>" /> <spring:message code="etiqueta.idiomaIn" /><span class="caret"></span></a>
              </c:if>            
              <ul class="dropdown-menu">
                  <li><a href="${pageContext.request.contextPath}/${ruta}idioma=es"><img style="width:20% !important;height: auto !important;" src="<c:url value="recursos/imagenes/es.png"/>" /> <spring:message code="etiqueta.idiomaEs" /></a></li>                
                    <li><a href="${pageContext.request.contextPath}/${ruta}idioma=en"><img style="width:20% !important;height: auto !important;" src="<c:url value="recursos/imagenes/en.png"/>" /> <spring:message code="etiqueta.idiomaIn" /></a></li>
              </ul>
            </li>          
          </ul>
          <form class="navbar-form navbar-left" role="search" name="search" id="search">
            <div class="form-group">
              <input type="text" class="form-control" id="nombrebuscar" name="nombrebuscar" onchange="buscarNombre()" placeholder="<spring:message code="etiqueta.buscapornombre" /> ">
            </div>
              <a type="submit" class="btn btn-default" onclick="buscarNombre()"><spring:message code="etiqueta.botonbuscar" /></a>
          </form>
          <p class="navbar-text pull-right">
                <spring:message code="etiqueta.lenguage" /> ${idioma}
          </p>     
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container-fluid -->
    </nav>        
     </div>
