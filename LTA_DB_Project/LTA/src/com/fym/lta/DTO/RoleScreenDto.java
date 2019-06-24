package com.fym.lta.DTO;

public class RoleScreenDto {
    
    private boolean view_only;
    private boolean full_access;
    private boolean deny_access;
    private int role_id;
    private int screen_id;
    private String role_name;
    private String screen_name;
    private String search;

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public RoleScreenDto(){
        super();
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getRole_id() {
        return role_id;
    }


    public void setScreen_id(int screen_id) {
        this.screen_id = screen_id;
    }

    public void setView_only(boolean view_only) {
        this.view_only = view_only;
    }

    public boolean isView_only() {
        return view_only;
    }

    public void setFull_access(boolean full_access) {
        this.full_access = full_access;
    }

    public boolean isFull_access() {
        return full_access;
    }

    public void setDeny_access(boolean deny_access) {
        this.deny_access = deny_access;
    }

    public boolean isDeny_access() {
        return deny_access;
    }

    public int getScreen_id() {
        return screen_id;
    }

  public void setSearch(String search)
  {
    this.search = search;
  }

  public String getSearch()
  {
    return search;
  }
}
