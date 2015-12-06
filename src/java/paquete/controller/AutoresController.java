/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.controller;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import paquete.dao.AutoresDAO;
import paquete.dao.ContactsDAO;
import paquete.dao.EmailsDAO;
import paquete.dao.GroupsDAO;
import paquete.dao.LinksDAO;
import paquete.model.Autores;
import paquete.model.Contacts;
import paquete.model.Emails;
import paquete.model.Groups;
import paquete.model.Links;

/**
 *
 * @author Daniel
 */
@Controller
//@RequestMapping(value="/")
public class AutoresController {
    
        @Autowired
        private LinksDAO linksDAO;    
        @Autowired
        private AutoresDAO autoresDAO;
        @Autowired
        private GroupsDAO groupsDAO;
        @Autowired
        private ContactsDAO contactsDAO;
        @Autowired
        private EmailsDAO emailsDAO;
     
        //@RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
        @RequestMapping(value = {"/","/index"})
	public String index(ModelMap model, Locale locale) {
                model.addAttribute("idioma", locale.getDisplayName() + "-" + locale.getLanguage());
                model.addAttribute("ruta", "index?");
                return "index";
	}
        
        @RequestMapping(value = "/crearGrupos", method = RequestMethod.GET)
	public String creargrupos(ModelMap model, Locale locale) {
                model.addAttribute("idioma", locale.getDisplayName() + "-" + locale.getLanguage());
                model.addAttribute("ruta", "crearGrupos?");
                model.addAttribute("groups", new Groups());
                return "creargrupos";
	}
        
        @RequestMapping(value = "/crear", method = RequestMethod.POST)
	public String crear (ModelMap model, Locale locale, @ModelAttribute("groups") Groups groups) {
                model.addAttribute("idioma", locale.getDisplayName() + "-" + locale.getLanguage());
                model.addAttribute("ruta", "listarGrupos?");      
                groupsDAO.añadirGrupo(groups);
                List<Groups> listag = groupsDAO.listarGrupos();
                model.addAttribute("listag", listag);
                int totalGrupos = (int)groupsDAO.totalGrupos();
                model.addAttribute("total", totalGrupos);
                model.addAttribute("accion", "añadir");
                ArrayList<Integer> grupos = new ArrayList<Integer>();
                for(int i = 0;i<listag.size();i++){
                    grupos.add(contactsDAO.listarContactosByGroupCount(listag.get(i).getId()));
                }
                model.addAttribute("totalbygroup", grupos);
                return "listargrupos";
	}        
     
        @RequestMapping(value = "/editarGrupo", method = RequestMethod.GET)
	public String editarGrupos(ModelMap model, Locale locale, HttpServletRequest request) {
                model.addAttribute("idioma", locale.getDisplayName() + "-" + locale.getLanguage());
                int groupId = Integer.parseInt(request.getParameter("id"));
                model.addAttribute("ruta", "editarGrupo?id="+Integer.parseInt(request.getParameter("id"))+"&");
                //if(!groupId) {
                    model.addAttribute("numerogrupo", groupId);
                    Groups g = groupsDAO.dameGrupo(groupId);
                    model.addAttribute("groups", g);
                //}
                return "editargrupo";
	}         
        
        @RequestMapping(value = "/actualizar", method = RequestMethod.POST)
	public String actualizar (ModelMap model, Locale locale, @ModelAttribute("groups") Groups groups) {
                model.addAttribute("idioma", locale.getDisplayName() + "-" + locale.getLanguage());
                model.addAttribute("ruta", "listarGrupos?");    
                groupsDAO.editarGrupo(groups);
                List<Groups> listag = groupsDAO.listarGrupos();
                model.addAttribute("listag", listag);
                int totalGrupos = (int)groupsDAO.totalGrupos();
                model.addAttribute("total", totalGrupos);
                model.addAttribute("accion", "editar");
                ArrayList<Integer> grupos = new ArrayList<Integer>();
                for(int i = 0;i<listag.size();i++){
                    grupos.add(contactsDAO.listarContactosByGroupCount(listag.get(i).getId()));
                }
                model.addAttribute("totalbygroup", grupos);
                return "listargrupos";
	} 
        
