package com.fym.lta.DTO;

import java.util.List;

public class FloorDto {
    
    
    private int id;
    private BuildingDto build;
    private String code;
    private String description;
    private int location_number;

  public void setLocation_number(int location_number)
  {
    this.location_number = location_number;
  }

  public int getLocation_number()
  {
    return location_number;
  }

  public void setBuild(BuildingDto build) {
        this.build = build;
    }

    public BuildingDto getBuild() {
        return build;
    }

    private String search;
    private List<LocationDto> Locations;

    public void setSearch(String search) {
        this.search = search;
    }

    public String getSearch() {
        return search;
    }

 //   public FloorDto(String search) {
  //      this.search = search;
  //  }

    public FloorDto(String code) {
        this.code = code;
    }
    
    
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
