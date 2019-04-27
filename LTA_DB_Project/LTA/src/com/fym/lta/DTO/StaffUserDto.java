package com.fym.lta.DTO;

public class StaffUserDto {
    
    
    private String stuff_ssn;
    private int user_id;
    
    
    public StaffUserDto(){
        super();
    }

    public void setStuff_ssn(String stuff_ssn) {
        this.stuff_ssn = stuff_ssn;
    }

    public String getStuff_ssn() {
        return stuff_ssn;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }
}
