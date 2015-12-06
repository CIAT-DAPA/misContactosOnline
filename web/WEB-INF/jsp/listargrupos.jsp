<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="alert alert-info" role="alert"><spring:message code="etiqueta.mensajegrupos" /></div>

 <c:if test='${accion == "editar"}'>
    <div class="alert alert-success alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <spring:message code="etiqueta.editgruposbien" />
    </div>
 </c:if>


 <c:if test='${accion == "añadir"}'>
    <div class="alert alert-success alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <spring:message code="etiqueta.addgruposbien" />
    </div>
 </c:if>
  
 <c:if test='${accion == "borrar"}'>
    <div class="alert alert-success alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <spring:message code="etiqueta.deletegruposbien" />
    </div>
 </c:if>


 <c:if test='${accion == "borrargrupodefecto"}'>
    <div class="alert alert-danger alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <spring:message code="etiqueta.deletegrupodefault" />
    </div>
 </c:if>

<div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading"><h1><spring:message code="etiqueta.listargrupo" />. <spring:message code="etiqueta.totalgrupos" />  (${total})</h1></div>
  <!-- Table -->
  <table class="table">
        <tr>
           <th><spring:message code="etiqueta.idNumerando" /></th>
           <th><spring:message code="etiqueta.nombregrupo" /></th>
           <th><spring:message code="etiqueta.descripciongrupo" /></th>
           <th>Total</th>
           <th><spring:message code="etiqueta.accionesgrupo" /></th>
        </tr>
        <c:forEach varStatus="status" items="${listag}" var="grupos">
            <tr>
                <td>${grupos.id}</td>
                <td>${grupos.name}</td>
                <td>${grupos.description}</td>
                <td>${totalbygroup[status.index]}</td>              
                <td>
                    <a href="${pageContext.request.contextPath}/listarcontactoByGroup?id=${grupos.id}" type="button" class="btn btn-default">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                    </a>
                    <a href="${pageContext.request.contextPath}/editarGrupo?id=${grupos.id}" type="button" class="btn btn-warning">
                        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                    </a>
                    <a href="${pageContext.request.contextPath}/borrarGrupo?id=${grupos.id}" type="button" class="btn btn-danger">
                        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                    </a>                    
                </td>
            </tr>
        </c:forEach>
  </table>
</div>
<div class="form-group">
    <div class="col-md-12 text-right">
        <a href="${pageContext.request.contextPath}/crearGrupos" type="submit" class="btn btn-lg btn-primary"><spring:message code='etiqueta.botonaddgrupo'/></a>
    </div>
</div>      
</br></br></br></br>