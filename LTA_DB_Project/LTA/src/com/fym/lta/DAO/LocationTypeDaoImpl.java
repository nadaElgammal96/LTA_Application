package com.fym.lta.DAO;


import com.fym.lta.DTO.LocationTypeDto;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

/**
 *
 * @author Mai-AbdEltwab
 */


public class LocationTypeDaoImpl implements LocationTypeDao {
    
    
    public Boolean update(LocationTypeDto lt) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();)
         {
             // Start DataBase connection
             jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
             jdbc.setUsername("lta");
             jdbc.setPassword("lta");
          
            // update name & code for location type which its id can't be updated 
             jdbc.setCommand("UPDATE LOCATION_TYPE " + 
                          "SET CODE_LOC_TYPE=? ,COLOR = ?,DESCRIBTION_LOC_TYPE = ? " + 
                          "WHERE ID_LOC_TYPE = ?");
                          jdbc.setString(1,lt.getCode());    
                          jdbc.setString(2,lt.getColor());
                          jdbc.setString(3,lt.getDescription());
                          jdbc.setInt(4,lt.getId()); 
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

    public List<LocationTypeDto> viewAll() {
        
        List<LocationTypeDto> types =null;
        
        try{
            // Start DataBase connection
            JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            
            // Select all columns from Lication type table which its id/name/code Compatible with search text
            jdbc.setCommand("select ID_LOC_TYPE,CODE_LOC_TYPE, COLOR,DESCRIBTION_LOC_TYPE  from LOCATION_TYPE");
                        jdbc.execute();
            
            
                //start pick up results from table into objects
                LocationTypeDto t = null;
                while(jdbc.next()){
                    
                    if(types== null){
                       types = new ArrayList<>();
                    }
                    t = new LocationTypeDto();                   
                    t.setId(jdbc.getInt("ID_LOC_TYPE"));
                    t.setCode(jdbc.getString("CODE_LOC_TYPE"));
                    t.setColor(jdbc.getString("COLOR"));
                    t.setDescription(jdbc.getString("DESCRIBTION_LOC_TYPE"));
                    
                    types.add(t);
                    t= null; 
            }}
            catch(Exception e){
                System.out.println("aaaaa");

            e.printStackTrace();
            }
        
        return types;
    }

    public Boolean isExist(LocationTypeDto lt) {
        
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();)
         {
            
            // start connection 
             jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
             jdbc.setUsername("lta");
             jdbc.setPassword("lta");
            
            // select from table LOCATION TYPE which its id = object id
            jdbc.setCommand("SELECT ID_LOC_TYPE " + "FROM LOCATION_TYPE " +
                            "WHERE ID_LOC_TYPE=?");
             jdbc.setInt(1,lt.getId());
             jdbc.execute();
            
              boolean flage = false;
            
                while(jdbc.next()){
                     flage = true;
                      break;
                 }
                 return flage;
                                
            }catch(java.sql.SQLException e){
             return false;
         }
         catch(Exception e){
             e.printStackTrace();
             return false;
        }
        }
    

    public List<LocationTypeDto> searchFor(LocationTypeDto type) {
        
        List<LocationTypeDto> types = null;
        
        try{
            
            // Start DataBase connection
            JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            
            // Select all columns from location type table which its id/name/code Compatible with search text
            jdbc.setCommand("select ID_LOC_TYPE,CODE_LOC_TYPE,COLOR,DESCRIBTION_LOC_TYPE " +
                "from LOCATION_TYPE " +
                "where ID_LOC_TYPE =? or COLOR=? or CODE_LOC_TYPE=? or DESCRIBTION_LOC_TYPE=?");
                       
            try{ jdbc.setInt(1,Integer.parseInt(type.getSearch()));}
            catch(Exception e){
                jdbc.setInt(1, -1);
            }
                        jdbc.setString(2,type.getSearch());
                        jdbc.setString(3,type.getSearch());
                        jdbc.setString(4,type.getSearch());
                        jdbc.execute();
            
            
                //start pick up results from table into objects
                LocationTypeDto t = new LocationTypeDto();
                while(jdbc.next()){
                    if(types== null){
                       types = new ArrayList<>();
                    }
                    
                    t.setId(jdbc.getInt("ID_LOC_TYPE"));
                    t.setCode(jdbc.getString("CODE_LOC_TYPE"));
                    t.setColor(jdbc.getString("COLOR"));
                    t.setDescription(jdbc.getString("DESCRIBTION_LOC_TYPE"));
                    
                    types.add(t);
                    t= null;} 
            }
            catch(Exception e){
            e.printStackTrace();
        }
        
        return types;    
    }

    public Boolean delete(LocationTypeDto lt) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();)
                {
            
                    // Start DataBase connection
                    jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
                    jdbc.setUsername("lta");
                    jdbc.setPassword("lta");
            
                   // Delete the row with id of the selected location type and its dependence
                    jdbc.setCommand("delete from LOCATION where ID_LOC_TYPE=?");
                    jdbc.setInt(1, lt.getId());
                    jdbc.setCommand("delete from LOCATION_TYPE where ID_LOC_TYPE=?");
                    jdbc.setInt(1,lt.getId());
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

    public Boolean createNew(LocationTypeDto lt) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();)
        {
    
            // Start DataBase connection
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            
            // insert into database 
            jdbc.setCommand("insert into LOCATION_TYPE (ID_LOC_TYPE,CODE_LOC_TYPE,COLOR,DESCRIBTION_LOC_TYPE) values(?,?,?,?)");
                
            jdbc.setInt(1,lt.getId());
            jdbc.setString(2,lt.getCode());
            jdbc.setString(3,lt.getColor());
            jdbc.setString(4,lt.getDescription());
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
}
