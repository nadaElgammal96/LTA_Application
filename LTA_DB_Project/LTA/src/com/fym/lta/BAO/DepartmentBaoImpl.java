package com.fym.lta.BAO;

import com.fym.lta.DAO.DaoFactory;
import com.fym.lta.DAO.DepartmentDao;
import com.fym.lta.DTO.DepartmentDto;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class DepartmentBaoImpl implements DepartmentBao {
    
    /* Delete a row selected by user in GUI.
     * Takes the object and return true if it has deleted and false if any exception occur*/
    
    public boolean delete(DepartmentDto d) {
        
        DepartmentDao dao= new DaoFactory().createDepartmentDao();
                boolean deleteFlage = true;
                try{
                    if(dao.isExist(d))
                        deleteFlage = dao.delete(d);
                    else
                    {
                        deleteFlage = false;
                    }
                }catch(Exception e){
                    e.printStackTrace();
                    return false;
                }
                return deleteFlage;
    }

    /* Method to view all exist department
     * no parameters
     * return list of departmentdto objects */
    public List<DepartmentDto> viewAll() {

        DepartmentDao dao = new DaoFactory().createDepartmentDao();

        List<DepartmentDto> departs = new ArrayList<DepartmentDto>();
        
        try{
             departs = dao.viewAll();
              
           }
         
        catch(Exception e){
            e.printStackTrace();
            
        }
        return departs;
    }

    /* Create a new department  
     * takes department object inserted by user 
     * Returm true for if it success, False if not */
    
    public boolean create(DepartmentDto d) {

        DepartmentDao dao = new DaoFactory().createDepartmentDao();
        boolean saveFlage = true;
        try{
            
            if(dao.isExist(d))
               {saveFlage = false;
               }
            else
                saveFlage = dao.createNew(d);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return saveFlage;
    }
    
    
    /* update an existed one 
     * takes department object inserted by user 
     * Returm true for if it success, False if not */
    
    public boolean update(DepartmentDto d) {

        DepartmentDao dao = new DaoFactory().createDepartmentDao();
        boolean saveFlage = false;
        try{
            
            if(dao.isExist(d))
                saveFlage = dao.update(d);
           
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return saveFlage;
    }
    
    /* Search For Drparmtment with any attributes of it(id,name,code,...)
     * This method takes department object and return list of department if exist.
    */
    public List<DepartmentDto> searchFor(DepartmentDto d) {

        DepartmentDao dao = new DaoFactory().createDepartmentDao();
        List<DepartmentDto> departs = null;
        
        try{
            departs=dao.searchFor(d);
        }catch(Exception e){
            e.printStackTrace();
        }  
      return departs;
    }

    //???????????????????????
    public void viewAllCourses() {
    }
}
