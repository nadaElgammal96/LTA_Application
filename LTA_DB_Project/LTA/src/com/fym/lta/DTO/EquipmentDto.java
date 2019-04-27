package com.fym.lta.DTO;
/**
 *
 * @author Nada El-Gammal
 */


import java.util.List;

public class EquipmentDto {
    
    
    private int id;
    private String code;
    private String country;
    private EquipmentTypeDto type;
    private String search;

    public EquipmentDto(){
    super();
    }

    public EquipmentDto(String search) {
        this.search = search;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setType(EquipmentTypeDto type) {
        this.type = type;
    }

    public EquipmentTypeDto getType() {
        return type;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getSearch() {
        return search;
    }
}
