package com.fym.lta.DTO;

import java.util.List;
import java.util.Set;

public class DepartmentDto {
    
    private String code;
    private String name;
    private int id;
    private String faculty_name;
    
    //For Relations in Class diagram
    private DepartBuildingDto building;
    private List<StaffDto> depart_staff;
    private List<StageDto> Stages;
    private  CourseDepartDto courses;

    public DepartmentDto(){
        super();
        }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public DepartmentDto(String code, String name, int id) {
        this.code = code;
        this.name = name;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setFaculty_name(String faculty_name) {
        this.faculty_name = faculty_name;
    }

    public String getFaculty_name() {
        return faculty_name;
    }
}
