package com.fym.lta.DTO;

public class EmployeeUserDto {
    
    
 
    private int user_id;

    private String employee_ssn;
    
    public EmployeeUserDto(){
       super();
       }

    public void setUser_id(int user_id) {
       this.user_id = user_id;
    }

    public int getUser_id() {
       return user_id;
    }

    public void setEmployee_ssn(String employee_ssn) {
       this.employee_ssn = employee_ssn;
    }

    public String getEmployee_ssn() {
       return employee_ssn;
    }
}
