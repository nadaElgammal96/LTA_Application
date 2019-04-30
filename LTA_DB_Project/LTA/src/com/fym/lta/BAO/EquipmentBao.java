package com.fym.lta.BAO;

/**
 *
 * @author Nada El-Gammal
 */

import com.fym.lta.DTO.EquipmentDto;
import com.fym.lta.DTO.EquipmentTypeDto;
import com.fym.lta.DTO.LocationDto;

import java.util.List;

public abstract interface EquipmentBao {
       public abstract boolean insert(EquipmentDto equip);
       
       public abstract boolean update(EquipmentDto equip);

       public abstract boolean delete(EquipmentDto equip);
       
       public abstract List<EquipmentDto> searchFor(EquipmentDto equip);
       
       public abstract List<EquipmentDto> listAll();
       
       public abstract boolean countEquips(EquipmentTypeDto et);

       //public abstract LocationDto searchForLocationOfEquip(String code);
}
