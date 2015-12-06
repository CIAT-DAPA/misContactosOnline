<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test='${accion == "editar"}'>
    <div class="alert alert-success alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <spring:message code="etiqueta.editcontactosbien" />
    </div>
 </c:if>


 <c:if test='${accion == "añadir"}'>
    <div class="alert alert-success alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <spring:message code="etiqueta.addcontactosbien" />
    </div>
 </c:if>
  
 <c:if test='${accion == "borrar"}'>
    <div class="alert alert-success alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <spring:message code="etiqueta.deletecontactosbien" />
    </div>
 </c:if>
 
<c:if test='${accion == "buscando"}'>
    <div class="alert alert-success alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <spring:message code="etiqueta.buscandopornombrecontacto" />
    </div>
</c:if>
 
 <c:if test='${accion == "busquedaporgrupo"}'>
    <div class="alert alert-success alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <spring:message code="etiqueta.buscandoporgrupo" />
    </div>
</c:if>
 
<div class="panel panel-default">
  <div class="panel-heading">
    <c:if test='${general == "listar"}'>
        <h3 class="panel-title"><h1><spring:message code="etiqueta.listarcontacto" />. <spring:message code="etiqueta.totalcontactos" />  (${total})</h1></h3>
    </c:if>      
    <c:if test='${accion == "buscando"}'>
        <h3 class="panel-title"><h1><spring:message code="etiqueta.buscandopornombrecontacto" /></h1></h3>
    </c:if>
    <c:if test='${accion == "busquedaporgrupo"}'>
        <h3 class="panel-title"><h1><spring:message code="etiqueta.buscandoporgrupo" /> [${buscandoporID}] <spring:message code="etiqueta.totalcontactos" /> ${countCon}</h1></h3>
    </c:if>    
  </div>
  <div class="panel-body">
    <div class="row">
    <c:if test="${empty listaco}" >
        <div class="alert alert-warning alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h1><spring:message code="etiqueta.noresultadocontactos" /></h1>
        </div>
    </c:if>    
    <c:forEach varStatus="status" items="${listaco}" var="contacts"> 
        <div class="col-sm-3 col-md-3">
        <div class="thumbnail">
            <img src="${pageContext.request.contextPath}/recursos/contactos/${contacts.pictureUrl}" alt="..." style="text-align: center; width: 20% !important">
            <div class="caption">
                <h3>${contacts.name}</h3>
                <p><spring:message code="etiqueta.telefonocontacto" /> ${contacts.phone}</p>
                <p><spring:message code="etiqueta.grupocontacto" /> ${contacts.groupName}</p>
                <p><spring:message code="etiqueta.correoscontacto" /></p>
                    <c:forEach varStatus="status" items="${contacts.emailses}" var="email">
                        <p>${email.address}</p>
                    </c:forEach>
                <p>
                    <a href="${pageContext.request.contextPath}/editarContacto?id=${contacts.id}" class="btn btn-warning" role="button"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a> 
                    <a href="${pageContext.request.contextPath}/borrarContacto?id=${contacts.id}" class="btn btn-danger" role="button"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
                </p>
            </div>
        </div>
        </div>
    </c:forEach>  
    </div>   
  </div>
</div>    
<div class="form-group">
    <div class="col-md-12 text-right">
        <a href="${pageContext.request.contextPath}/crearContacto" type="submit" class="btn btn-lg btn-primary"><spring:message code='etiqueta.botonaddcontacto'/></a>
    </div>
</div>    
    
</br></br></br></br>