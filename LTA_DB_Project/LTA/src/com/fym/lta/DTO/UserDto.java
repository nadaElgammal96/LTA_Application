package com.fym.lta.DTO;


public class UserDto {

    private int id;
    private String username;
    private RoleDto role;
    private String password;
    private String email;
    private String search;
    private int keep_login;
    private StaffDto staffAcc;
    private String screen_name;
    private int screen_id;

  public void setScreen_name(String screen_name)
  {
    this.screen_name = screen_name;
  }

  public String getScreen_name()
  {
    return screen_name;
  }

  public void setScreen_id(int Screen_id)
  {
    this.screen_id = Screen_id;
  }

  public int getScreen_id()
  {
    return screen_id;
  }

  public void setStaffAcc(StaffDto staffAcc)
  {
    this.staffAcc = staffAcc;
  }

  public StaffDto getStaffAcc()
  {
    return staffAcc;
  }

  public void setEmployeeAcc(EmployeeDto employeeAcc)
  {
    this.employeeAcc = employeeAcc;
  }

  public EmployeeDto getEmployeeAcc()
  {
    return employeeAcc;
  }
  private EmployeeDto employeeAcc;

 


  public void setKeep_login(int keep_login)
  {
    this.keep_login = keep_login;
  }

  public int getKeep_login()
  {
    return keep_login;
  }
 
    
    public UserDto(){
        super();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }


  public void setRole(RoleDto role)
  {
    this.role = role;
  }

  public RoleDto getRole()
  {
    return role;
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
    public void setSearch(String search) {
        this.search = search;
    }

    public String getSearch() {
        return search;
    }

    public UserDto(String search) {
        this.search = search;
    }
}
