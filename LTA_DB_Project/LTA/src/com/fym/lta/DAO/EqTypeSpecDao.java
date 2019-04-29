package com.fym.lta.DAO;

/**
 *
 * @author Nada El-Gammal
 */

import com.fym.lta.DTO.EquipSpecificationDto;
import com.fym.lta.DTO.EquipTypeSpecDetailsDto;

import com.fym.lta.DTO.EquipmentTypeDto;

import java.util.List;

public interface EqTypeSpecDao {
    
    public abstract boolean insert (EquipTypeSpecDetailsDto type_spec);
    
    public abstract boolean delete (EquipTypeSpecDetailsDto type_spec);
    
    public abstract boolean isExist (EquipTypeSpecDetailsDto type_spec);
    
    public abstract List<EquipTypeSpecDetailsDto> listAll();
    
    public abstract List<EquipSpecificationDto> loadAllSpecif(EquipmentTypeDto type);
    
}
