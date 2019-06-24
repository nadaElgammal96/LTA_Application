package com.fym.lta.DTO;

public class StaffUserDto {
    
    
  
    private int user_id;
    private StaffDto staff;

  public void setStaff(StaffDto staff)
  {
    this.staff = staff;
  }

  public StaffDto getStaff()
  {
    return staff;
  }


  public StaffUserDto(){
        super();
    }

  

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }
}
