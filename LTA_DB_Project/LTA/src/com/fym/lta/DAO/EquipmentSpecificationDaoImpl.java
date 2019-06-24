package com.fym.lta.DAO;

/**
 *
 * @author Nada El-Gammal
 */

import com.fym.lta.DTO.EquipSpecificationDto;
import com.fym.lta.DTO.UserDto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import javax.swing.JOptionPane;

public class EquipmentSpecificationDaoImpl implements EquipmentSpecificationDao {
    
    // update data of specification
    public Boolean update(EquipSpecificationDto es, UserDto user) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
            
            // start connection with database using resourses 
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            
            // database query to perform update action 
            jdbc.setCommand("update EQ_SPEECIFICATION " + "set NAME = ? ,VALUE = ? , UPDATED_BY=? , UPDATED_AT = SYSDATE "
                            +"where NO = ? ");
            
            // passing object attributes as inputs to the query
            jdbc.setString(1,es.getName());
            jdbc.setString(2,es.getValue());
            jdbc.setInt(3,user.getId());

            // check that input to query is integer and set it to -1 if it is not ineger 
            try{jdbc.setInt(4,es.getId());}
            catch(NumberFormatException e){
                jdbc.setInt(4,-1);
                return false;
                }
          
            // query execution
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

// insert new specification in database
    public Boolean createNew(EquipSpecificationDto es , UserDto user) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) 
        {
            // open connection with database using resources
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta"); 
            
            // database query to insert equipment object in table 
            jdbc.setCommand("insert into EQ_SPEECIFICATION  ( NO , NAME , VALUE , INSERTED_BY , INSERTED_AT ) values( ? , ? , ?,?,SYSDATE ) ");
           
            //pass data from dto object to table 
            try{
                jdbc.setInt(1,es.getId());
            }catch(NumberFormatException e){
                jdbc.setInt(1,-1);
            }
            jdbc.setString(2,es.getName());
            jdbc.setString(3,es.getValue());
            jdbc.setInt(4,user.getId());

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

    //delete specification from databas
    public Boolean delete(EquipSpecificationDto es) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
            
            //open connection with database using resources
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            
            //database query to delete equipment by checking its code 
            jdbc.setCommand("delete from EQ_SPEECIFICATION where NO = ? ");
            
            // pass specification id from the object parameter as input to the query 
            try{jdbc.setInt(1,es.getId());
            }catch(NumberFormatException e) {
                jdbc.setInt(1,-1);
            }
            
            //query execution
            jdbc.execute();
            return true;
        }catch(java.sql.SQLException e){
            
            // show message if there are other objects in database that refer to this specification
          JOptionPane.showMessageDialog(null, "There exist Types of this Specification\n Please Delete them first!");
            return false;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    // search for specification using text inserted by user in UI and try to match this text with each column in table
    public List<EquipSpecificationDto> searchFor(EquipSpecificationDto es) {
        
  //identify list of specification objects to store result set in it
        List<EquipSpecificationDto> equip = null;
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
            
   //open connection with database using resources
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");

  //database query to select specifications that search text matches any of their columns
            jdbc.setCommand("select NO, NAME, VALUE " +
                            "from EQ_SPEECIFICATION where NO=? OR NAME=? OR VALUE=? ");
            
 // pass search text from object parameter to query as inputs
            try {jdbc.setInt(1,Integer.parseInt(es.getSearch()));
            }
            catch(NumberFormatException e){
                jdbc.setInt(1,-1);
            }
            jdbc.setString(2,es.getSearch());
            jdbc.setString(3,es.getSearch());
           
           //query execution
            jdbc.execute();
            
            /*identify object to pass the resultset to its attributes then add it to the list
            to be viewed to user if objects found */  
            EquipSpecificationDto e = null;
            while(jdbc.next())
            {
                if(equip == null){
                equip = new ArrayList<>();
                }
                e= new EquipSpecificationDto();
                e.setId(jdbc.getInt("NO"));
                e.setName(jdbc.getString("NAME"));
                e.setValue(jdbc.getString("VALUE"));
                equip.add(e);
                e= null;
            }
        }
            catch(java.sql.SQLException e){
            
                // show message if any sql error ocuured
                JOptionPane.showMessageDialog(null , "Error Searching For Specification");
            }
        catch(Exception e){
            e.printStackTrace();
            }
        return equip;
        }

// view all equipment stored in database
    public List<EquipSpecificationDto> viewAll() {
        
//identify list to store equipemnts objects
        List<EquipSpecificationDto> es = null;
                try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {

   //start connection with database with resources
                    jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
                    jdbc.setUsername("lta");
                    jdbc.setPassword("lta");
                    
    //database query to view specifications ordered ascendingly by id 
                    jdbc.setCommand("select NO, NAME, VALUE " + 
                                    "from EQ_SPEECIFICATION order by NO " );
                    
            //query excecution
                    jdbc.execute();
                    
   //identify object from specifications dto                 
  //pass data obtained from database (when exist) to object attributes then add object to the list 
                    EquipSpecificationDto e = null;
                    while(jdbc.next()){
                        if(es == null){
                        es = new ArrayList<>();
                        }
                        e= new EquipSpecificationDto();
                        e.setId(jdbc.getInt("NO"));
                        e.setName(jdbc.getString("NAME"));
                        e.setValue(jdbc.getString("Value"));
                        es.add(e);
                        e= null;
                    }
                }
        catch(java.sql.SQLException e){
                    
            // show message if any sql error occured
            JOptionPane.showMessageDialog(null , "Error Listing Specification");
        }
                catch(Exception e){
                        e.printStackTrace();
                    }
                return es;
    }

    // check if specification object exists in database or not
    public Boolean isExist(EquipSpecificationDto es) {
        boolean flag = false;
                try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) 
                {
            //open connection with database using resources
                    jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
                    jdbc.setUsername("lta");
                    jdbc.setPassword("lta"); 
                    
            // sql query to look for the specification using its id (NO) and obtain it 
                    jdbc.setCommand("SELECT NO FROM EQ_SPEECIFICATION where NO=?  ");
                    
             // pass the specification id to the query as input from the object parameter
                    jdbc.setInt(1,es.getId());
                    
             // query execution       
                    jdbc.execute();
                    while(jdbc.next()){
                        
            // set the flag to true if the command returns a resultset (specification is found)
                        flag = true;
                        break;
                        }
                    return flag;
                }
        catch(java.sql.SQLException e){
                    
                    //show message if any sql error occured
            JOptionPane.showMessageDialog(null , "Error Finding Specification");
            return false;
        }
                catch(Exception e){
                    e.printStackTrace();
                    return false;
                    }
    }
}
