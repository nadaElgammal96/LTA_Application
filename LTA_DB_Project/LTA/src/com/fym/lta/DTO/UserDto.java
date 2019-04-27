package com.fym.lta.DTO;

public class UserDto {

    private int id;
    private String usernsme;
    private int role_id;
    private String password;
    private String email;
    private RoleDto user_role;
    private EmployeeUserDto emplACC;
    private StaffUserDto staffAcc;
    
    public UserDto(){
        super();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setUsernsme(String usernsme) {
        this.usernsme = usernsme;
    }

    public String getUsernsme() {
        return usernsme;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