        @RequestMapping(value = "/listarGrupos", method = RequestMethod.GET)
	public String listargrupos(ModelMap model, Locale locale) {
                model.addAttribute("idioma", locale.getDisplayName() + "-" + locale.getLanguage());
                model.addAttribute("ruta", "listarGrupos?");
                
                List<Groups> listag = groupsDAO.listarGrupos();
                model.addAttribute("listag", listag);
                
                int totalGrupos = (int)groupsDAO.totalGrupos();
                model.addAttribute("total", totalGrupos); 
                               

                ArrayList<Integer> grupos = new ArrayList<Integer>();
                for(int i = 0;i<listag.size();i++){
                    grupos.add(contactsDAO.listarContactosByGroupCount(listag.get(i).getId()));
                }
                model.addAttribute("totalbygroup", grupos);
                                                                   
                return "listargrupos";
	}
        
        //Funciona bien, pero no muestra los mensajes de borrado con exito
//        @RequestMapping(value = "/borrarGrupo/{id}", method = RequestMethod.GET)
//	public String borrargrupos(ModelMap model, @PathVariable("id") int id) {
//                if(id==3){                   
//                    return "redirect:/listarGrupos";
//                }
//                else {
//                   groupsDAO.borrarGrupo(id); 
//                }
//                return "redirect:/listarGrupos";
//	}  
      
