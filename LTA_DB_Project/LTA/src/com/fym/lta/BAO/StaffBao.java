package com.fym.lta.BAO;

import com.fym.lta.DTO.CourseDto;
import com.fym.lta.DTO.DepartmentDto;
import com.fym.lta.DTO.EmployeeDto;
import com.fym.lta.DTO.StaffDto;

import com.fym.lta.DTO.StaffUserDto;
import com.fym.lta.DTO.UserDto;

import java.util.List;

public abstract interface StaffBao {
  
    public abstract List<StaffDto> viewAll();

    public abstract boolean delete(StaffDto s);

    public abstract List<StaffDto> SearchFor(StaffDto s);

    public abstract boolean add(StaffDto s , UserDto user);

    public abstract boolean update(StaffDto s , UserDto user);

    public abstract List<CourseDto> viewCourses(StaffDto staff);
    
    public abstract UserDto viewUser(StaffDto staff);

  ////////////////////Nada El-Gammal -- recdntly added

  public abstract int calcMaxId();


}
