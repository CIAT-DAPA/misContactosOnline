<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading"><h1><spring:message code="etiqueta.pregunta" /></h1></div>
  <div class="panel-body">
  <c:forEach varStatus="status" items="${listaEnlaces}" var="links">
    <p>${links.name} : <a target="_blank" href="${links.link}">${links.link}</a></p>        
  </c:forEach>      

  </div>

  <!-- Table -->
  <table class="table">
        <tr>
           <th><spring:message code="etiqueta.idNumerando" /></th>
           <th><spring:message code="etiqueta.nombrandoNombre" /></th>
           <th><spring:message code="etiqueta.email" /></th>
        </tr>
        <c:forEach varStatus="status" items="${listaAutores}" var="autores">
            <tr>
                <td>${autores.id}</td>
                <td>${autores.nombre}</td>
                <td><a href="mailto:${autores.contacto}" />${autores.contacto}</a></td>
            </tr>
        </c:forEach>
  </table>
</div>      
</br></br>