package com.fym.lta.BAO;

import com.fym.lta.DAO.DaoFactory;
import com.fym.lta.DAO.EmployeeDao;
import com.fym.lta.DAO.EquipmentDao;
import com.fym.lta.DTO.EmployeeDto;

import com.fym.lta.DTO.UserDto;

import java.util.List;

import javax.swing.JOptionPane;

public class EmployeeBaoImpl implements EmployeeBao {
    private  EmployeeDao db = new DaoFactory().createEmployeeDao();
    UserBaoImpl endUserBaoImpl;

    public List<EmployeeDto> listAll() {
       
        return db.viewAll();
        
    }

    public boolean update(EmployeeDto emp,UserDto user) {
        boolean saveFlage = true;
               try{
                     //data is valid
                    if(db.isExist(emp)){
                        saveFlage = db.update(emp , user);
                    }         else{
                              saveFlage = false;
                                   }
               }
                   catch(Exception e){
                          e.printStackTrace();
                          return false;
                      }
                      return saveFlage;
               
               
    }

    public boolean delete(EmployeeDto emp) {
        
        boolean deleteFlage = true;
                      try{
                          if(db.isExist(emp))
                              deleteFlage = db.delete(emp);
                          else
                              deleteFlage = false;
                      }catch(Exception e){
                          e.printStackTrace();
                          return false;
                      }
                      return deleteFlage;
    }
    
    public List<EmployeeDto> searchFor(EmployeeDto emp) {
        List<EmployeeDto> emps = null;
                try{
                    emps = db.searchFor(emp);
                    return emps ;
                }catch(Exception e){
                    e.printStackTrace();
                    return emps;
                }  
      
    }

    public boolean add(EmployeeDto emp ,UserDto user) {
        
        boolean saveFlage = true;
               try{
                     //data is valid
                    if(db.isExist(emp)){
                               saveFlage = false;
                    }         else{
                              saveFlage = db.createNew(emp ,user);
                                   }
                   
               }
                   catch(Exception e){
                          e.printStackTrace();
                          return false;
                      }
                      return saveFlage;
    }
    
    public UserDto viewUser(EmployeeDto emp){
        UserDto user = null;
        try {
            if (db.isExist(emp)){
                user=db.viewUserOfStaff(emp);
            }
            else{
                JOptionPane.showMessageDialog(null,"Employee Does Not Exist");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }
    
}
