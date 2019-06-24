package com.fym.lta.DAO;

import com.fym.lta.DTO.ScheduleDto;
import com.fym.lta.DTO.SlotDto;
import com.fym.lta.DTO.UserDto;

import java.util.ArrayList;

import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class ScheduleDaoImpl implements ScheduleDao {

  /**add new schedule
   * @param schedule,user
   * @return true if it inserted successfuly, false if not
   */
    public Boolean createNew(ScheduleDto sch, UserDto user) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();)
        {
          
           //start new database connection
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            
            //insert schedule information into database
            jdbc.setCommand("insert into SCHEDULE (ID_SCHEDULE , NO_OF_SLOTS , TERM , INSERTED_BY , INSERTED_AT  , PATH_SCH  ) values(?,?,?,?, SYSDATE ,?)");
            jdbc.setInt(1,sch.getId());
            jdbc.setInt(2,sch.getSlot_num());
            jdbc.setInt(3,sch.getTerm());
            jdbc.setInt(4,user.getId());
            jdbc.setString(5, sch.getFile_path());
            jdbc.execute();
          
            return true;
        }
        catch(java.sql.SQLException e){
            return false;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

  /**search for is schedule exist or not
   * @param location
   * @return boolean value
   */
    public Boolean isExist(ScheduleDto sch) {
        boolean flag = false;
                       try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) 
                       {
                         
                           //start database connection
                           jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
                           jdbc.setUsername("lta");
                           jdbc.setPassword("lta"); 
                         
                           //search for this schedule in database
                           jdbc.setCommand("SELECT ID_SCHEDULE FROM SCHEDULE WHERE ID_SCHEDULE = ?");
                           jdbc.setInt(1, sch.getId());
                           jdbc.execute();
                          
                         while(jdbc.next()){
                                flag = true;
                                break;
                                }
                            return flag;
                        } 
                           catch(java.sql.SQLException e){
                               return false;
                               }
                       
        catch(Exception e){
                       e.printStackTrace();
                       return false;}
    }

  /**delete schedule from database
   * @param schedule
   * @return true if it deleted successfuly, false if no
   */
    public Boolean delete(ScheduleDto sch) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();)
                {
          
        //start database connection
       jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
       jdbc.setUsername("lta");
       jdbc.setPassword("lta");

        /* delete schedule from schedule stage table */
        jdbc.setCommand("delete from SCHEDULE_STAGE WHERE ID_SCHEDULE=? ");
        jdbc.setInt(1, sch.getId());
        jdbc.execute();

        /* get slots of the schedule to be deleted */
        List<SlotDto> slots = null;
        SlotDto slot = null;
        jdbc.setCommand("select code_schedule_slot from schedule_slots where ID_SCHEDULE=? ");
        jdbc.execute();

        /* store slots in list */
        while(jdbc.next())
          {
            if(slots==null)
              slots = new ArrayList<>();
            slot = new SlotDto();
            slot.setCode("CODE_SCHEDULE_SLOT");
            slots.add(slot);
            slot = null;
          }

        /*delete schedule from schedule slot table in database */
        jdbc.setCommand("delete from schedule_slots where ID_SCHEDULE=? ");
        jdbc.execute();

        /* delete slots of list from Slot table in database */
        for(int i = 0; i<slots.size(); i++)
          {
            jdbc.setCommand("delete from SLOT where CODE_SCHEDULE_SLOT=? ");
            jdbc.setString(1, slots.get(i).getCode());
            jdbc.execute();
          }

        /* delete schedule from schedule table in database */
        jdbc.setCommand("delete from SCHEDULE where ID_SCHEDULE=? ");
        jdbc.setInt(1, sch.getId());
        jdbc.execute();
          
        return true;
                }catch(java.sql.SQLException e){
                    return false;
                }
                catch(Exception e){
                    e.printStackTrace();
                    return false;
            }
    }

  /**Update information for an existing schedule
   * @param schedule object, user object
   * @return true if it success false if not */
    public Boolean update(ScheduleDto sch , UserDto user) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();)
         {
             jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
             jdbc.setUsername("lta");
             jdbc.setPassword("lta");
            
             jdbc.setCommand("UPDATE SCHEDULE " + 
             "SET NO_OF_SLOTS=? , TERM=? , UPDATED_BY=?, UPDATED_AT=SYSDATE " + 
              "WHERE ID_SCHEDULE =? " );
             
            try{jdbc.setInt(1,sch.getSlot_num());
            }catch(NumberFormatException e){
                jdbc.setInt(1,-1);  
            }
            
            try{jdbc.setInt(2,sch.getTerm());
            }catch(NumberFormatException e){
                jdbc.setInt(2,-1);
            }
            jdbc.setInt(3,user.getId());
            
            try{ jdbc.setInt(4,sch.getId());
            }catch(NumberFormatException e){
                jdbc.setInt(4,-1);
            }
             jdbc.execute();
             return true;
         //}catch(java.sql.SQLException e){
           //  return false;
         }
         catch(Exception e){
             e.printStackTrace();
             return false;
        }
    }

  /** get the max schedule id to generate a new schedule
   * @return the max id
   * */
  public int getMaxId(){
    int max_id = 0;
    try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet())
      {

        // start connection

        jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
        jdbc.setUsername("lta");
        jdbc.setPassword("lta");
        jdbc.setCommand("select ID_SCHEDULE FROM SCHEDULE ");
        jdbc.execute();
        while(jdbc.next())
          {
            if(jdbc.getInt("ID_SCHEDULE")>max_id)
              max_id = jdbc.getInt("ID_SCHEDULE");
          }
      }
    catch(Exception e)
      {
        e.printStackTrace();
      }
    return max_id;
        }

 /** Find number of slots for a specific schedule
   * @param take schedule object
   * @return return int value of number of slots */
  public boolean numOfSlots(ScheduleDto sch){
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();)
         {
            
            // start connection 

             jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
             jdbc.setUsername("lta");
             jdbc.setPassword("lta");
             jdbc.setCommand("select SCHEDULE_SLOTS.CODE_SCHEDULE_SLOT FROM SCHEDULE_SLOTS , SCHEDULE " +
                 "WHERE SCHEDULE.ID_SCHEDULE = SCHEDULE_SLOTS.ID_SCHEDULE ");
            jdbc.setInt(1,sch.getId());
            jdbc.execute();
            
             int num = 0;
            while(jdbc.next()){
                num ++ ;
            }
            
            jdbc.setCommand("update SCHEDULE set NO_OF_SLOTS =? WHERE ID_SCHEDULE=? ");
             jdbc.setInt(1,num);
             jdbc.setInt(2,sch.getId());
            
             jdbc.execute();
                 return true;

         }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

  /** get the schedule id
   * @param schedule
   * @return the same schedule after assign its id */
  public ScheduleDto getID(ScheduleDto schedule){


    try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet())
      {

        // start connection
        jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
        jdbc.setUsername("lta");
        jdbc.setPassword("lta");

        //get the id from schedule table
        jdbc.setCommand("SELECT S.ID_SCHEDULE FROM SCHEDULE S JOIN SCHEDULE_STAGE SS ON (S.ID_SCHEDULE = SS.ID_SCHEDULE) "+
          "JOIN STAGE ON (STAGE.CODE_STAGE = SS.CODE_STAGE) JOIN DEPARTMENT D ON (D.ID_DEPARTMENT = STAGE.ID_DEPARTMENT) "+
          "WHERE STAGE.NO_STAGE=? AND D.NAME_DEPARTMENT=? ");
        jdbc.setString(2, schedule.getDepartment().getName());
        jdbc.setString(1, schedule.getStage().getNumber());
        jdbc.execute();

        while(jdbc.next())
          {
            schedule.setId(jdbc.getInt("ID_SCHEDULE"));
            System.out.println(schedule.getId());
          }
      
      }

    catch(Exception e)
      {
        e.printStackTrace();
      }
    
    return schedule;
    
  }

  /** get the schedule id
   * @param schedule path
   * @return  id */
  public int getScheduleID(String path)
  {
    int id = 0;
    try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet())
      {

        jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
        jdbc.setUsername("lta");
        jdbc.setPassword("lta");
        jdbc.setCommand("select ID_SCHEDULE from SCHEDULE where PATH_SCH = ? ");
        jdbc.setString(1, path);
        jdbc.execute();
        while(jdbc.next())
          {
            id = jdbc.getInt("ID_SCHEDULE");
          }
      }

    catch(Exception e)
      {
        e.printStackTrace();
      }
    return id;
  }

}
