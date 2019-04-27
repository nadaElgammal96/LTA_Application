package com.fym.lta.BAO;



import com.fym.lta.DAO.LocationTypeDaoImpl;
import com.fym.lta.DTO.LocationTypeDto;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class LocationTypeBaoImpl implements LocationTypeBao {
    
    
    public boolean update(LocationTypeDto lt) {
        
        LocationTypeDaoImpl dao= new  LocationTypeDaoImpl();
        boolean saveFlage = false;
        try{
            if(dao.isExist(lt))
                saveFlage = dao.update(lt);
            else
            {  
                saveFlage = false;
                JOptionPane.showMessageDialog(null, "This Location Type doesn't exist.","Not Found!",1);

            }
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                                          "Some thing went wrong.",
                                          "Exception occured!", 1);
            return false;
        }
        return saveFlage;
    }

    public boolean add(LocationTypeDto lt) {
        
        LocationTypeDaoImpl dao=null;
        dao=new LocationTypeDaoImpl();
        
        boolean saveFlage = false;
        try{
            
            if(!dao.isExist(lt))
                saveFlage = dao.createNew(lt);
            return saveFlage;

        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public void viewLocationsOfType(String type_code) {
    }

    public  List<LocationTypeDto> viewAll() {
        
        LocationTypeDaoImpl dao= new LocationTypeDaoImpl();
        
        List<LocationTypeDto> types = new ArrayList<LocationTypeDto>();
        
        try{
             types = dao.viewAll();
           }
         
        catch(Exception e){
            e.printStackTrace();
            
        }
        return types;
    }
    
    public List<LocationTypeDto> searchFor(LocationTypeDto lt) {
        
        LocationTypeDaoImpl dao=new LocationTypeDaoImpl();
        List<LocationTypeDto> types = new ArrayList<LocationTypeDto>();
        
        try{
            types=dao.searchFor(lt);
        }catch(Exception e){
            e.printStackTrace();
        }  
        return types;
    }

    public boolean delete(LocationTypeDto lt) {
        
        LocationTypeDaoImpl dao=new LocationTypeDaoImpl();
                boolean deleteFlage = false;
                try{
                    if(dao.isExist(lt))
                        deleteFlage = dao.delete(lt);
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
}
