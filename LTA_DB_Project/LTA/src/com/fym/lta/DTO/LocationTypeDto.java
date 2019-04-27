package com.fym.lta.DTO;


/**
 *
 * @author Mai-AbdEltwab
 */

public class LocationTypeDto {
    
    private String code;
    private String color;
    private int num_of_locations;
    private String description;
    private int id;
    private String search;

    public void setSearch(String search) {
        this.search = search;
    }

    public String getSearch() {
        return search;
    }

    public LocationTypeDto(){
        super();
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNum_of_locations(int num_of_locations) {
        this.num_of_locations = num_of_locations;
    }

    public int getNum_of_locations() {
        return num_of_locations;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
