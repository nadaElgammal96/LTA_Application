package com.fym.lta.DTO;

public class EmployeeDto {
    
    
    private String name;
    private String ssn;
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

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getSsn() {
        return ssn;
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
