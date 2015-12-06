<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ol class="breadcrumb">
  <li><a href="#"><spring:message code='etiqueta.botoneditargrupo'/> ${numerogrupo}</a></li>
</ol>    
<div class="contact-form">
    <form class="form-horizontal col-md-8" role="form" method="POST" action="actualizar" commandName="groups">
 
        <div class="form-group">
            <label for="id" class="col-md-2"><spring:message code='etiqueta.idgrupo'/></label>
            <div class="col-md-10">
                <input type="text" path="id" name="id" class="form-control" id="id" value="${groups.id}" readonly="true"    >
            </div>
        </div>        
        
        <div class="form-group">
            <label for="name" class="col-md-2"><spring:message code='etiqueta.nombregrupo'/></label>
            <div class="col-md-10">
                <input type="text" path="name" name="name" class="form-control" id="name" required="true"  value="${groups.name}"></input>
            </div>
        </div>
 
        <div class="form-group">
            <label for="name" class="col-md-2"><spring:message code='etiqueta.descripciongrupo'/></label>
            <div class="col-md-10">
                <input type="text" path="description" name="description" class="form-control" id="description" value="${groups.description}">
            </div>
        </div>
        
        <div class="form-group">
            <div class="col-md-12 text-right">
                <button type="submit" class="btn btn-lg btn-primary"><spring:message code='etiqueta.botonactualizargrupo'/></button>
            </div>
        </div>
    </form>
</div>
</br></br></br></br>