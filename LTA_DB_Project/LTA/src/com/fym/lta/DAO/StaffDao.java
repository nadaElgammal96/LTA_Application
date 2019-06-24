package com.fym.lta.DAO;

import com.fym.lta.DTO.CourseDto;
import com.fym.lta.DTO.StaffDto;

import com.fym.lta.DTO.UserDto;

import java.util.List;

public abstract interface StaffDao {
    public abstract Boolean isExist(StaffDto s);

    public abstract Boolean createNew(StaffDto s , UserDto user);

    public abstract Boolean delete(StaffDto s);

    public abstract Boolean update(StaffDto s , UserDto user);

    public abstract List<StaffDto> searchFor(StaffDto s);

    public abstract List<StaffDto> viewAll();
    
    public abstract UserDto viewUserOfStaff(StaffDto staff);
    
    public abstract List<CourseDto> viewCourses(StaffDto staff);


    ////////////////////Nada El-Gammal
    public abstract int getMaxId();
    
   
    
}
