package com.fym.lta.BAO;

import com.fym.lta.DTO.DepartmentDto;

public abstract interface DepartmentBao {
    public abstract boolean delete(DepartmentDto d);

    public abstract void viewAll();

    public abstract boolean update(DepartmentDto d);

    public abstract boolean save(DepartmentDto d);

    public abstract void searchFor(String code);

    public abstract void viewAllCourses();
}
