package com.fym.lta.BAO;



import com.fym.lta.DAO.LocationTypeDaoImpl;
import com.fym.lta.DTO.LocationTypeDto;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 *
 * @author Mai-AbdEltwab
 */


public class LocationTypeBaoImpl implements LocationTypeBao {


    /**
     * @param dto object for selected location type which would be updated
     * @return ture if success - false if not
     */
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

    /**
     * @param - dto location type object which would be inserted 
     * @return ture if success - false if not
     */
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

    /**
     * @return all location types in data base
     */
    public List<LocationTypeDto> viewAll() {
        
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

    /**
     * @return location types have id/code/des/color inserted in search
     */
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

    /**
     * @param dto location type object which would be deleted
     * @return ture if success - false if not
     */
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
