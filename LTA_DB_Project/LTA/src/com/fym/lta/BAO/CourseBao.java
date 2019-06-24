package com.fym.lta.BAO;

import com.fym.lta.DTO.CourseDto;
import com.fym.lta.DTO.DepartmentDto;
import com.fym.lta.DTO.EquipmentDto;
import com.fym.lta.DTO.StaffDto;

import com.fym.lta.DTO.UserDto;

import java.util.List;


public abstract interface CourseBao {


  /** Create a new course
   * @param takes course object inserted by user
   * @Return true for if it success, False if not */
    public abstract boolean add(CourseDto course,UserDto user);

  /** update an existed one
   * @param takes course object inserted by user
   * @Return true for if it success, False if not */
    public abstract boolean update(CourseDto c , UserDto user);

  /** Search For course with any attributes of it(id,name,code,...)
   * This method takes course object and return list of courses if exist.
   */
    public abstract List<CourseDto> searchFor(CourseDto c);

  /** Method to view all exist course
   * @param no parameters
   * @return list of coursedto objects */
    public abstract List<CourseDto> listAll();


  /** Delete a row selected by user in GUI.
   * Takes the object and return true if it has deleted and false if any exception occur*/
    public abstract boolean delete(CourseDto course);

    public abstract void viewCorsesOfDepartment(DepartmentDto d);

    public abstract void viewCourseSlots(String code);

  public abstract void viewDepOfCourse(CourseDto c);

  public abstract StaffDto viewStaffOfCourse(CourseDto c);


  ////////////////////Nada El-Gammal
  public abstract boolean isExist(CourseDto c);


  ////////////////////Nada El-Gammal
  public abstract int getId(CourseDto c);


  ////////////////////Nada El-Gammal
  public abstract int calcMaxId();


  ////////////////////Nada El-Gammal
  public abstract boolean isAssigned(CourseDto c, DepartmentDto d);


  ////////////////////Nada El-Gammal
  public abstract boolean assignDepCourse(CourseDto c, DepartmentDto d);


  ////////////////////Nada El-Gammal
  public abstract List<DepartmentDto> viewDepsOfCourse(CourseDto c);

 
 
}
