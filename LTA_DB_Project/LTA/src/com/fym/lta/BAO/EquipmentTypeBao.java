package com.fym.lta.BAO;

/**
 *
 * @author Nada El-Gammal
 */

import com.fym.lta.DTO.EquipmentDto;
import com.fym.lta.DTO.EquipmentTypeDto;
import java.util.List;

public abstract interface EquipmentTypeBao {
    
    public abstract boolean add(EquipmentTypeDto equip_type);

    public abstract boolean update(EquipmentTypeDto equip_type);
    
    public abstract List<EquipmentTypeDto> viewAll();

    public abstract boolean delete(EquipmentTypeDto equip_type);
    
    public abstract List<EquipmentTypeDto> searchFor(EquipmentTypeDto equip_type);
    
    public abstract List<EquipmentDto> loadAllEquips(EquipmentTypeDto equip_type);
    
}
