/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.dao;

import java.util.List;
import paquete.model.Groups;

/**
 *
 * @author Daniel
 */
public interface GroupsDAO {
    public void añadirGrupo(Groups group);
    public void editarGrupo(Groups group);
    public void borrarGrupo(Integer id);
    public Groups dameGrupo(Integer id);
    public List<Groups> listarGrupos();
    public Integer totalGrupos();
    
}
