package com.fym.lta.DTO;

import java.util.List;

public class EquipTypeSpecDetailsDto {
    
    private int type_id;

    private int specification_id;


    public EquipTypeSpecDetailsDto(int type_id, int specification_id) {
        this.type_id = type_id;
        this.specification_id = specification_id;
    }

    public EquipTypeSpecDetailsDto(){
        super();
        }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setSpecification_id(int specification_id) {
        this.specification_id = specification_id;
    }

    public int getSpecification_id() {
        return specification_id;
    }
}
