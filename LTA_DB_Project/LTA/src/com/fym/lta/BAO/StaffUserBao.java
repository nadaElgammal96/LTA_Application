package com.fym.lta.BAO;

import com.fym.lta.DTO.EmployeeDto;
import com.fym.lta.DTO.StaffDto;
import com.fym.lta.DTO.StaffUserDto;

public interface StaffUserBao {
    
    public abstract boolean insert (StaffUserDto staff_acc);
    
    public abstract boolean delete (StaffUserDto staff_acc);
        
    public abstract boolean update (StaffUserDto staff_acc);

  /**Check if staff user account existing in database or not
   * @param take StaffUserDto object
   * @return true if exist, false if not*/
  public abstract Boolean staffIsExist(StaffDto staff);

  //////////////////////Nada El-Gammal ---- recently added
  public abstract boolean isExist(StaffUserDto staff_acc);

  //////////////////////Nada El-Gammal ----recently added
  public abstract int getStaffId(StaffUserDto staff_acc);


}
