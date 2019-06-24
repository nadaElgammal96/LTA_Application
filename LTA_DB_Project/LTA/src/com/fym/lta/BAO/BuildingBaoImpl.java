package com.fym.lta.BAO;
/**
 *
 * @author Islam
 */
import com.fym.lta.DAO.BuildingDao;
import com.fym.lta.DAO.DaoFactory;
import com.fym.lta.DTO.BuildingDto;
import com.fym.lta.DTO.UserDto;

import java.util.List;


public class BuildingBaoImpl implements BuildingBao {
    
    private  BuildingDao dao = new DaoFactory().createBuildingDao();

  /**
   * @return all buildings in data base
   */
    public List<BuildingDto>  ListAll() 
    {
        List<BuildingDto> building = null;
        try{
            building = dao.viewAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return building;
    }


  /**
   * @param - dto building object which would be inserted
   * @return true if success - false if not
   */
    public Boolean insert(BuildingDto build,UserDto user) 
    {
        boolean saveFlage = true;
        try{
              //data is valid
             if(dao.isExist(build)){
                        saveFlage = false;
             }         else{
                       saveFlage = dao.createNew(build,user);
                            }
            
        }
            catch(Exception e){
                   e.printStackTrace();
                   return false;
               }
               return saveFlage;
    }


  /**
   * @param dto object for selected building which would be updated
   * @return true if success - false if not
   */
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


  /**
   * @param dto building object which would be deleted
   * @return true if success - false if not
   */
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


  /**
   * @return building have attribute value inserted in search
   */
    @Override
    public Boolean update(BuildingDto build,UserDto user) {
        // TODO Implement this method
        boolean saveFlage = true;
        try{
              //data is valid
             if(dao.isExist(build)){
                 saveFlage = dao.update(build,user);
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
