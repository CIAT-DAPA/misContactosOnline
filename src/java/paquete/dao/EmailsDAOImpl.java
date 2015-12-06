/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import paquete.model.Emails;

/**
 *
 * @author Daniel
 */
@Transactional
public class EmailsDAOImpl implements EmailsDAO {
    private SessionFactory sessionFactory;
        
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Emails> listarEmails(Integer contactsID) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Emails> list = session.createQuery("from Emails where contact_id = '"+contactsID+"'").list();
        return list;
    }  
    
    @Override
    public void añadirCorreo(Emails email) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(email);
        //session.merge(group); //funcionan con save y merge igualmente
    } 
    
    @Override
    public void borrarEmail(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete Emails where id = '"+id+"'");
        int result = query.executeUpdate();
    } 
}
