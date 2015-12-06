/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import paquete.model.Contacts;
import paquete.model.Emails;

/**
 *
 * @author Daniel
 */
@Transactional
public class ContactsDAOImpl implements ContactsDAO {
    private SessionFactory sessionFactory;
        
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Contacts> listarContactos() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Contacts> list = session.createQuery("from Contacts").list();
        for(int i = 0;i<list.size();i++){
            Integer contactId = list.get(i).getId();
            List<Emails> emails = session.createQuery("from Emails where contact_id = '"+contactId+"'").list();
            Set<Emails> e = new HashSet<Emails>(emails);
            list.get(i).setEmailses(e);
        }
        return list;
    } 
    
    @Override
    public List<Contacts> listarContactosByGroup(int groupId) {
       Session session = this.sessionFactory.getCurrentSession();
       List<Contacts> list = session.createQuery("from Contacts where group_id = '"+groupId+"'").list();
       for(int i = 0;i<list.size();i++){
           Integer contactId = list.get(i).getId();
           List<Emails> emails = session.createQuery("from Emails where contact_id = '"+contactId+"'").list();
           Set<Emails> e = new HashSet<Emails>(emails);
           list.get(i).setEmailses(e);
       }
       return list;
   }
    
   @Override
   public int listarContactosByGroupCount(int groupId) {
      Session session = this.sessionFactory.getCurrentSession();
       Long contador = ((Long) session.createQuery("select count(*) from Contacts where group_id= '"+groupId+"'").uniqueResult());
       Integer totalC = contador.intValue();
       return totalC;
  }
    
    @Override
    public Integer totalContactos(){
        Session session = this.sessionFactory.getCurrentSession();
        Long contador = ((Long) session.createQuery("select count(*) from Contacts").uniqueResult());
        Integer totalC = contador.intValue();
        return totalC;
    }
    
    @Override
    public List<Contacts> busqueda(String nombreBuscar){
        Session session = this.sessionFactory.getCurrentSession();
        List<Contacts> list = session.createQuery("from Contacts where name like '%"+nombreBuscar+"%'").list(); 
        for(int i = 0;i<list.size();i++){
            Integer contactId = list.get(i).getId();
            List<Emails> emails = session.createQuery("from Emails where contact_id = '"+contactId+"'").list();
            Set<Emails> e = new HashSet<Emails>(emails);
            list.get(i).setEmailses(e);
        }
        return list;    
    }
    
    @Override
    public void borrarContacto(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete Contacts where id = '"+id+"'");
        int result = query.executeUpdate();
    } 
    
    @Override
    public void añadirContacto(Contacts contact) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(contact);
        //session.merge(group); //funcionan con save y merge igualmente
    } 
    
    @Override
    public Contacts dameContacto(Integer id){
        Session session = this.sessionFactory.getCurrentSession();
        return (Contacts)session.get(Contacts.class, id);   
    }
    
    @Override
    public void editarContacto(Contacts contact) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(contact);
    }
}
