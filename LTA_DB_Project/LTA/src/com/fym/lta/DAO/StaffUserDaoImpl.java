package com.fym.lta.DAO;

import com.fym.lta.DTO.StaffDto;
import com.fym.lta.DTO.StaffUserDto;

import com.fym.lta.DTO.UserDto;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import javax.swing.JOptionPane;

public class StaffUserDaoImpl implements StaffUSerDao {
    public StaffUserDaoImpl() {
        super();
    }
    
    //method to insert new record relating a user with existing staff
    public boolean insert(StaffUserDto staff_acc) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
            
            //open connection with dataase using resources
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");

        //get staff id
        jdbc.setCommand("SELECT ID_STAFF FROM STAFF WHERE NAME_STAFF=? ");
        jdbc.setString(1, staff_acc.getStaff().getName());
        jdbc.execute();

        while(jdbc.next())
          staff_acc.getStaff().setId(jdbc.getInt("ID_STAFF"));
          
 
            
            //query to insert staff id and its user id in database 
            jdbc.setCommand("insert into STAFF_ACC ( ID_USER , ID_STAFF  ) VALUES ( ? , ? ) ");
            
        //pass objects from dto object to query as input to be inserted
            try{
                jdbc.setInt(1,staff_acc.getUser_id());
            }catch(NumberFormatException e){
                jdbc.setInt(1,-1);
            }
            try{
                jdbc.setInt(2,staff_acc.getStaff().getId());
            }catch(NumberFormatException e){
                jdbc.setInt(2,-1);
            }
            
        //query execution
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
    
    // mehod to delete relation between staff and user
    public boolean delete(StaffUserDto staff_acc) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
            
        // open connection with database using resources
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            
        // query to delete record using its id (staff)
            jdbc.setCommand("delete from STAFF_ACC where ID_USER = ? ");
          
          //pass id from dto object parameter to the query
            try{jdbc.setInt(1,staff_acc.getUser_id());
            }catch(NumberFormatException e){
                jdbc.setInt(1,-1);
            }
        // query execution
            jdbc.execute();
            return true;
            }
        
        
        catch(java.sql.SQLException e){
            
        //show message when any sql error occurs
            JOptionPane.showMessageDialog(null,"Error Deleting Data");
            return false;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;}
    }
    
    //method to ched if record exists in database or not
    public boolean isExist(StaffUserDto staff_acc) {
    boolean existFlag = false;
    try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet())
      {

        //open connection with database using resources
        jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
        jdbc.setUsername("lta");
        jdbc.setPassword("lta");

        //query to select the record using its id
        jdbc.setCommand("select ID_USER from STAFF_ACC where ID_USER = ? ");

        //pass id to query
        try
          {
            jdbc.setInt(1, staff_acc.getUser_id());
          }
        catch(NumberFormatException e)
          {
            jdbc.setInt(1, -1);
          }

        jdbc.execute();
        while(jdbc.next())
          {

            // set flag to true if record is found then return falg
            existFlag = true;
            break;
          }
      }
    catch(java.sql.SQLException e)
      {

        //show message if any sql error occured
        JOptionPane.showMessageDialog(null, "Error Finding Data");
      }
    catch(Exception e)
      {
        e.printStackTrace();
      }
    return existFlag;
    }

// method to upadte assignment between user and staff
    public boolean update (StaffUserDto staff_acc){
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
            
            // start connection with database using resourses 
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
          
         

          //get staff id
        jdbc.setCommand("SELECT ID_STAFF FROM STAFF WHERE NAME_STAFF=?");
        jdbc.setString(1, staff_acc.getStaff().getName());
        jdbc.execute();

        while(jdbc.next())
          staff_acc.getStaff().setId(jdbc.getInt("ID_STAFF"));
            
            // database query to perform update action 
            jdbc.setCommand("update STAFF_ACC " + "set ID_STAFF=? where ID_USER = ? ");
            
            // passing object attributes as inputs to the query
            jdbc.setInt(1,staff_acc.getStaff().getId());
            jdbc.setInt(2,staff_acc.getUser_id());
            // query execution
            jdbc.execute();
            return true;
   
       
      }
        
       
        catch(java.sql.SQLException e){
                // show message if any sql error occured

            JOptionPane.showMessageDialog(null, "Error Updating Data");
            return false;
            }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }


  /**Check if staff user account existing in database or not
   * @param take StaffUserDto object
   * @return true if exist, false if not*/
  public Boolean staffIsExist(StaffDto staff)

  {
      boolean existFlag = false;
      try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
          
      //open connection with database using resources
          jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
          jdbc.setUsername("lta");
          jdbc.setPassword("lta");
          
      //query to select the record using its id
          jdbc.setCommand("select ID_USER from STAFF_ACC where ID_STAFF = ? ");
         
      //pass id to query
          try{
              jdbc.setInt(1,staff.getId());
          }catch(NumberFormatException e){
              jdbc.setInt(1,-1);
              }
          
          jdbc.execute();
          while(jdbc.next()){
              
      // set flag to true if record is found then return falg
          existFlag=true;
              break;
          }
      }
      catch(java.sql.SQLException e){
          
      //show message if any sql error occured
          JOptionPane.showMessageDialog(null,"Error Finding Data"); 
      }
      catch(Exception e){
          e.printStackTrace();
      }
      return existFlag;

}

  ///////////////////Nada El-Gammal

  public int getStaffId(StaffUserDto staff_acc)
  {
    int id = 0;
    try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet())
      {

        // start connection with database using resourses
        jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
        jdbc.setUsername("lta");
        jdbc.setPassword("lta");
        jdbc.setCommand("select ID_STAFF from STAFF_ACC where ID_USER = ? ");
        jdbc.setInt(1, staff_acc.getUser_id());
        jdbc.execute();
        while(jdbc.next())
          {
            id = jdbc.getInt("ID_STAFF");
          }
        return id;
      }

    catch(Exception e)
      {
        e.printStackTrace();
        return 0;
      }
  }


}
