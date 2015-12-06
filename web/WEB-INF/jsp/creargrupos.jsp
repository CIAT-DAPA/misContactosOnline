<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="container">
<ol class="breadcrumb col-md-10">
  <li><a href="#"><spring:message code='etiqueta.creargrupo'/></a></li>
</ol>    
<div class="contact-form">
    <form class="form-horizontal col-md-8" role="form" method="POST" action="crear" commandName="groups">
 
        <div class="form-group">
            <label for="name" class="col-md-2"><spring:message code='etiqueta.nombregrupo'/></label>
            <div class="col-md-10">
                <input type="text" path="name" name="name" class="form-control" id="name" required="true"  placeholder="<spring:message code='etiqueta.nombregrupo'/>">
            </div>
        </div>
 
        <div class="form-group">
            <label for="name" class="col-md-2"><spring:message code='etiqueta.descripciongrupo'/></label>
            <div class="col-md-10">
                <input type="text" path="description" name="description" class="form-control" id="description" placeholder="<spring:message code='etiqueta.descripciongrupo'/>">
            </div>
        </div>
        
        <div class="form-group">
            <div class="col-md-12 text-right">
                <button type="submit" class="btn btn-lg btn-primary"><spring:message code='etiqueta.botonaddgrupo'/></button>
            </div>
        </div>
    </form>
</div>
</div>