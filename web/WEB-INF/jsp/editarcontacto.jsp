<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ol class="breadcrumb">
  <li><a href="#"><spring:message code='etiqueta.editarcontactoid'/> ${numerocontacto}</a></li>
</ol>    
<div class="contact-form">
    <form class="form-horizontal col-md-8" role="form" id="actualizarcon" name="actualizarcon" method="POST" action="actualizarcon" commandName="contacts" enctype="multipart/form-data">
 
        <div class="form-group">
            <label for="id" class="col-md-2"><spring:message code='etiqueta.idcontacto'/></label>
            <div class="col-md-10">
                <input type="text" path="id" name="id" class="form-control" id="id" value="${contacts.id}" readonly="true"    >
            </div>
        </div>        
        
        <div class="form-group">
            <label for="name" class="col-md-2"><spring:message code='etiqueta.nombrecontacto'/></label>
            <div class="col-md-10">
                <input type="text" path="name" class="form-control" id="name" name="name" required="true" value="${contacts.name}">
            </div>
        </div>
 
        <div class="form-group">
            <label for="phone" class="col-md-2"><spring:message code='etiqueta.telefonocontacto'/></label>
            <div class="col-md-10">
                <input type="text" path="phone" min="9" maxlength="9" class="form-control" id="phone" name="phone" required="true" value="${contacts.phone}">
            </div>
        </div>
            
       <div class="form-group">
            <label for="sel1" class="col-md-2"><spring:message code='etiqueta.nombregrupo'/></label>
            <div class="col-md-10">
                <select class="form-control" id="group_id" name="groupId" path="groupId">

                    <c:forEach varStatus="status" items="${listag}" var="grupos">
                        <c:if test="${grupoContacto.id == grupos.id}">
                            <option path="groupId" selected="selected" value="${grupos.id}">${grupos.name} - ${grupos.description}</option>
                        </c:if>
                        <c:if test="${grupoContacto.id != grupos.id}">
                            <option path="groupId" value="${grupos.id}">${grupos.name} - ${grupos.description}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
        </div>         
                        

       <div class="form-group">
            <label for="email" class="col-md-2"><spring:message code='etiqueta.correoscontacto'/></label>
            <div class="col-md-10">
                <c:if test="${totalcorreos == '0'}">
                    <input type="text" id="correo1" name="correo1" class="form-control" placeholder="<spring:message code='etiqueta.correoscontacto'/>">
                    </br> 
                    <input type="text" id="correo2" name="correo2" class="form-control" placeholder="<spring:message code='etiqueta.correoscontacto'/>">
                </c:if>
                <c:if test="${totalcorreos == '1'}">
                    <c:forEach varStatus="status" items="${listacorreos}" var="correos">
                        <input type="text" id="correo1" name="correo1" class="form-control" value="${correos.address}" />
                    </c:forEach>
                    <input type="text" id="correo2" name="correo2" class="form-control" placeholder="<spring:message code='etiqueta.correoscontacto'/>">
                </c:if>        
                <c:if test="${totalcorreos == '2'}">
                    <c:forEach varStatus="status" items="${listacorreos}" var="correos">
                        <input type="text" id="correo${status.index+1}" name="correo${status.index+1}" class="form-control" value="${correos.address}" />
                    </c:forEach>
                </c:if>      
            </div>        
        </div> 
            
 
        <div class="form-group">
            <label for="picture" class="col-md-2"><spring:message code='etiqueta.imagencontacto'/></label>
            <div class="col-md-10">
                <input path="pictureUrl" type="text" id="pictureUrl" name="pictureUrl" class="form-control" value="${img}" readonly="true" />
                <img src="${pageContext.request.contextPath}/recursos/contactos/${img}" alt="..." style="text-align: center; width: 10% !important">
                </br>
                <input id="file" type="file" name="file" />
            </div>
        </div>            
        
        <div class="form-group">
            <div class="col-md-12 text-right">
                <button type="submit" onclick="pillaCorreosEditar()" class="btn btn-lg btn-primary"><spring:message code='etiqueta.botonactualizarcontacto'/></button>
            </div>
        </div>
    </form>
</div>
</br></br></br></br>