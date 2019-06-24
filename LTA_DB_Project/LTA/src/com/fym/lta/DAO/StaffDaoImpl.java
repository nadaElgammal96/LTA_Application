package com.fym.lta.DAO;

import com.fym.lta.DTO.CourseDto;
import com.fym.lta.DTO.DepartmentDto;
import com.fym.lta.DTO.EmployeeDto;
import com.fym.lta.DTO.RoleDto;
import com.fym.lta.DTO.StaffDto;

import com.fym.lta.DTO.UserDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import javax.swing.JOptionPane;

public class StaffDaoImpl implements StaffDao {
    UserDaoImpl endUserDaoImpl;

    public Boolean isExist(StaffDto s) {
        boolean flag = false;
                       try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) 
                       {
                           jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
                           jdbc.setUsername("lta");
                           jdbc.setPassword("lta"); 
                           jdbc.setCommand("SELECT ID_STAFF FROM STAFF WHERE ID_STAFF = ?");
                           jdbc.setInt(1, s.getId());
                           jdbc.execute();
                          
                         while(jdbc.next()){
                                flag = true;
                                break;
                                }
                            return flag;
                        } 
                           catch(java.sql.SQLException e){
                               JOptionPane.showMessageDialog(null, "Error Finding Staff!");
                               return false;
                               }
                       
