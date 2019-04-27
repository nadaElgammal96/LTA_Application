package com.fym.lta.BAO;
/**
 *
 * @author Islam
 */
import com.fym.lta.DAO.BuildingDao;
import com.fym.lta.DAO.BuildingDaoImpl;
import com.fym.lta.DAO.DaoFactory;
import com.fym.lta.DAO.DepartmnetDaoImpl;
import com.fym.lta.DTO.BuildingDto;

import java.util.List;


public class BuildingBaoImpl implements BuildinBao {
    
    private  BuildingDao dao = new DaoFactory().createBuildingDao();

    public void ListEmptyLocations(BuildingDto build) 
    {
    }

    public void ListAll() 
    {
        try{
            dao.viewAll();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void ListAllLocations(BuildingDto build) 
    {
    }

    public Boolean insert(BuildingDto build) 
    {
        boolean saveFlage = true;
        try{
              //data is valid
             if(dao.isExist(build)){
                        saveFlage = false;
             }         else{
                       saveFlage = dao.createNew(build);
                            }
            
        }
            catch(Exception e){
                   e.printStackTrace();
                   return false;
               }
               return saveFlage;
    }

    public Boolean delete(BuildingDto build) 
    {
                boolean deleteFlage = true;
                try{
                    if(dao.isExist(build))
                        deleteFlage = dao.delete(build);
                    else
                        deleteFlage = false;
                }catch(Exception e){
                    e.printStackTrace();
                    return false;
                }
                return deleteFlage;
    }

    public List<BuildingDto> searchFor(BuildingDto build) {
        List<BuildingDto> buildss = null;
        try{
            buildss = dao.SearchFor(build);
            return buildss ;
        }catch(Exception e){
            e.printStackTrace();
            return buildss;
        }  
    }

    @Override
    public Boolean update(BuildingDto build) {
        // TODO Implement this method
        boolean saveFlage = true;
        try{
              //data is valid
             if(dao.isExist(build)){
                 saveFlage = dao.update(build);
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
}
