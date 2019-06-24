package com.fym.lta.DTO;

public class StageDto {
    
    private String code;
    private int num_of_std;
    private String number;
    private StageScheduleDto schedule;
    private DepartmentDto department;
    private String search;
   
    
    public StageDto(){
       super();
       }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getSearch() {
        return search;
    }

    public void setDepartment(DepartmentDto department) {
        this.department = department;
    }

    public DepartmentDto getDepartment() {
        return department;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setNum_of_std(int num_of_std) {
        this.num_of_std = num_of_std;
    }

    public int getNum_of_std() {
        return num_of_std;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
