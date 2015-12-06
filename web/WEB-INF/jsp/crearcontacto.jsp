<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="container">
<ol class="breadcrumb col-md-10">
  <li><a href="#"><spring:message code='etiqueta.crearcontacto'/></a></li>
</ol>    
<div class="contact-form">
    <form class="form-horizontal col-md-8" role="form" id="crearcon" name="crearcon" method="POST" action="crearcon" commandName="contacts" modelAttribute="listag" enctype="multipart/form-data">
 
        <div class="form-group">
            <label for="name" class="col-md-2"><spring:message code='etiqueta.nombrecontacto'/></label>
            <div class="col-md-10">
                <input type="text" path="name" class="form-control" id="name" name="name" required="true"  placeholder="<spring:message code='etiqueta.nombrecontacto'/>">
            </div>
        </div>
 
        <div class="form-group">
            <label for="phone" class="col-md-2"><spring:message code='etiqueta.telefonocontacto'/></label>
            <div class="col-md-10">
                <input type="text" path="phone" min="9" maxlength="9" class="form-control" id="phone" name="phone" required="true" placeholder="<spring:message code='etiqueta.telefonocontacto'/>">
            </div>
        </div>
        
              
       <div class="form-group">
            <label for="sel1" class="col-md-2"><spring:message code='etiqueta.nombregrupo'/></label>
            <div class="col-md-10">
                <select class="form-control" id="group_id" name="groupId" path="groupId">
                    <c:forEach varStatus="status" items="${listag}" var="grupos">
                        <option path="groupId" value="${grupos.id}">${grupos.name} - ${grupos.description}</option>
                    </c:forEach>
                </select>
            </div>
        </div>      
            
            
       <div class="form-group">
            <label for="email" class="col-md-2"><spring:message code='etiqueta.correoscontacto'/></label>
            <div class="col-md-10">
                <input type="email" id="correo1" name="correo1" class="form-control" placeholder="<spring:message code='etiqueta.correoscontacto'/>">
                </br> 
                <input type="email" id="correo2" name="correo2" class="form-control" placeholder="<spring:message code='etiqueta.correoscontacto'/>">
            </div>        
        </div>                
 
        <div class="form-group">
            <label for="picture" class="col-md-2"><spring:message code='etiqueta.imagencontacto'/></label>
            <div class="col-md-10">
                <input id="file" type="file" name="file" />
            </div>
        </div>
            
        <div class="form-group">
            <div class="col-md-12 text-right">
                <button type="submit" onclick="pillaCorreos()" class="btn btn-lg btn-primary"><spring:message code='etiqueta.botonaddcontacto'/></button>
            </div>
        </div>
    </form>
</div>
</div>