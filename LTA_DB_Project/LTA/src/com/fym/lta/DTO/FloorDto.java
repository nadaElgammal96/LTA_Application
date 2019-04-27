package com.fym.lta.DTO;

import java.util.List;

public class FloorDto {
    
    
    private int id;
    private String building_code;
    private String code;
    private String description;
    private List<LocationDto> Locations;


    public void setLocations(List<LocationDto> Locations) {
        this.Locations = Locations;
    }

    public List<LocationDto> getLocations() {
        return Locations;
    }

    public FloorDto(){
        super();
        
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setBuilding_code(String building_code) {
        this.building_code = building_code;
    }

    public String getBuilding_code() {
        return building_code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
