package com.fym.lta.DTO;

import java.util.List;

public class LocationDto {
    
    private String code;
    private int id;
    private int capacity;
    private FloorDto floor;
    private String name;
    private List<EquipmentDto> Equipments;
    private LocationTypeDto type;
    private BuildingDto build;
    private String search;
    private int freeSlots;
    private int reserved_number;

  public void setReserved_number(int reserved_number)
  {
    this.reserved_number = reserved_number;
  }

  public int getReserved_number()
  {
    return reserved_number;
  }

  public void setFreeSlots(int freeSlots)
  {
    this.freeSlots = freeSlots;
  }

  public int getFreeSlots()
  {
    return freeSlots;
  }


  public LocationDto(String name) {
        this.name = name;
    }

    public LocationDto(int id) {
        this.id = id;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getSearch() {
        return search;
    }

    public void setBuild(BuildingDto build) {
        this.build = build;
    }

    public BuildingDto getBuild() {
        return build;
    }

    public void setFloor(FloorDto floor) {
        this.floor = floor;
    }

    public FloorDto getFloor() {
        return floor;
    }

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

  

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
