/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.dao;

import java.util.List;
import paquete.model.Emails;

/**
 *
 * @author Daniel
 */
public interface EmailsDAO {
    public List<Emails> listarEmails(Integer contactsID);
    public void añadirCorreo(Emails email);
    public void borrarEmail(Integer id);
}