        catch(Exception e){
                       e.printStackTrace();
                       return false;}
    }

    public Boolean createNew(StaffDto s , UserDto user) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();)
        {
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            
            jdbc.setCommand("select ID_DEPARTMENT FROM DEPARTMENT WHERE NAME_DEPARTMENT = ? ");
            jdbc.setString(1,s.getDepartment().getName());
            jdbc.execute();
            while(jdbc.next()){
                s.setDepartment(new DepartmentDto(jdbc.getInt("ID_DEPARTMENT")));
            }
            jdbc.setCommand("insert into STAFF (ID_STAFF , NAME_STAFF , POSTION_STAFF , ID_DEPARTMENT ,INSERTED_BY , INSERTED_AT ) values(?,?,?,?,? , SYSDATE )");
            jdbc.setInt(1,s.getId());
            jdbc.setString(2,s.getName());
            jdbc.setString(3,s.getPosition());
            jdbc.setInt(4,s.getDepartment().getId());
            jdbc.setInt(5,user.getId());
            jdbc.execute();
            return true;
        }catch(java.sql.SQLException e){
            JOptionPane.showMessageDialog(null, "Error Inserting Staff");
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
                    jdbc.setCommand("delete from STAFF where ID_STAFF=? ");
                    jdbc.setInt(1,s.getId());
                    jdbc.execute();
                    return true;
                }catch(java.sql.SQLException e){
            JOptionPane.showMessageDialog(null, "Error Deleting Staff");
                    return false;
                }
                catch(Exception e){
                    e.printStackTrace();
                    return false;
            }
    }

    public Boolean update(StaffDto s ,UserDto user) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();)
         {
             jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
             jdbc.setUsername("lta");
             jdbc.setPassword("lta");
            
             jdbc.setCommand("select ID_DEPARTMENT FROM DEPARTMENT WHERE NAME_DEPARTMENT = ? ");
             jdbc.setString(1,s.getDepartment().getName());
            jdbc.execute();
             while(jdbc.next()){
                 s.setDepartment(new DepartmentDto(jdbc.getInt("ID_DEPARTMENT")));
             }
            
             jdbc.setCommand("UPDATE STAFF " + 
             "SET NAME_STAFF=? , POSTION_STAFF=? , ID_DEPARTMENT=? , UPDATED_BY=?, UPDATED_AT=SYSDATE " + 
              "WHERE ID_STAFF =? " );
           
             jdbc.setString(1,s.getName());
             jdbc.setString(2,s.getPosition());
            try{jdbc.setInt(3,s.getDepartment().getId());
            }catch(NumberFormatException e){
                jdbc.setInt(3,-1);
            }
            jdbc.setInt(4,user.getId());
            
            try{ jdbc.setInt(5,s.getId());
            }catch(NumberFormatException e){
                jdbc.setInt(5,-1);
            }
             jdbc.execute();
             return true;
         //}catch(java.sql.SQLException e){
           //  return false;
         }
         catch(Exception e){
             e.printStackTrace();
             return false;
        }    }

    public List<StaffDto> searchFor(StaffDto st) {
        List<StaffDto> staffs = null;
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();){
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            
            jdbc.setCommand("select STAFF.ID_STAFF, STAFF.NAME_STAFF , STAFF.POSTION_STAFF , DEPARTMENT.NAME_DEPARTMENT "
                + "from STAFF JOIN DEPARTMENT ON (STAFF.ID_DEPARTMENT = DEPARTMENT.ID_DEPARTMENT) " +
                "where STAFF.ID_STAFF=? OR STAFF.NAME_STAFF=? OR STAFF.POSTION_STAFF =? OR DEPARTMENT.NAME_DEPARTMENT=? ");
            try{jdbc.setInt(1,Integer.parseInt(st.getSearch()));}
            catch(NumberFormatException e){
                jdbc.setInt(1,-1);
            }
            jdbc.setString(2,st.getSearch());
            jdbc.setString(3,st.getSearch());
            jdbc.setString(4,st.getSearch());
            jdbc.execute();
            
            StaffDto s = null;
            while(jdbc.next()){
                if(staffs == null){
                    staffs = new ArrayList<>();
                }
                s= new StaffDto();
                s.setId(jdbc.getInt("ID_STAFF"));
                s.setName(jdbc.getString("NAME_STAFF"));
                s.setPosition(jdbc.getString("POSTION_STAFF"));
                s.setDepartment(new DepartmentDto(jdbc.getString("NAME_DEPARTMENT")));
                
                staffs.add(s);
                s= null;
            }
            
            
        }
            catch(Exception e){
            e.printStackTrace();
        }
        
        return  staffs; 
    }

    public List<StaffDto> viewAll() {
        List <StaffDto> staffs = null ;
        try(JdbcRowSet jdbc = RowSetProvider.newFactory() .createJdbcRowSet();) {
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            jdbc.setCommand("select STAFF.ID_STAFF  , STAFF.NAME_STAFF , STAFF.POSTION_STAFF , DEPARTMENT.NAME_DEPARTMENT " +
                "from STAFF , DEPARTMENT " +
                " WHERE STAFF.ID_DEPARTMENT = DEPARTMENT.ID_DEPARTMENT order by STAFF.ID_STAFF");
            jdbc.execute();
            
            StaffDto s = null;
            while(jdbc.next()){
                if (staffs == null ){
                staffs = new ArrayList <>();
                }
               s = new StaffDto ();
                s.setId(jdbc.getInt("ID_STAFF"));
               s.setName(jdbc.getString("NAME_STAFF"));
                s.setPosition(jdbc.getString("POSTION_STAFF"));
                s.setDepartment(new DepartmentDto(jdbc.getString("NAME_DEPARTMENT")));
                staffs.add(s);
                s = null ; 
                
            }
        }
        catch(java.sql.SQLException e){
            JOptionPane.showMessageDialog(null, "Error Listing Staff!");
            }

        catch (Exception e ){
            e.printStackTrace();
        }
        return staffs;
    }
    
    public UserDto viewUserOfStaff(StaffDto staff){
        UserDto user = null;
        try(JdbcRowSet jdbc = RowSetProvider.newFactory() .createJdbcRowSet();) {
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            jdbc.setCommand("select USER_TABLE.ID_USER , USER_TABLE.NAME_USER_ , USER_TABLE.EMAIL_USER , ROLE.NAME_ROLE ,USER_TABLE.PASSWORD_USER "+
          " FROM (STAFF_ACC JOIN STAFF ON (STAFF.ID_STAFF=STAFF_ACC.ID_STAFF)  "+
          " JOIN USER_TABLE ON (USER_TABLE.ID_USER=STAFF_ACC.ID_USER) JOIN ROLE ON (USER_TABLE.ID_ROLE= ROLE.ID_ROLE) ) "+
          "  WHERE STAFF.ID_STAFF=? ");
            jdbc.setInt(1,staff.getId());
            jdbc.execute();
            
            while(jdbc.next()){
                user = new UserDto();
                user.setId(jdbc.getInt("ID_USER"));
                user.setEmail(jdbc.getString("EMAIL_USER"));
                user.setUsername(jdbc.getString("NAME_USER_"));
                user.setPassword(jdbc.getString("PASSWORD_USER"));
                user.setRole(new RoleDto());
                user.getRole().setName(jdbc.getString("NAME_ROLE"));
            }
        }
        catch(java.sql.SQLException e){
            JOptionPane.showMessageDialog(null,"No User Assigned To This Staff");
        }
        catch (Exception e ){
            e.printStackTrace();
        }
        return user;
    }
    
    public List<CourseDto> viewCourses(StaffDto staff){
        List<CourseDto> courses = null;
        try(JdbcRowSet jdbc = RowSetProvider.newFactory() .createJdbcRowSet();) {
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            jdbc.setCommand("select COURSE.ID_COURSE, COURSE.NAME_COURSE, COURSE.CODE_COURSE " +
                "FROM STAFF JOIN STAFF_COURSE ON (STAFF.ID_STAFF = STAFF_COURSE.ID_STAFF) " +
                "JOIN COURSE ON (STAFF_COURSE.ID_COURSE=COURSE.ID_COURSE) " +
                "WHERE STAFF.ID_STAFF=? ");
            try{jdbc.setInt(1,staff.getId());}
            catch(NumberFormatException e){
                jdbc.setInt(1,-1);
            }
            jdbc.execute();
            
            CourseDto course = null;
            while (jdbc.next()){
                if (courses==null){
                courses = new ArrayList <>();
                }
                course = new CourseDto();
                course.setId(jdbc.getInt("ID_COURSE"));
                course.setCode(jdbc.getString("CODE_COURSE"));
                course.setName(jdbc.getString("NAME_COURSE"));
                courses.add(course);
                course=null;
            }
    }
        catch(java.sql.SQLException e){
            JOptionPane.showMessageDialog(null,"Error viewing Courses");
        }
        catch(Exception e){
            e.printStackTrace();
        }
     return courses;   
    }

  //////////////////////Nada El-Gammal
  public int getMaxId()
  {
    int max_id = 0;
    try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet())
      {

        // start connection

        jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
        jdbc.setUsername("lta");
        jdbc.setPassword("lta");
        jdbc.setCommand("select MAX(ID_STAFF) as max FROM STAFF ");
        jdbc.execute();
        while(jdbc.next())
          {
            max_id = jdbc.getInt("max");
          }
      }
    catch(Exception e)
      {
        e.printStackTrace();
      }
    return max_id;

  }

}
