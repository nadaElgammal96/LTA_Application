package com.fym.lta.DTO;
/**
 *
 * @author Nada El-Gammal
 */
public class EquipSpecificationDto {
    
    private String name;
    private String value;
    private int id;
    private EquipTypeSpecDetailsDto type;
    private String search;
    
    public EquipSpecificationDto(){
        super();
        }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setType(EquipTypeSpecDetailsDto type) {
        this.type = type;
    }

    public EquipTypeSpecDetailsDto getType() {
        return type;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getSearch() {
        return search;
    }

    public EquipSpecificationDto(String search) {
        this.search = search;
    }

    public EquipSpecificationDto(String name, String value, int id) {
        this.name = name;
        this.value = value;
        this.id = id;
    }
}
