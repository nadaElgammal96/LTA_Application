package com.fym.lta.DAO;

/**
 *
 * @author Nada El-Gammal
 */

import com.fym.lta.DTO.EquipmentDto;
import com.fym.lta.DTO.EquipmentTypeDto;

import java.util.List;

public abstract interface EquipmentTypeDao {
    public abstract List<EquipmentTypeDto> searchFor(EquipmentTypeDto et);

    public abstract List<EquipmentTypeDto> viewAll();

    public abstract Boolean createNew(EquipmentTypeDto et);

    public abstract Boolean isExist(EquipmentTypeDto et);

    public abstract Boolean update(EquipmentTypeDto et);

    public abstract Boolean delete(EquipmentTypeDto et);
    
    public abstract List<EquipmentDto> loadAllEquipments(EquipmentTypeDto et);
}
