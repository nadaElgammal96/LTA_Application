package com.fym.lta.BAO;
/**
 *
 * @author Nada El-Gammal
 */
import com.fym.lta.DTO.EquipSpecificationDto;
import com.fym.lta.DTO.EquipTypeSpecDetailsDto;

import com.fym.lta.DTO.EquipmentTypeDto;

import java.util.List;

public interface EqTypeSpecBao {
    public abstract boolean add(EquipTypeSpecDetailsDto type_spec);
    
    public abstract boolean delete(EquipTypeSpecDetailsDto type_spec);
    
    public abstract List<EquipTypeSpecDetailsDto> viewAll();
    
    public abstract List<EquipSpecificationDto> viewAllSpecif(EquipmentTypeDto type);

}
