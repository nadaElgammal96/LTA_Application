package com.fym.lta.DTO;

import java.util.List;

public class CourseDto {
    
    private String description;
    private String name;
    private int id;
    private String code;
    private Float no_of_hrs;
    private List<LocationTypeDto> plt;
    private  CourseDepartDto depart;
    private WorkOnDto staff;
    
    
    public CourseDto(){
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

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setNo_of_hrs(Float no_of_hrs) {
        this.no_of_hrs = no_of_hrs;
    }

    public Float getNo_of_hrs() {
        return no_of_hrs;
    }

    public void setPlt(List<LocationTypeDto> plt) {
        this.plt = plt;
    }

    public List<LocationTypeDto> getPlt() {
        return plt;
    }
}
