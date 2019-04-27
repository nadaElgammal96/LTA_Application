package com.fym.lta.DTO;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FacultyDto {
    
    
    private String description;
    private String name;
    private int stages;
    private List<DepartmentDto> Departments ;


    public void setDepartments(List<DepartmentDto> Departments) {
        this.Departments = Departments;
    }

    public List<DepartmentDto> getDepartments() {
        return Departments;
    }

    public FacultyDto(){
        super();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStages(int stages) {
        this.stages = stages;
    }

    public int getStages() {
        return stages;
    }
}
