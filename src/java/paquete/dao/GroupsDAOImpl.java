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
import paquete.model.Groups;

/**
 *
 * @author Daniel
 */
@Transactional
public class GroupsDAOImpl implements GroupsDAO {

    private SessionFactory sessionFactory;
        
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Groups> listarGrupos() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Groups> list = session.createQuery("from Groups").list();
        return list;
    } 
    
    @Override
    public void borrarGrupo(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete Groups where id = '"+id+"'");
        int result = query.executeUpdate();
    } 
    
    @Override
    public void añadirGrupo(Groups group) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(group);
        //session.merge(group); //funcionan con save y merge igualmente
    } 
    
    @Override
    public void editarGrupo(Groups group) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(group);
    } 
    
    @Override
    public Groups dameGrupo(Integer id){
        Session session = this.sessionFactory.getCurrentSession();
        return (Groups)session.get(Groups.class, id);   
    }
    
    @Override
    public Integer totalGrupos() {
        Session session = this.sessionFactory.getCurrentSession();
        Long contador = ((Long) session.createQuery("select count(*) from Groups").uniqueResult());
        Integer totalG = contador.intValue();
        return totalG;
    }
}
