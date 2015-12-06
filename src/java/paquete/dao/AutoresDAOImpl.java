/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.dao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import paquete.model.Autores;

/**
 *
 * @author Daniel
 */
//@Repository("AutoresDAO")
@Transactional
public class AutoresDAOImpl implements AutoresDAO {
    
    private SessionFactory sessionFactory;
        
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    
    @SuppressWarnings("unchecked")
    public List<Autores> listarAutores() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Autores> list = session.createQuery("from Autores").list();
        return list;
    }
    
 
//    @SuppressWarnings("unchecked")
//    public List<Autores> listarAutores() {
//        return getSession().createCriteria(Autores.class).list();
//    }
    
//    private Session getSession(){
//        Session s = getSessionFactory().getCurrentSession();
//        if(s == null){
//            s = getSessionFactory().openSession();
//        }
//        return s;
//    }
//    
//    private SessionFactory getSessionFactory(){
//        return sessionFactory;
//    }
}
