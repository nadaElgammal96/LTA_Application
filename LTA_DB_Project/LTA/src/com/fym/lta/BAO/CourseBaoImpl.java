package com.fym.lta.BAO;

import com.fym.lta.DAO.CourseDao;
import com.fym.lta.DAO.CourseDaoImpl;
import com.fym.lta.DAO.DaoFactory;
import com.fym.lta.DAO.LocationTypeDaoImpl;
import com.fym.lta.DTO.CourseDto;
import com.fym.lta.DTO.DepartmentDto;
import com.fym.lta.DTO.LocationTypeDto;
import com.fym.lta.DTO.StaffDto;

import com.fym.lta.DTO.StaffUserDto;
import com.fym.lta.DTO.UserDto;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class CourseBaoImpl implements CourseBao {
    
    private  CourseDao dao = new DaoFactory().createCourseDao(); //create dao course object
    UserBaoImpl endUserBaoImpl;


  /** Search For course with any attributes of it(id,name,code,...)
   * This method takes course object and return list of courses if exist.
   */
    public List<CourseDto> searchFor(CourseDto c) {

        List<CourseDto> courses = new ArrayList<CourseDto>();

        try {
            courses = dao.searchFor(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courses;
    }


  /** Create a new course
   * takes course object inserted by user
   * Returm true for if it success, False if not */
    public boolean add(CourseDto course,UserDto  user) {
        
        CourseDaoImpl dao=null;
        dao=new CourseDaoImpl();
        
        boolean saveFlage = false;
        try{
            
            if(!dao.isExist(course))
                saveFlage = dao.createNew(course , user);
            
            return saveFlage;

        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }


  /** update an existed one
   * @param takes course object inserted by user
   * @Return true for if it success, False if not */
    public boolean update(CourseDto c ,UserDto user) {
        
        CourseDaoImpl dao = new CourseDaoImpl();
        boolean saveFlage = false;
        try {
            if (dao.isExist(c))
                saveFlage = dao.update(c,user);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Some thing went wrong.",
                                          "Exception occured!", 1);
            return false;
        }
        return saveFlage;
        }
    
//??
    public void viewDepOfCourse(CourseDto c) {
    }

//???
    public StaffDto viewStaffOfCourse(CourseDto c) {
        return null;
    }


  /** Method to view all exist department
   * @param no parameters
   * @return list of coursedto objects */
    public  List<CourseDto> listAll() {
        
        CourseDaoImpl dao = new CourseDaoImpl();

        List<CourseDto> types = new ArrayList<CourseDto>();

        try {
            types = dao.viewAll();
        }

        catch (Exception e) {
            e.printStackTrace();

        }
        return types;
    }


  /** Delete a row selected by user in GUI.
   * Takes the object and return true if it has deleted and false if any exception occur*/
    public boolean delete(CourseDto course) {
        boolean deleteFlag = false;
        try{
                if(dao.isExist(course))
                        deleteFlag = dao.delete(course);

                return deleteFlag;
               }
            catch(Exception e){
                   e.printStackTrace();
                   return false;
               }

    }


//??
    public void viewCorsesOfDepartment(DepartmentDto d) {
    }


//??
    public void viewCourseSlots(String code) {
    }



  ///////Nada El-Gammal

  public int calcMaxId()
  {
    int id = 0;
    try
      {
        id = dao.getMaxId();
      }
    catch(Exception e)
      {
        e.printStackTrace();
      }
    return id;
  }


  ///////////////////Nada El-Gammal
  public boolean isExist(CourseDto c)
  {
    boolean existFlag = false;
    try
      {
        existFlag = dao.isExist(c);
      }
    catch(Exception e)
      {
        e.printStackTrace();
      }
    return existFlag;
  }

  ///////Nada El-Gammal

  public int getId(CourseDto c)
  {
    int id = 0;
    try
      {
        id = dao.getId(c);
      }
    catch(Exception e)
      {
        e.printStackTrace();
      }
    return id;
  }

  ///////Nada El-Gammal

  public boolean isAssigned(CourseDto c, DepartmentDto d)
  {
    boolean flag = false;
    try
      {
        flag = dao.isAssigned(c, d);
      }
    catch(Exception e)
      {
        e.printStackTrace();
      }
    return flag;
  }

  ///////Nada El-Gammal

  public boolean assignDepCourse(CourseDto c, DepartmentDto d)
  {
    boolean flag = false;
    try
      {
        flag = dao.assignDepCourse(c, d);
      }
    catch(Exception e)
      {
        e.printStackTrace();
      }
    return flag;
  }


  ////////////////Nada El-Gammal

  public List<DepartmentDto> viewDepsOfCourse(CourseDto c)
  {
    CourseDaoImpl dao = new CourseDaoImpl();
    List<DepartmentDto> departs = null;
    try
      {
        departs = dao.viewDepsOfCourse(c);
      }
    catch(Exception e)
      {
        e.printStackTrace();
      }
    return departs;
  }

 
}
