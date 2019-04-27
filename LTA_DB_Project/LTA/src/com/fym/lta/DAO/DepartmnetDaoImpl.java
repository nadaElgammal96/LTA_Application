package com.fym.lta.DAO;


import com.fym.lta.DTO.BuildingDto;
import com.fym.lta.DTO.DepartmentDto;

import com.fym.lta.DTO.EmployeeDto;

import java.util.Collections;
import java.util.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import javax.swing.JOptionPane;

public class DepartmnetDaoImpl implements DepartmentDao {
    
    
    
    public List<DepartmentDto> searchFor(String c) {
        
        List<DepartmentDto> departs = null;
        try{
            JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("new_hr");
            jdbc.setPassword("hr");
            
            jdbc.setCommand("select ID_DEPARTMENT, CODE_DEPARTMENT, NAME_DEPARTMENT" + 
            "from DEPARTMENT d" + "where DEPARTMENT.NAME_DEPARTMENT="+c);
            
            jdbc.execute();
            
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
            
            
        }
            catch(Exception e){
            e.printStackTrace();
        }
        
        return departs;    
    }

    public boolean delete(DepartmentDto d) {
        
        
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();)
                {
                    jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
                    jdbc.setUsername("new_hr");
                    jdbc.setPassword("hr");
                    jdbc.setCommand("delete from DEPARTMENT where DEPARTMENT.ID_DEPARTMENT="+d.getId());
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

    public boolean createNew(DepartmentDto depart) {
        
        
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();)
        {
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("new_hr");
            jdbc.setPassword("hr");
            jdbc.setCommand("insert into DEPARTMENT (ID_DEPARTMENT,CODE_DEPARTMENT,NAME_DEPARTMENT) values(?,?,?)");
            jdbc.setInt(1,depart.getId());
            jdbc.setString(2,depart.getCode());
            jdbc.setString(3,depart.getName());
            jdbc.execute();
            return true;
        }catch(java.sql.SQLException e){
            return false;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
    }}

    public List<DepartmentDto> viewAll() {
        List<DepartmentDto> departs = null;
        try{
            JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("new_hr");
            jdbc.setPassword("hr");
            
            jdbc.setCommand("select ID_DEPARTMENT, CODE_DEPARTMENT, NAME_DEPARTMENT" + 
            "from DEPARTMENT d");
            
            jdbc.execute();
            
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
            
            
        }
            catch(Exception e){
            e.printStackTrace();
        }
        
        return departs;                                                      
        
    }

    public boolean update(DepartmentDto d) {
        
        
       try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();)
        {
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("new_hr");
            jdbc.setPassword("hr");
           
           
            jdbc.setCommand("UPDATE" + 
            "(" +
            "SELECT ID_DEPARTMENT,CODE_DEPARTMENT,NAME_DEPARTMENT" + 
            "FROM DEPARTMENT" + 
            "WHERE ID_DEPARTMENT="+d.getId() + 
            ")");
           
            jdbc.setInt(1,d.getId());
            jdbc.setString(2,d.getCode());
            jdbc.setString(3,d.getName());
            jdbc.execute();
            return true;
        }catch(java.sql.SQLException e){
            return false;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
    }}

    public boolean isExist(DepartmentDto d) {
        
        
    try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();)
     {
         jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
         jdbc.setUsername("new_hr");
         jdbc.setPassword("hr");
        
        
         jdbc.setCommand("SELECT ID_DEPARTMENT" + 
         "FROM DEPARTMENT" + 
         "WHERE EXISTS" + 
         "SELECT ID_DEPARTMENT" + 
         "FROM DEPARTMENT" + 
         "WHERE ID_DEPARTMENT=)"+d.getId());
        
         d.setId(jdbc.getInt("ID_DEPARTMENT"));
        
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
