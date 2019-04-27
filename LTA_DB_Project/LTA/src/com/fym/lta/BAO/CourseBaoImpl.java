package com.fym.lta.BAO;

import com.fym.lta.DTO.CourseDto;
import com.fym.lta.DTO.DepartmentDto;
import com.fym.lta.DTO.StaffDto;
import com.fym.lta.DTO.StaffDto;

public class CourseBaoImpl implements CourseBao {
    public boolean add(CourseDto course) {
        return false;
    }

    public boolean update(String code) {
        return false;
    }

    public void viewDepOfCourse(CourseDto c) {
    }

    public StaffDto viewStaffOfCourse(CourseDto c) {
        return null;
    }

    public void listAll() {
    }

    public boolean delete(CourseDto course) {
        return false;
    }

    public void viewCorsesOfDepartment(DepartmentDto d) {
    }

    public void viewCourseSlots(String code) {
    }
}