        @RequestMapping(value = "/listarcontactoByGroup")
        public String listarcontactoByGroup(ModelMap model, Locale locale, HttpServletRequest request) {
                model.addAttribute("idioma", locale.getDisplayName() + "-" + locale.getLanguage());
                int groupId = Integer.parseInt(request.getParameter("id"));
                model.addAttribute("ruta", "listarcontactoByGroup?id="+Integer.parseInt(request.getParameter("id"))+"&");
                List<Contacts> listaco = contactsDAO.listarContactosByGroup(groupId);
                int countCon = contactsDAO.listarContactosByGroupCount(groupId);               
                for(int i = 0;i<listaco.size();i++){
                    int group_id = listaco.get(i).getGroupId();
                    Groups g = groupsDAO.dameGrupo(group_id);
                    listaco.get(i).setGroupName(g.getName());
                }
                model.addAttribute("buscandoporID", groupsDAO.dameGrupo(groupId).getName());
                model.addAttribute("countCon", countCon);
                model.addAttribute("listaco", listaco);
                model.addAttribute("accion", "busquedaporgrupo");
                
                return "listarcontactos";
        }
        
        
        
        
        @RequestMapping(value = "/borrarGrupo", method = RequestMethod.GET)
        public String borrargrupos(ModelMap model, Locale locale, HttpServletRequest request) {
                model.addAttribute("idioma", locale.getDisplayName() + "-" + locale.getLanguage());
                model.addAttribute("ruta", "listarGrupos?");
                int groupId = Integer.parseInt(request.getParameter("id"));                              
//                if(groupId==3){                   
//                    model.addAttribute("accion", "borrargrupodefecto");
//                }
//                else{
//                   groupsDAO.borrarGrupo(groupId);
//                   model.addAttribute("accion", "borrar");
//                }
                if(groupId!=3){      
                   model.addAttribute("accion", "borrar");
                   groupsDAO.borrarGrupo(groupId);                 
                }
                else if(groupId==3){
                    model.addAttribute("accion", "borrargrupodefecto");
                }                
                List<Groups> listag = groupsDAO.listarGrupos();
                model.addAttribute("listag", listag);
                int totalGrupos = (int)groupsDAO.totalGrupos();
                model.addAttribute("total", totalGrupos); 
                
                ArrayList<Integer> grupos = new ArrayList<Integer>();
                for(int i = 0;i<listag.size();i++){
                    grupos.add(contactsDAO.listarContactosByGroupCount(listag.get(i).getId()));
                }
                model.addAttribute("totalbygroup", grupos);
                return "listargrupos";
	} 
        
        
//        @RequestMapping(value = "/borrarGrupo", method = RequestMethod.GET)
//	public String borrargrupos(ModelMap model, Locale locale, HttpServletRequest request) {
//                model.addAttribute("idioma", locale.getDisplayName() + "-" + locale.getLanguage());
//                int groupId = Integer.parseInt(request.getParameter("id"));
//                model.addAttribute("ruta", "editarGrupo?id="+Integer.parseInt(request.getParameter("id"))+"&");
//                List<Groups> listag = groupsDAO.listarGrupos();
//                model.addAttribute("listag", listag);
//                int totalGrupos = (int)groupsDAO.totalGrupos();
//                model.addAttribute("total", totalGrupos);                               
//                if(id==3){                   
//                    model.addAttribute("accion", "borrar");
//                }
//                else {
//                   groupsDAO.borrarGrupo(id);
//                   model.addAttribute("accion", "borrargrupodefecto");
//                }
//                return "listargrupos";
//	}         

        
        @RequestMapping(value = "/buscarContacto")
	public String buscarcontacto(ModelMap model, Locale locale, HttpServletRequest request) {
                model.addAttribute("idioma", locale.getDisplayName() + "-" + locale.getLanguage());
               // model.addAttribute("ruta", "listarContacto?");
                String nombre = request.getParameter("nombrebuscar");
                model.addAttribute("ruta", "buscarContacto?nombrebuscar="+nombre+"&");
                int totalContactos = (int)contactsDAO.totalContactos();
                model.addAttribute("total", totalContactos); 
                model.addAttribute("accion", "buscando");             
                List<Contacts> listaco = contactsDAO.busqueda(nombre);
                for(int i = 0;i<listaco.size();i++){
                    int group_id = listaco.get(i).getGroupId();
                    Groups g = groupsDAO.dameGrupo(group_id);
                    listaco.get(i).setGroupName(g.getName());
                }                
                model.addAttribute("listaco", listaco);
		return "listarcontactos";
	}         
        
        
        @RequestMapping(value = "/crearContacto")
	public String crearcontacto(ModelMap model, Locale locale) {
                model.addAttribute("idioma", locale.getDisplayName() + "-" + locale.getLanguage());
                model.addAttribute("ruta", "crearContacto?");
                model.addAttribute("contacts", new Contacts());
                //model.addAttribute("groups", new Groups());
                //model.addAttribute("emails", new Emails());
                List<Groups> listag = groupsDAO.listarGrupos();
                model.addAttribute("listag", listag);
                return "crearcontacto";
	}
        
        
        @RequestMapping(value = "/crearcon", method = RequestMethod.POST)
	//public String crearcon (ModelMap model, Locale locale, @ModelAttribute("contacts") Contacts contacts, @ModelAttribute("groups") Groups groups) {
        public String crearcon (ModelMap model, Locale locale, @ModelAttribute("contacts") Contacts contacts, @RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
                model.addAttribute("idioma", locale.getDisplayName() + "-" + locale.getLanguage());
                model.addAttribute("ruta", "listarContacto?");
                String correo1 = request.getParameter("correo1");
                String correo2 = request.getParameter("correo2");

                Contacts nuevo = new Contacts();
                nuevo.setName(contacts.getName());
                nuevo.setPhone(contacts.getPhone());
                nuevo.setGroupId(contacts.getGroupId());
                              
                if(file.isEmpty()){
                    nuevo.setPictureUrl("default.png");
                }                   
                else if (!file.isEmpty()) {
                    byte[] bytes = file.getBytes();
                    Date date = new Date();
                    File serverFile= new File(request.getSession().getServletContext().getRealPath("/WEB-INF/recursos/contactos/"), date.getTime()+file.getOriginalFilename());
                    try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile))) {
                        stream.write(bytes);
                    }
                    nuevo.setPictureUrl(date.getTime()+file.getOriginalFilename());
                }
                                                               
                contactsDAO.añadirContacto(nuevo);                
                if(!correo1.isEmpty()){
                    Emails e = new Emails();
                    e.setAddress(correo1);
                    e.setContacts(nuevo);               
                    emailsDAO.añadirCorreo(e);
                }
                if(!correo2.isEmpty()){
                    Emails e = new Emails();
                    e.setAddress(correo2);
                    e.setContacts(nuevo);               
                    emailsDAO.añadirCorreo(e);
                }
              
                int totalContactos = (int)contactsDAO.totalContactos();
                model.addAttribute("total", totalContactos);
                List<Contacts> listaco = contactsDAO.listarContactos();
                for(int i = 0;i<listaco.size();i++){
                    int group_id = listaco.get(i).getGroupId();
                    Groups g = groupsDAO.dameGrupo(group_id);
                    listaco.get(i).setGroupName(g.getName());
                }
                model.addAttribute("listaco", listaco);
                model.addAttribute("general", "listar");
                model.addAttribute("accion", "añadir");
		return "listarcontactos";
	}
        
        @RequestMapping(value = "/editarContacto", method = RequestMethod.GET)
	public String editarContacto(ModelMap model, Locale locale, HttpServletRequest request) {
                model.addAttribute("idioma", locale.getDisplayName() + "-" + locale.getLanguage());
                int contactId = Integer.parseInt(request.getParameter("id"));
                model.addAttribute("ruta", "editarContacto?id="+Integer.parseInt(request.getParameter("id"))+"&");
                
                model.addAttribute("numerocontacto", contactId);
                Contacts contact = contactsDAO.dameContacto(contactId);
                model.addAttribute("contacts", contact);
                
                Groups g = groupsDAO.dameGrupo(contact.getGroupId());               
                model.addAttribute("grupoContacto", g);
                                                            
                List<Groups> listag = groupsDAO.listarGrupos();
                model.addAttribute("listag", listag);
                
                List<Emails> listaCorreos = emailsDAO.listarEmails(contactId);               
                model.addAttribute("listacorreos", listaCorreos);
                model.addAttribute("totalcorreos", listaCorreos.size());
                
                model.addAttribute("img", contact.getPictureUrl());
                
                return "editarcontacto";
	} 
        
        
        @RequestMapping(value = "/actualizarcon", method = RequestMethod.POST)
	//public String crearcon (ModelMap model, Locale locale, @ModelAttribute("contacts") Contacts contacts, @ModelAttribute("groups") Groups groups) {
        public String actualizarcon (ModelMap model, Locale locale, @ModelAttribute("contacts") Contacts contacts, @RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
                model.addAttribute("idioma", locale.getDisplayName() + "-" + locale.getLanguage());
                model.addAttribute("ruta", "listarContacto?");
                String correo1 = request.getParameter("correo1");
                String correo2 = request.getParameter("correo2");

                Contacts nuevo = new Contacts();
                nuevo.setId(contacts.getId());
                nuevo.setName(contacts.getName());
                nuevo.setPhone(contacts.getPhone());
                nuevo.setGroupId(contacts.getGroupId());
                if(file.isEmpty()){
                    //nuevo.setPictureUrl("default.png");
                    //nuevo.setPictureUrl(file.getOriginalFilename());
                    nuevo.setPictureUrl(contacts.getPictureUrl());
                }                                 
                else if (!file.isEmpty()) {
                    byte[] bytes = file.getBytes();
                    Date date = new Date();
                    File serverFile= new File(request.getSession().getServletContext().getRealPath("/WEB-INF/recursos/contactos/"), date.getTime()+file.getOriginalFilename());
                    try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile))) {
                        stream.write(bytes);
                    }
                    nuevo.setPictureUrl(date.getTime()+file.getOriginalFilename());
                }
                
                 List<Emails> antiguos = emailsDAO.listarEmails(contacts.getId());

                 if(antiguos.isEmpty()){
                     antiguos.add(new Emails());
                     antiguos.add(new Emails());
                 }
                 if(antiguos.size() == 1){
                     antiguos.add(new Emails());
                 }

                 if(antiguos.get(0).getAddress() == null){
                     antiguos.get(0).setAddress("");
                 }
                 if(antiguos.get(1).getAddress() == null){
                     antiguos.get(1).setAddress("");
                 }

                 if(!correo1.isEmpty() && !correo2.isEmpty()){

                        if((!correo1.equals(antiguos.get(0).getAddress()) && !correo2.equals(antiguos.get(1).getAddress()) )){

                            emailsDAO.borrarEmail(antiguos.get(0).getId());
                            emailsDAO.borrarEmail(antiguos.get(1).getId());

                            Emails e = new Emails();
                            e.setAddress(correo1);
                            e.setContacts(nuevo);               
                            emailsDAO.añadirCorreo(e);

                            Emails e2 = new Emails();
                            e2.setAddress(correo2);
                            e2.setContacts(nuevo);               
                            emailsDAO.añadirCorreo(e2);

                        }else if(!correo1.equals(antiguos.get(0).getAddress())){

                                emailsDAO.borrarEmail(antiguos.get(0).getId());

                                Emails e = new Emails();
                                e.setAddress(correo1);
                                e.setContacts(nuevo);               
                                emailsDAO.añadirCorreo(e);              

                        }else if(!correo2.equals(antiguos.get(1).getAddress())){

                                emailsDAO.borrarEmail(antiguos.get(1).getId());

                                Emails e = new Emails();
                                e.setAddress(correo2);
                                e.setContacts(nuevo);               
                                emailsDAO.añadirCorreo(e);

                        }

                }
                if(correo1.isEmpty() && correo2.isEmpty()){
                    for(int i= 0;i<antiguos.size();i++){
                        emailsDAO.borrarEmail(antiguos.get(i).getId());
                    }
                }

                if(!correo1.isEmpty() && correo2.isEmpty()){
                    if(!correo1.equals(antiguos.get(0).getAddress()) ){

                        emailsDAO.borrarEmail(antiguos.get(0).getId());

                        emailsDAO.borrarEmail(antiguos.get(1).getId());

                        Emails e = new Emails();
                        e.setAddress(correo1);
                        e.setContacts(nuevo);               
                        emailsDAO.añadirCorreo(e);

                    }else{
                        emailsDAO.borrarEmail(antiguos.get(1).getId());
                    }
                }
                if(correo1.isEmpty() && !correo2.isEmpty()){
                    if(!correo2.equals(antiguos.get(1).getAddress()) ){

                            emailsDAO.borrarEmail(antiguos.get(0).getId());

                            emailsDAO.borrarEmail(antiguos.get(1).getId());

                            Emails e = new Emails();
                            e.setAddress(correo2);
                            e.setContacts(nuevo);               
                            emailsDAO.añadirCorreo(e);

                        }else{
                        emailsDAO.borrarEmail(antiguos.get(0).getId());
                    }

                }
                
                contactsDAO.editarContacto(nuevo); 
                
