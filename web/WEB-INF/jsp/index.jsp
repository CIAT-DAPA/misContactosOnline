<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container">
      <div class="jumbotron">
        <h1><spring:message code='etiqueta.proyecto'/></h1>
        <p><spring:message code='etiqueta.bienvenida'/></p>
        <p>
          <a class="btn btn-lg btn-primary" href="${pageContext.request.contextPath}/autores" role="button"><spring:message code='etiqueta.autor'/></a>
        </p>
      </div>

    </div> <!-- /container -->
