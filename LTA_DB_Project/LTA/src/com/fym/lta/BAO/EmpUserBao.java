package com.fym.lta.BAO;

import com.fym.lta.DTO.EmployeeDto;
import com.fym.lta.DTO.EmployeeUserDto;
import com.fym.lta.DTO.StaffUserDto;
import com.fym.lta.DTO.UserDto;

public interface EmpUserBao {
    public abstract boolean insert (EmployeeUserDto emp_acc);
    
    public abstract boolean delete (EmployeeUserDto emp_acc);
        
    public abstract boolean update (EmployeeUserDto emp_acc);

  /**Check if employee user account existing in database or not
   * @param take EmployeeUserDto object
   * @return true if exist, false if not*/
  public abstract Boolean employeeIsExist(EmployeeDto u);
  
  
}
