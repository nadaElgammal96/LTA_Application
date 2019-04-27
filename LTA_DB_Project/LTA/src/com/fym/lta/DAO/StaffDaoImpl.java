package com.fym.lta.DAO;

import com.fym.lta.DTO.EmployeeDto;
import com.fym.lta.DTO.StaffDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class StaffDaoImpl implements StaffDao {
    UserDaoImpl endUserDaoImpl;

    public Boolean isExist(StaffDto s) {
        return null;
    }

    public Boolean createNew(StaffDto s) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();)
        {
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            jdbc.setCommand("insert into STAFF (SSN_STAFF "+"DESCRIPTION_STAFF " + "NAME_STAFF " + "POSTION_STAFF " + "ID_DEPARTMENT) values(?,?,?,?,?)");
            jdbc.setInt(1,s.getSsn());
            jdbc.setString(2,s.getDescription());
            jdbc.setString(3,s.getMname());
            jdbc.setString(4,s.getPosition());
            jdbc.setInt(5,s.getDepartment_id());
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

    public Boolean delete(StaffDto s) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();)
                {
                    jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
                    jdbc.setUsername("lta");
                    jdbc.setPassword("lta");
                    jdbc.setCommand("delete from STAFF where SSN_STAF="+s.getSsn());

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

    public Boolean update(StaffDto s) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();)
         {
             jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
             jdbc.setUsername("lta");
             jdbc.setPassword("lta");
            
             jdbc.setCommand("UPDATE STAFF " + 
             "(" +
             "SET SSN_STAFF,DESCRIPTION_STAFF,NAME_STAFF, POSTION_STAFF, ID_DEPARTMENT" + 
              "WHERE SSN_STAFF values (?,?,?,?,?,?)" );
           
            
             jdbc.setInt(1,s.getSsn());
             jdbc.setString(2,s.getDescription());
             jdbc.setString(3,s.getMname());
             jdbc.setString(4,s.getPosition());
             jdbc.setInt(5,s.getDepartment_id());

             jdbc.execute();
             return true;
         }catch(java.sql.SQLException e){
             return false;
         }
         catch(Exception e){
             e.printStackTrace();
             return false;
        }    }

    public List<StaffDto> searchFor(StaffDto s1) {
        List<StaffDto> staffs = null;
        StaffDto staff = null;
        try{
            JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            
            jdbc.setCommand("select* from STAFF where STAFF.SSN_STAFF=values (?) | STAFF.DESCRIPTION_STAFF=values (?) | STAFF.NAME_STAFF=values (?) | STAFF.POSTION_STAFF");
            jdbc.setInt(1,Integer.parseInt(staff.getSearch()));
            jdbc.setString(2,staff.getSearch());
            jdbc.setString(3,staff.getSearch());
            jdbc.setString(4,staff.getSearch());
            jdbc.setInt(1,Integer.parseInt(staff.getSearch()));
            jdbc.execute();
            
            StaffDto s = null;
            while(jdbc.next()){
                if(staff == null){
                    staffs = new ArrayList<>();
                }
                s= new StaffDto();
                s.setSsn(jdbc.getInt("SSN_STAFF"));
                s.setDescription(jdbc.getString("DESCRIPTION_STAFF"));
                s.setMname(jdbc.getString("NAME_STAFF"));
                s.setPosition(jdbc.getString("POSTION_STAFF"));
                s.setDepartment_id(jdbc.getInt("ID_DEPARTMENT_STAFF"));
                
                staff.Add(s);
                s= null;
            }
            
            
        }
            catch(Exception e){
            e.printStackTrace();
        }
        
        return  staffs; 
    }

    public List<StaffDto> viewAll() {
        return Collections.emptyList();
    }
}
