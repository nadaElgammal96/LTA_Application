package com.fym.lta.BAO;

import com.fym.lta.DTO.DepartmentDto;

import java.util.List;

public abstract interface DepartmentBao {
    public abstract boolean delete(DepartmentDto d);

    public abstract List<DepartmentDto> viewAll();

    public abstract boolean update(DepartmentDto d);
  
    public abstract boolean create(DepartmentDto d);
    
    public abstract List<DepartmentDto> searchFor(DepartmentDto d);

    public abstract void viewAllCourses();
}
