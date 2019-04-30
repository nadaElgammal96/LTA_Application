package com.fym.lta.DAO;

/**
 *
 * @author Nada El-Gammal
 */


import com.fym.lta.DTO.EquipmentDto;

import com.fym.lta.DTO.EquipmentTypeDto;

import java.util.List;

public abstract interface EquipmentDao {
 
     public abstract Boolean update(EquipmentDto eq);

     public abstract List<EquipmentDto> searchFor(EquipmentDto eq);

     public abstract Boolean delete(EquipmentDto eq);

     public abstract List<EquipmentDto> viewAll();

     public abstract Boolean createNew(EquipmentDto eq);

     public abstract Boolean isExist(EquipmentDto eq);

     public abstract boolean countEquipments(EquipmentTypeDto et);

}
