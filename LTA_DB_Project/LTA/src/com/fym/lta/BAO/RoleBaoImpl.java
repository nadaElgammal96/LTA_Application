package com.fym.lta.BAO;

import com.fym.lta.DAO.DaoFactory;
import com.fym.lta.DAO.EquipmentDao;
import com.fym.lta.DAO.RoleDao;
import com.fym.lta.DAO.RoleDaoImpl;
import com.fym.lta.DAO.UserDaoImpl;
import com.fym.lta.DTO.BuildingDto;
import com.fym.lta.DTO.RoleDto;

import com.fym.lta.DTO.UserDto;

import java.util.List;

import javax.swing.JOptionPane;

public class RoleBaoImpl implements RoleBao {
    private  RoleDao dao = new DaoFactory().createRoleDao();
    
    
    public boolean delete(RoleDto r) {
        

                        boolean deleteFlage = true;
                        try{
                            if(dao.isExist(r))
                                deleteFlage = dao.delete(r);
                            else
                                deleteFlage = false;
                        }catch(Exception e){
                            e.printStackTrace();
                            return false;
                        }
                        return deleteFlage;
        }
    public List <RoleDto> searchFor(RoleDto role){
    
        List<RoleDto> roles = null;
                try{
                   roles = dao.searchFor(role);
                    return roles ;
                }catch(Exception e){
                    e.printStackTrace();
                    return roles;
                }  
            }

    public List<RoleDto> listAll() {
            List<RoleDto> role = null;
            try{
                 role=dao.viewAll();
                return role;
                }
            catch(Exception e){
            e.printStackTrace();
            return role;
            }
                }
    

    public boolean add(RoleDto r , UserDto user) {
                  boolean saveFlage = false;
                          try{
                                //data is valid
                               if(dao.isExist(r)){
                                 return saveFlage;
                               }        
                               else{
                                       saveFlage = dao.createNew(r , user);
                                       return saveFlage;
                                   }
                          }
                              catch(Exception e){
                                     e.printStackTrace();
                                     return false;
                                 }
                                
                          
    }
public boolean update(RoleDto role , UserDto user){
    
        boolean updateFlag = true;
        try{ 
        
                if(dao.isExist(role))
                {
                     updateFlag = dao.update(role , user);
                 }
                else{
                    JOptionPane.showInternalMessageDialog(null,"No Role Found To Update");
                    updateFlag = false;
                    }
            }       
           
        catch(Exception e){
               e.printStackTrace();
               return false;
           }
           return updateFlag;
}
    
}