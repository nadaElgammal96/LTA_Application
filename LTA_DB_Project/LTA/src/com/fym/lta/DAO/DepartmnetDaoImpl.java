package com.fym.lta.DAO;

import com.fym.lta.DTO.BuildingDto;
import com.fym.lta.DTO.DepartmentDto;
import java.util.List;
import java.util.ArrayList;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DepartmnetDaoImpl implements DepartmentDao {
    
    
    /* Search For Drparmtment with any attributes of it(id,name,code,...)
     * This method takes department object and return list of department if exist.
    */
    public List<DepartmentDto> searchFor(DepartmentDto d) {
        
        List<DepartmentDto> departs = null;
        
        try{
            
            // Start DataBase connection
            JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            
            // Select all columns from department table which its id/name/code Compatible with search text
            jdbc.setCommand("select* from Employee where DEPARTMENT.ID_DEPARTMENT=? or DEPARTMENT.CODE_DEPARTMENT=? or DEPARTMENT.NAME_DEPARTMENT=?");
                       
                       
            try{ jdbc.setInt(1,Integer.parseInt(d.getSearch()));}
            catch(Exception e){
            e.printStackTrace();
            }
                        jdbc.setString(2,d.getSearch());
                        jdbc.setString(3,d.getSearch());
                        jdbc.execute();
            
            
            //start pick up results from table into objects
            DepartmentDto depart = null;
            while(jdbc.next()){
                if(departs == null){
                    departs = new ArrayList<>();
                }
                depart = new DepartmentDto();
                depart.setId(jdbc.getInt("ID_DEPARTMENT"));
                depart.setCode(jdbc.getString("CODE_DEPARTMENT"));
                depart.setName(jdbc.getString("NAME_DEPARTMENT"));
                
                departs.add(depart);
                depart= null;
            }
            
            //get Buildings for each department 
            for (DepartmentDto de:departs) {
            
                jdbc.setCommand("select ID_BUILD" + 
                "from DEPARTMENT_BUILDING" +
                "where ID_DEPARTMENT = ?");
                jdbc.setInt(1,de.getId());
                jdbc.execute();
                
                List<BuildingDto> builds=null;
                BuildingDto b=null;
                while(jdbc.next()){
                    
                    if(builds == null){
                        builds = new ArrayList<>();
                    }
                    b.setId(jdbc.getInt("ID_DUILD"));
                    
                    //get building name for each of them
                    jdbc.setCommand("select CODE_BUILD" + 
                    "from BUILDING" +
                    "where ID_BUILD = ?");
                    jdbc.setInt(1,b.getId());
                    jdbc.execute();
                    b.setCode(jdbc.getString("CODE_DUILD"));
                    builds.add(b);
                    
                    b= null;
                }
                de.setBuildings(builds);
            }
            
            
            
        }
            catch(Exception e){
            e.printStackTrace();
        }
        
        return departs;    
    }


  /* Delete a row selected by user in GUI.
   * Takes the object and return true if it has deleted and false if any exception occur*/

    public boolean delete(DepartmentDto d) {
        
        
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();)
                {
            
                    // Start DataBase connection
                    jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
                    jdbc.setUsername("lta");
                    jdbc.setPassword("lta");
            
            
                   // Delete the row with id of the selected department and its dependence
                    jdbc.setCommand("delete from DEPARTMENT_BUILDING where ID_DEPARTMENT=?");
                    jdbc.setInt(1,d.getId());
                    jdbc.setCommand("delete from DEPARTMENT where DEPARTMENT.ID_DEPARTMENT=?");
                    jdbc.setInt(1,d.getId());
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


/* Create a new department 
 * takes department object inserted by user 
 * Returm true for if it success, False if not */
    
    public boolean createNew(DepartmentDto depart) {
        
        
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();)
        {
            
            
            // Start DataBase connection
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            
            // insert into database 
            jdbc.setCommand("insert into DEPARTMENT (ID_DEPARTMENT,CODE_DEPARTMENT,NAME_DEPARTMENT) values(?,?,?)");
                
            jdbc.setInt(1,depart.getId());
            jdbc.setString(2,depart.getCode());
            jdbc.setString(3,depart.getName());
            jdbc.execute();
            
            //Insert department in buildings through thier relationship
            for(BuildingDto b:depart.getBuildings())
            {
                jdbc.setCommand("insert into DEPARTMENT_BUILDING" +
                    "(ID_DEPARTMENT,ID_BUILD) values(?,?)");
                jdbc.setInt(1,depart.getId());
                jdbc.setInt(2,b.getId());

            }
            return true;
            
        }catch(java.sql.SQLException e){
            return false;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
    }}



/* Method to pick up all tuples from department table
 * no parameters
 * return list of departmentdto objects
 */
    public List<DepartmentDto> viewAll() {

        @SuppressWarnings("unchecked")
        List<DepartmentDto> departs = new ArrayList();
        
        try{
            // Start DataBase connection
            JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            
            //select department id,code,name, from table 
            jdbc.setCommand("SELECT ID_DEPARTMENT,CODE_DEPARTMENT,NAME_DEPARTMENT " + 
            "FROM DEPARTMENT ");
            jdbc.execute();
            
            //insert them into department objects 
            DepartmentDto depart = new DepartmentDto();
            while(jdbc.next()){
                if(departs == null){
                    departs = new ArrayList<>();
                }
                depart = new DepartmentDto();
                depart.setId(jdbc.getInt("ID_DEPARTMENT"));
                depart.setCode(jdbc.getString("CODE_DEPARTMENT"));
                depart.setName(jdbc.getString("NAME_DEPARTMENT"));
                
                departs.add(depart);
                depart= null;
            }
            
            //get Buildings for each department 
            for (DepartmentDto d:departs) {
            
                jdbc.setCommand("select ID_BUILD " + 
                "FROM DEPARTMENT_BUILDING " +
                "WHERE ID_DEPARTMENT = ? ");
                jdbc.setInt(1,d.getId());
                jdbc.execute();
                
                List<BuildingDto> builds= null;
                BuildingDto b= new BuildingDto();
                
                while(jdbc.next()){
                    
                    if(builds == null){
                        builds = new ArrayList<>();
                    }
                   
                    b.setId(jdbc.getInt("ID_BUILD"));
                    
                    //get building code for each of them
                    jdbc.setCommand("select CODE_BUILD " + 
                    "from BUILDING " +
                    "where ID_BUILD = ? ");
                    jdbc.setInt(1,b.getId());
                    jdbc.execute();
                    
                    while (jdbc.next())
                           b.setCode(jdbc.getString("CODE_BUILD"));
                    
                    builds.add(b);
                    b= null;
                }
                   d.setBuildings(builds);
            }
                        
        }
            catch(Exception e){
            e.printStackTrace();
            
        }    
    return departs; }


/* update object selected by user 
 * take department object from bao
 * Returm true for if it success, False if not */
    
    public boolean update(DepartmentDto d) {
        
        
       try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();)
        {
            // Start DataBase connection
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
           
           
           
           // update name & code for deparment which its id can't be updated 
            jdbc.setCommand("UPDATE DEPARTMENT" + 
                         "(" +
                         "SET CODE_DEPARTMENT = ?,NAME_DEPARTMENT = ?" + 
                         "WHERE ID_DEPARTMENT = ?");
            
                         jdbc.setString(1,d.getCode());
                         jdbc.setString(3,d.getName());
                         jdbc.setInt(3,d.getId()); 
                         jdbc.execute();
           
            for(BuildingDto b:d.getBuildings())
            {
                jdbc.setCommand("insert into DEPARTMENT_BUILDING" +
                    "(ID_DEPARTMENT,ID_BUILD) values(?,?)");
                jdbc.setInt(1,d.getId());
                jdbc.setInt(2,b.getId());

            }
                         return true;
        }catch(java.sql.SQLException e){
            return false;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
    }}


/* Check if object is exist in database  
 * take this object and return boolean value show if it is exist or not
 * */ 
    public boolean isExist(DepartmentDto d) {
          
    try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();)
     {
        
        // start connection 

         jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
         jdbc.setUsername("lta");
         jdbc.setPassword("lta");
        
        // select from table department which its id = object id 
         jdbc.setCommand("SELECT * " + 
         "FROM DEPARTMENT" +
          "WHERE ID_DEPARTMENT = ?" );
         jdbc.setInt(1,d.getId());
         jdbc.execute();
            if (d.getId()==0) {
                return false;
            } else {
                return true;
            }
        }catch(java.sql.SQLException e){
         return false;
     }
     catch(Exception e){
         e.printStackTrace();
         return false;
    }
}}
