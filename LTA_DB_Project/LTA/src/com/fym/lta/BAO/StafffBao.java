package com.fym.lta.BAO;

import com.fym.lta.DTO.DepartmentDto;
import com.fym.lta.DTO.StaffDto;

public abstract interface StafffBao {
    public abstract void viewAll();

    public abstract void searchFor(DepartmentDto dep);

    public abstract void viewCourses(String ssn);

    public abstract boolean delete(StaffDto s);

    public abstract void searchFor(String ssn);

    public abstract boolean add(StaffDto s);

    public abstract boolean update(StaffDto s);

    public abstract float calcWorkHrs();
}