//                if(!correo1.isEmpty()){
//                    Emails e = new Emails();
//                    e.setAddress(correo1);
//                    e.setContacts(nuevo);               
//                    emailsDAO.añadirCorreo(e);
//                }
//                if(!correo2.isEmpty()){
//                    Emails e = new Emails();
//                    e.setAddress(correo2);
//                    e.setContacts(nuevo);               
//                    emailsDAO.añadirCorreo(e);
//                }
              
                int totalContactos = (int)contactsDAO.totalContactos();
                model.addAttribute("total", totalContactos);
                List<Contacts> listaco = contactsDAO.listarContactos();
                for(int i = 0;i<listaco.size();i++){
                    int group_id = listaco.get(i).getGroupId();
                    Groups g = groupsDAO.dameGrupo(group_id);
                    listaco.get(i).setGroupName(g.getName());
                }
                model.addAttribute("accion", "editar");
                model.addAttribute("general", "listar");
                model.addAttribute("listaco", listaco);
		return "listarcontactos";
	}        
        
        @RequestMapping(value = "/listarContacto")
	public String listarcontacto(ModelMap model, Locale locale) {
                model.addAttribute("idioma", locale.getDisplayName() + "-" + locale.getLanguage());
                model.addAttribute("ruta", "listarContacto?");
                int totalContactos = (int)contactsDAO.totalContactos();
                model.addAttribute("total", totalContactos); 
                List<Contacts> listaco = contactsDAO.listarContactos();
                for(int i = 0;i<listaco.size();i++){
                    int group_id = listaco.get(i).getGroupId();
                    Groups g = groupsDAO.dameGrupo(group_id);
                    listaco.get(i).setGroupName(g.getName());
                }
                
                model.addAttribute("listaco", listaco);
                model.addAttribute("general", "listar");
		return "listarcontactos";
	} 
        
        @RequestMapping(value = "/borrarContacto", method = RequestMethod.GET)
        public String borrarcontactos(ModelMap model, Locale locale, HttpServletRequest request) {
                model.addAttribute("idioma", locale.getDisplayName() + "-" + locale.getLanguage());
                model.addAttribute("ruta", "listarContacto?");
                int contactId = Integer.parseInt(request.getParameter("id"));                                   
                model.addAttribute("accion", "borrar");
                contactsDAO.borrarContacto(contactId);  
                int totalContactos = (int)contactsDAO.totalContactos();
                model.addAttribute("total", totalContactos); 
                List<Contacts> listaco = contactsDAO.listarContactos();
                for(int i = 0;i<listaco.size();i++){
                    int group_id = listaco.get(i).getGroupId();
                    Groups g = groupsDAO.dameGrupo(group_id);
                    listaco.get(i).setGroupName(g.getName());
                }
                model.addAttribute("listaco", listaco);
                
                model.addAttribute("general", "listar");
                return "listarcontactos";
	}   
        
        //@RequestMapping(value = "/autores", method = RequestMethod.GET)
        @RequestMapping(value = "/autores")
	public String listarAutores(ModelMap model, Locale locale) {
                List<Links> listaEnlaces = linksDAO.listarEnlaces();
                List<Autores> listaAutores = autoresDAO.listarAutores();
                model.addAttribute("idioma", locale.getDisplayName() + "-" + locale.getLanguage());
                model.addAttribute("ruta", "autores?");
                model.addAttribute("listaEnlaces", listaEnlaces);
                model.addAttribute("listaAutores", listaAutores);
		//return "index";
                return "autores";
	}      
}
