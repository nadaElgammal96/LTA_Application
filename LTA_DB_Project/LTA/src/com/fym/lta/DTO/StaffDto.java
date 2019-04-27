package com.fym.lta.DTO;

public class StaffDto {   
    
    private int ssn;
    private String description;
    private String mname;
    private String position;
    private int department_id;
    private String fname;
    private String lname;
    private String Search; 
    private StaffUserDto account;
    private WorkOnDto courses;
    private int WorkHours;

    
    public StaffDto(){
        super();
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public int getSsn() {
        return ssn;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMname() {
        return mname;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFname() {
        return fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getLname() {
        return lname;
    }

    public void setSearch(String Search) {
        this.Search = Search;
    }

    public String getSearch() {
        return Search;
    }

    public void Add(StaffDto s) {
    }
}
