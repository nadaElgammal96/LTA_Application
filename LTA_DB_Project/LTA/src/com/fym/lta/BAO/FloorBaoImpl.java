package com.fym.lta.BAO;

import com.fym.lta.DAO.BuildingDao;
import com.fym.lta.DAO.DaoFactory;
import com.fym.lta.DAO.FloorDao;
import com.fym.lta.DTO.BuildingDto;
import com.fym.lta.DTO.FloorDto;

import com.fym.lta.DTO.UserDto;

import java.util.Collections;
import java.util.List;

public class FloorBaoImpl implements FloorBao {
    
    private  FloorDao dao = new DaoFactory().createFloorDao();


  /**
   * @return all floors in data base
   */
    @Override
    public List<FloorDto> ListAll() {
        // TODO Implement this method
        List<FloorDto> floors = null;
        try{
            
            floors = dao.viewAll();
            return floors;
        }catch(Exception e){
            e.printStackTrace();
            return floors;
        }
    }


  /**
   * @param dto object for selected floor which would be updated
   * @return true if success - false if not
   */
    @Override
    public boolean update(FloorDto f,UserDto user) {
        // TODO Implement this method
        boolean saveFlage = true;
        try{
              //data is valid
             if(dao.isExist(f)){
                 saveFlage = dao.update(f,user);
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

  /**
   * @param dto floor object which would be deleted
   * @return true if success - false if not
   */
    @Override
    public Boolean delete(FloorDto f) {
        // TODO Implement this method
        boolean deleteFlage = true;
        try{
            if(dao.isExist(f))
                deleteFlage = dao.delete(f);
            else
                deleteFlage = false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return deleteFlage;
    }


  /**
   * @return floor have attribute value inserted in search
   */
    @Override
    public List<FloorDto> searchFor(FloorDto f) {
        // TODO Implement this method
        List<FloorDto> floors = null;
        try{
            floors = dao.searchFor(f);
            return floors ;
        }catch(Exception e){
            e.printStackTrace();
            return floors;
        }  
    }


  /**
   * @param - dto floor object which would be inserted
   * @return true if success - false if not
   */
    @Override
    public Boolean insert(FloorDto floor,UserDto user) {
        // TODO Implement this method
        boolean saveFlage = true;
        try{
              //data is valid
             if(dao.isExist(floor)){
                        saveFlage = false;
             }     
             else{
               saveFlage = dao.createNew(floor,user);
                 }
            
        }
            catch(Exception e){
                   e.printStackTrace();
                   return false;
               }
               return saveFlage;
    }

  /**Search for floors for a building
   * @param floor that has building id
   * @return floors in this building
   * */
    @Override
    public  List<FloorDto> viewBuildingFloors(FloorDto f) {
        List<FloorDto> floors = null;
        try {
            floors = dao.viewBuildingFloors(f);
            return floors;
        } catch (Exception e) {
            e.printStackTrace();
            return floors;
        }
    }
}
