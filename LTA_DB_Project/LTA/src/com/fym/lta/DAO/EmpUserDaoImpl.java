package com.fym.lta.DAO;

import com.fym.lta.DTO.EmployeeDto;
import com.fym.lta.DTO.EmployeeUserDto;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import javax.swing.JOptionPane;

public class EmpUserDaoImpl implements EmpUserDao {
    public EmpUserDaoImpl() {
        super();
    }

//method to insert new record relating a user with existing employee
    public boolean insert(EmployeeUserDto emp_acc) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
            
            //open connection with dataase using resources
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
          
          
        //get employee id
        jdbc.setCommand("SELECT ID_EMPLOYEE FROM EMPLOYEE WHERE NAME_EMPLOYEE=? ");
        jdbc.setString(1, emp_acc.getEmployee().getName());
        jdbc.execute();

        while(jdbc.next())
         emp_acc.getEmployee().setId(jdbc.getInt("ID_EMPLOYEE"));
          
          
            
            //query to insert employee id and its user id in database 
            jdbc.setCommand("insert into EMP_ACC ( ID_USER , ID_EMPLOYEE  ) VALUES ( ? , ? ) ");
            
        //pass objects from dto object to query as input to be inserted
            try{
                jdbc.setInt(1,emp_acc.getUser_id());
            }catch(NumberFormatException e){
                jdbc.setInt(1,-1);
            }
            try{
                jdbc.setInt(2,emp_acc.getEmployee().getId());
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

// mehod to delete relation between employee and user
    public boolean delete(EmployeeUserDto emp_acc) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
            
        // open connection with database using resources
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            
        // query to delete record using its id
            jdbc.setCommand("delete from EMP_ACC where ID_USER = ? ");
          
          //pass id from dto object parameter to the query
            try{jdbc.setInt(1,emp_acc.getUser_id());
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

    //method to check if record exists in database or not
    public boolean isExist(EmployeeUserDto emp_acc) {
        boolean existFlag = false;
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
            
        //open connection with database using resources
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            
        //query to select the record using its id
            jdbc.setCommand("select ID_USER from EMP_ACC where ID_USER = ? ");
           
        //pass id to query
            try{
                jdbc.setInt(1,emp_acc.getUser_id());
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

// method to upadte assignment between user and employee
    public boolean update(EmployeeUserDto emp_acc) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
            
            // start connection with database using resourses 
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");

        //get employee id
        jdbc.setCommand("SELECT ID_EMPLOYEE FROM EMPLOYEE WHERE NAME_EMPLOYEE=?");
        jdbc.setString(1, emp_acc.getEmployee().getName());
        jdbc.execute();
        while(jdbc.next())
          emp_acc.getEmployee().setId(jdbc.getInt("ID_EMPLOYEE"));
            
            // database query to perform update action 
            jdbc.setCommand("update EMP_ACC " + "set ID_EMPLOYEE=? where ID_USER = ? ");
            
            // passing object attributes as inputs to the query
            jdbc.setInt(1,emp_acc.getEmployee().getId());
            jdbc.setInt(2,emp_acc.getUser_id());
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
            return false;}
        }

  /**Check if staff user account existing in database or not
   * @param take EmployeeUserDto object
   * @return true if exist, false if not*/
  public Boolean employeeIsExist(EmployeeDto u)
  
  {
    boolean existFlag = false;
    try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet())
      {

        //open connection with database using resources
        jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
        jdbc.setUsername("lta");
        jdbc.setPassword("lta");

        //query to select the record using its id
        jdbc.setCommand("select ID_USER from EMP_ACC where ID_EMPLOYEE = ? ");

        //pass id to query
        try
          {
            jdbc.setInt(1, u.getId());
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

        e.printStackTrace();
      }
    catch(Exception e)
      {
        e.printStackTrace();
      }
    return existFlag;
    
    
  }
}
