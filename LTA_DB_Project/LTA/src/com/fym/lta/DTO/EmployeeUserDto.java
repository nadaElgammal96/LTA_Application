package com.fym.lta.DTO;

public class EmployeeUserDto {
    
    
 
    private int user_id;
   
    private EmployeeDto employee;
    
    
    public EmployeeUserDto(){
       super();
       }

  public void setEmployee(EmployeeDto employee)
  {
    this.employee = employee;
  }

  public EmployeeDto getEmployee()
  {
    return employee;
  }

  public void setUser_id(int user_id) {
       this.user_id = user_id;
    }

    public int getUser_id() {
       return user_id;
    }

  
}
