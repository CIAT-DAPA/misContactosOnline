/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.dao;

import java.util.List;
import paquete.model.Contacts;

/**
 *
 * @author Daniel
 */
public interface ContactsDAO {
    public List<Contacts> listarContactos();
    public Integer totalContactos();
    public List<Contacts> busqueda(String nombreBuscar);
    public void borrarContacto(Integer id);
    public void añadirContacto(Contacts contact);
    public List<Contacts> listarContactosByGroup(int groupId);
    public int listarContactosByGroupCount(int groupId);
    public Contacts dameContacto(Integer id);
    public void editarContacto(Contacts contact);
}
