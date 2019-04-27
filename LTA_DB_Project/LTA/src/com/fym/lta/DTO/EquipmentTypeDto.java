package com.fym.lta.DTO;
/**
 *
 * @author Nada El-Gammal
 */
public class EquipmentTypeDto {
    
    private String code;
    private int no_of_equip;
    private String name;
    private int id;
    private String search;
    private EquipTypeSpecDetailsDto Specifications;
    
    public EquipmentTypeDto(){
        super();
        }

    public EquipmentTypeDto(String code, int no_of_equip, String name, int id, String search,
                            EquipTypeSpecDetailsDto Specifications) {
        this.code = code;
        this.no_of_equip = no_of_equip;
        this.name = name;
        this.id = id;
        this.search = search;
        this.Specifications = Specifications;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setNo_of_equip(int no_of_equip) {
        this.no_of_equip = no_of_equip;
    }

    public int getNo_of_equip() {
        return no_of_equip;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getSearch() {
        return search;
    }

    public void setSpecifications(EquipTypeSpecDetailsDto Specifications) {
        this.Specifications = Specifications;
    }

    public EquipTypeSpecDetailsDto getSpecifications() {
        return Specifications;
    }

    public EquipmentTypeDto(String search) {
        this.search = search;
    }

    public EquipmentTypeDto(String code, int no_of_equip, String name, int id) {
        this.code = code;
        this.no_of_equip = no_of_equip;
        this.name = name;
        this.id = id;
    }

    public EquipmentTypeDto(int id) {
        this.id = id;
    }
}
