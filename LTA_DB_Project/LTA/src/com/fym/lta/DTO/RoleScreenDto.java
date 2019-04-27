package com.fym.lta.DTO;

public class RoleScreenDto {
    
    private boolean view;
    private int role_id;
    private boolean edit;
    private boolean delete;
    private boolean add;
    private int screen_id;
    
    
    public RoleScreenDto(){
        super();
    }

    public void setView(boolean view) {
        this.view = view;
    }

    public boolean isView() {
        return view;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setAdd(boolean add) {
        this.add = add;
    }

    public boolean isAdd() {
        return add;
    }

    public void setScreen_id(int screen_id) {
        this.screen_id = screen_id;
    }

    public int getScreen_id() {
        return screen_id;
    }
}
