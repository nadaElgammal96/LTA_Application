package com.fym.lta.BAO;

import com.fym.lta.DTO.CourseDto;
import com.fym.lta.DTO.DepartmentDto;
import com.fym.lta.DTO.StaffDto;


public abstract interface CourseBao {
    public abstract boolean add(CourseDto course);

    public abstract boolean update(String code);

    public abstract void viewDepOfCourse(CourseDto c);

    public abstract StaffDto viewStaffOfCourse(CourseDto c);

    public abstract void listAll();

    public abstract boolean delete(CourseDto course);

    public abstract void viewCorsesOfDepartment(DepartmentDto d);

    public abstract void viewCourseSlots(String code);
}
