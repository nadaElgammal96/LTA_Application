package com.fym.lta.BAO;

import com.fym.lta.DAO.DaoFactory;
import com.fym.lta.DAO.StaffDao;
import com.fym.lta.DAO.StaffDao;
import com.fym.lta.DTO.DepartmentDto;
import com.fym.lta.DTO.StaffDto;
import com.fym.lta.BAO.StaffBao;

import com.fym.lta.DTO.CourseDto;
import com.fym.lta.DTO.EmployeeDto;

import com.fym.lta.DTO.StaffUserDto;
import com.fym.lta.DTO.UserDto;

import java.util.List;

import javax.swing.JOptionPane;


public class StaffBaoImpl implements StaffBao {
    private  StaffDao dao = new DaoFactory().createStaffDao();
    UserBaoImpl endUserBaoImpl;

    public List<StaffDto> viewAll() {
        List<StaffDto> staff = null;
        try{
            staff = dao.viewAll();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return staff;
    }


    public boolean delete(StaffDto s) {
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
                      return deleteFlage;
    }

    public List<StaffDto> SearchFor(StaffDto s) {
        List<StaffDto> staff = null;
                try{
                   staff  = dao.searchFor(s);
                    return staff  ;
                }catch(Exception e){
                    e.printStackTrace();
                    return staff ;
                }  
    }

    public boolean add(StaffDto s ,UserDto user) {
        boolean saveFlage = true;
               try{
                     //data is valid
                    if(dao.isExist(s)){
                        JOptionPane.showMessageDialog(null,"Record Already Exixts");
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
    

    public boolean update(StaffDto s,UserDto user) {
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
                      return saveFlage;
    }

    public List<CourseDto> viewCourses(StaffDto staff) {
        List<CourseDto> courses = null;
        try{
            courses=dao.viewCourses(staff);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return courses;
    }
    
    public UserDto viewUser(StaffDto staff){
        UserDto user = null;
        try {
            if (dao.isExist(staff)){
                user=dao.viewUserOfStaff(staff);
            }
            else{
                JOptionPane.showMessageDialog(null,"Staff Does Not Exist");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }

 

  /////////////////////////Nada El-Gammal    
      public int calcMaxId(){
          int id = 0 ;
          try{
              id = dao.getMaxId();
          }
          catch(Exception e){
              e.printStackTrace();
          }
          return id;
      }
  }


