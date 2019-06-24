package com.fym.lta.DTO;

import java.util.List;

public class BuildingDto {
    
    
    private int id;
    private int floorsNo;
    private String code;
    private String description;
    private List<FloorDto> Floors;
    private DepartBuildingDto departments;
    private String search;


  public void setFloorsNo(int floorsNo)
  {
    this.floorsNo = floorsNo;
  }

  public int getFloorsNo()
  {
    return floorsNo;
  }

  /**
   * @param search
   */
    public BuildingDto(String search) {
        this.search = search;
    }

    public BuildingDto(int id) {
        this.id = id;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getSearch() {
        return search;
    }

    public void setFloors(List<FloorDto> Floors) {
        this.Floors = Floors;
    }

    public List<FloorDto> getFloors() {
        return Floors;
    }

    public String getDescription() {
        return description;
    }

    public String getCode() {
        return code;
    }

    public void setDescription(String description) {
        this.description=description;
    }

    public void setId(int id) {
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setCode(String code) {
       this.code = code;
    }
    public BuildingDto(){
        super();
        }
}
