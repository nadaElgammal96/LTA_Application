package com.fym.lta.DTO;

import java.util.List;

public class LocationDto {
    
    private String code;
    private int id;
    private int locationType_id;
    private int capacity;
    private String floor_code;
    private String name;
    private List<EquipmentDto> Equipments;
    private LocationTypeDto type;

    public void setEquipments(List<EquipmentDto> Equipments) {
        this.Equipments = Equipments;
    }

    public List<EquipmentDto> getEquipments() {
        return Equipments;
    }

    public void setType(LocationTypeDto type) {
        this.type = type;
    }

    public LocationTypeDto getType() {
        return type;
    }

    public LocationDto(){
        super();
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setLocationType_id(int locationType_id) {
        this.locationType_id = locationType_id;
    }

    public int getLocationType_id() {
        return locationType_id;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setFloor_code(String floor_code) {
        this.floor_code = floor_code;
    }

    public String getFloor_code() {
        return floor_code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
