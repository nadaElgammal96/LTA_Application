package com.fym.lta.DTO;

public class EmployeeDto {
    
    
    private String name;
    private int id;
    private String job;
    private String search;

    public void setSearch(String search) {
        this.search = search;
    }

    public String getSearch() {
        return search;
    }
    private EmployeeUserDto account;
    
    
    public EmployeeDto(){
        super();
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

    public void setJob(String job) {
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    public void setSsn(int i) {
    }

    public EmployeeDto(String search) {
        this.search = search;
    }
}
