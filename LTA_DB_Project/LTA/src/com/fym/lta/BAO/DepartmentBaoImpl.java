package com.fym.lta.BAO;

import com.fym.lta.DAO.DepartmnetDaoImpl;
import com.fym.lta.DTO.DepartmentDto;

public class DepartmentBaoImpl implements DepartmentBao {
    
    
    public boolean delete(DepartmentDto d) {
        
        DepartmnetDaoImpl dao=null;
                boolean deleteFlage = true;
                try{
                    if(dao.isExist(d))
                        deleteFlage = dao.delete(d);
                    else
                        deleteFlage = false;
                }catch(Exception e){
                    e.printStackTrace();
                    return false;
                }
                return deleteFlage;
    }

    public void viewAll() {
        
        DepartmnetDaoImpl dao=null;
        try{
            dao.viewAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    public boolean update(DepartmentDto d) {
        
        DepartmnetDaoImpl dao=null;
                boolean updateFlage = true;
                try{

                    if(dao.isExist(d))
                        updateFlage = dao.update(d);
                    else
                        updateFlage = false;
                }catch(Exception e){
                    e.printStackTrace();
                    return false;
                }
                return updateFlage;
    }

    public boolean save(DepartmentDto d) {
                
        DepartmnetDaoImpl dao=null;
        boolean saveFlage = true;
        try{
            
            //Check the data validity
            //data is valid
            if(dao.isExist(d))
                saveFlage = dao.update(d);
            else
                saveFlage = dao.createNew(d);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return saveFlage;
    }

    public void searchFor(String code) {
        
        DepartmnetDaoImpl dao=null;
        try{
            dao.searchFor(code);
        }catch(Exception e){
            e.printStackTrace();
        }  

    }

    public void viewAllCourses() {
    }
}
