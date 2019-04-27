package com.fym.lta.BAO;

import com.fym.lta.DAO.DaoFactory;
import com.fym.lta.DAO.EquipmentDao;
import com.fym.lta.DAO.RoleDao;
import com.fym.lta.DAO.RoleDaoImpl;
import com.fym.lta.DAO.UserDaoImpl;
import com.fym.lta.DTO.BuildingDto;
import com.fym.lta.DTO.RoleDto;

import java.util.List;

import javax.swing.JOptionPane;

public class RoleBaoImpl implements RoleBao {
    private  RoleDao dao = new DaoFactory().createRoleDao();
    //RoleDaoImpl dao =new RoleDaoImpl();
    
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
    

    public boolean add(RoleDto r) {
                  boolean saveFlage = true;
                          try{
                                //data is valid
                               if(dao.isExist(r)){
                                   JOptionPane.showMessageDialog(null, "Record already EXISTS");
                               }        
                               else{
                                       saveFlage = dao.createNew(r);
                                       return saveFlage;
                                   }
                          }
                              catch(Exception e){
                                     e.printStackTrace();
                                     return false;
                                 }
                                 return saveFlage;
                          
    }
public boolean update(RoleDto role){
    
        boolean updateFlag = true;
        try{ 
        
                if(dao.isExist(role))
                {
                     updateFlag = dao.update(role);
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