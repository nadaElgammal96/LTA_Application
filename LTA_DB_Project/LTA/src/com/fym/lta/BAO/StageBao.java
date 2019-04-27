package com.fym.lta.BAO;

import com.fym.lta.DTO.StageDto;


public abstract interface StageBao {
    public abstract boolean update(StageDto S);

    public abstract void viewAll();

    public abstract void viewCourses();

    public abstract boolean add(StageDto s);

    public abstract void viewDepartment();

    public abstract void searchFor(String code);

    public abstract boolean delete(StageDto s);
}
