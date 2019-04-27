package com.fym.lta.DTO;

public class ScreenDto {
    
    private int id;
    private String descripltion;
    private String name;
    private RoleScreenDto Role;

    public ScreenDto(){
        super();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setDescripltion(String descripltion) {
        this.descripltion = descripltion;
    }

    public String getDescripltion() {
        return descripltion;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
