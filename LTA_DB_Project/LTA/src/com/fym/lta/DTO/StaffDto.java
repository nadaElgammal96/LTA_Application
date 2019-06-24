package com.fym.lta.DTO;

public class StaffDto {   
    
    private int id;
    private String name;
    private String position;
    private DepartmentDto department;
    private String Search; 
    private StaffUserDto account;
    private WorkOnDto courses;
    private int WorkHours;

    
    public StaffDto(){
        super();
    }
    public void setSearch(String search) {
        this.Search = search;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public void setName(String mname) {
        this.name = mname;
    }

    public String getName() {
        return name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setDepartment(DepartmentDto department) {
        this.department = department;
    }

    public DepartmentDto getDepartment() {
        return department;
    }
 

    public String getSearch() {
        return Search;
    }

    public void Add(StaffDto s) {
    }

    public void setWorkHours(int WorkHours) {
        this.WorkHours = WorkHours;
    }

    public int getWorkHours() {
        return WorkHours;
    }
}
