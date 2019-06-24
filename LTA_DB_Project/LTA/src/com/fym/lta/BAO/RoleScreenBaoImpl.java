package com.fym.lta.BAO;

import com.fym.lta.DAO.DaoFactory;
import com.fym.lta.DAO.RoleScreenDao;
import com.fym.lta.DTO.RoleScreenDto;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class RoleScreenBaoImpl implements RoleScreenBao {
    public RoleScreenBaoImpl() {
        super();
    }

    RoleScreenDao dao= new  DaoFactory().createRoleScreenDao();

    @Override
    public boolean update(RoleScreenDto rs) {
        // TODO Implement this method
        boolean saveFlage = false;
        try{
            if(dao.isExist(rs))
                saveFlage = dao.update(rs);
        
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                                          "Some thing went wrong.",
                                          "Exception occured!", 1);
            return false;
        }
        return saveFlage;
    }

    @Override
    public boolean add(RoleScreenDto rs) {
        // TODO Implement this method
        boolean saveFlage = false;
        try{
            
            if(!dao.isExist(rs))
                saveFlage = dao.createNew(rs);
            return saveFlage;

        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<RoleScreenDto> viewAll() {
        // TODO Implement this method
        List<RoleScreenDto> types = new ArrayList<RoleScreenDto>();
        
        try{
             types = dao.viewAll();
           }
         
        catch(Exception e){
            e.printStackTrace();
            
        }
        return types;
    }
    
    @Override
    public List<RoleScreenDto> searchFor(RoleScreenDto rs) {
        // TODO Implement this method
        List<RoleScreenDto> types = new ArrayList<RoleScreenDto>();
        try{
          
            
                 types=dao.searchFor(rs);
          
        }catch(Exception e){
            e.printStackTrace();
        }  
        return types;
    }

    @Override
    public boolean delete(RoleScreenDto rs) {
        // TODO Implement this method
        boolean deleteFlage = false;
        try{
                 if(dao.isExist(rs))
                 deleteFlage = dao.delete(rs);
          
          else
              deleteFlage = false;
          
          
          
                 return deleteFlage;
        }catch(Exception e){
            e.printStackTrace();
                 return false;
        }
        
        }
}
