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
import paquete.model.Links;

/**
 *
 * @author Daniel
 */
@Transactional
public class LinksDAOImpl implements LinksDAO {
    private SessionFactory sessionFactory;
        
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Links> listarEnlaces() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Links> list = session.createQuery("from Links").list();
        return list;
    }    
}
