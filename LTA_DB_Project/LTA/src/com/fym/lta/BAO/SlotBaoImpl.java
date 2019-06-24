package com.fym.lta.BAO;

import com.fym.lta.DAO.DaoFactory;
import com.fym.lta.DAO.SlotDao;
import com.fym.lta.DTO.DepartmentDto;
import com.fym.lta.DTO.LocationDto;
import com.fym.lta.DTO.ScheduleDto;
import com.fym.lta.DTO.SlotDto;

import com.fym.lta.DTO.StaffSlotDto;
import com.fym.lta.DTO.StageDto;
import com.fym.lta.DTO.UserDto;

import java.util.List;

import javax.swing.JOptionPane;

public class SlotBaoImpl implements SlotBao {
    
    private SlotDao dao = new DaoFactory().createSlotDao();

  /**Delete a slot from DB
   * @param this slot
   * @return ture if success or false if not */
    public boolean delete(SlotDto s) {
        boolean deleteFlage = true;
                      try{
                          if(dao.isExist(s))
                              deleteFlage = dao.delete(s);
                          else
                              deleteFlage = false;
                      }catch(Exception e){
                          e.printStackTrace();
                          return false;
                      }
                      return deleteFlage;    }

  /**insert new slot in DB
   * @param slot,user
   * @return boolean value for success or not
   * */
    public boolean add(SlotDto s,UserDto user) {
        boolean saveFlage = true;
               try{
                     //data is valid
                    if(dao.isExist(s)){
                               saveFlage = false;
                    }         else{
                              saveFlage = dao.createNew(s,user);
                                   }
                   
               }
                   catch(Exception e){
                          e.printStackTrace();
                          return false;
                      }
                      return saveFlage;
                      }

  /**Search for existing slot/s in database
   * @param slot
   * @return found slots  */
    public List<SlotDto> searchFor(SlotDto s) {
        List<SlotDto> slots = null;
                try{
                   slots  = dao.searchFor(s);
                    return slots  ;
                }catch(Exception e){
                    e.printStackTrace();
                    return slots ;
                }      }

  /**Update a slot
   * @param this slot, user
   * @return ture or false */
    public boolean update(SlotDto s , UserDto user) {
        boolean saveFlage = true;
               try{
                     //data is valid
                    if(dao.isExist(s)){
                        saveFlage = dao.update(s,user);
                    }         else{
                              saveFlage = false;
                                   }
               }
                   catch(Exception e){
                          e.printStackTrace();
                          return false;
                      }
                      return saveFlage;    }

    public List<LocationDto> viewAvailableLocations(DepartmentDto d) {
        List<LocationDto> free_locs=null;
        return free_locs;
    }

    public List<LocationDto> viewAllAvailableLocations() {
        List<LocationDto> locs = null;
        return locs ;
    }

  /**method to get location assigned to slot
   * @param slot
   * @return slot after assign location to it **/
    public SlotDto getSlot(SlotDto s){
        SlotDto slot = null;
        try{
            slot=dao.getSlot(s);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return slot;
    }

  /** assign staff to a specific slot
   * @param staff slot dto object
   * @return true or false
   * */
    public boolean assignStaff(StaffSlotDto ss){
        boolean flag = false;
        try{
            flag = dao.assignStaff(ss);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

  /**This method for getting all slot for a schedule
   * @param shcedule
   * @return slots
   * */
  public List<SlotDto> ScheduleSlot(ScheduleDto schedule){

    List<SlotDto> slots = null;
    try
      {
        slots = dao.ScheduleSlot(schedule);
      }
    catch(Exception e)
      {
        e.printStackTrace();
      }
    return slots;
    
    }


  /**check if a specific slot is exist in database or not
   *@param slot object
   *@return ture if it exist, false if not */
  public boolean isExist(SlotDto slot)
  {
    boolean existFlag = false;
    try
      {
        existFlag = dao.isExist(slot);
      }
    catch(Exception e)
      {
        e.printStackTrace();
      }
    return existFlag;
  }

  /**get slots assigned to location
   * used in location accupancy
   * @param take location
   * @return its slot list
   * */
  public List<SlotDto> location_accupancy(LocationDto location){
    List<SlotDto> slots = null;
    try
      {
        slots = dao.location_accupancy(location);
      }
    catch(Exception e)
      {
        e.printStackTrace();
      }
    return slots;
    
    }


  /**Check if this staff assigned to this slot
   * @param staff slot dto object
   * @return true, or false */
  public boolean isAssigned(StaffSlotDto ss)
  {
    boolean assignedFlag = false;
    try
      {
        assignedFlag = dao.isAssigned(ss);
      }
    catch(Exception e)
      {
        e.printStackTrace();
      }
    return assignedFlag;
  }


  /** get all slots and its info. for a specific schedule
   * to view it in UI
   * @param take selected stage, department
   * @return slot list
   * */
  public List<SlotDto> viewSlotsOfSchedule(StageDto stage,
    DepartmentDto department)
  {
    List<SlotDto> slots = null;
    try
      {
        slots = dao.viewSlotsOfSchedule(stage, department);
      }
    catch(Exception e)
      {
        e.printStackTrace();
      }
    return slots;
  }


}
