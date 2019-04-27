package com.fym.lta.BAO;

/**
 *
 * @author Nada El-Gammal
 */

import com.fym.lta.DTO.EquipSpecificationDto;

import java.util.List;


public abstract interface EquipSpecificationBao {
    public abstract boolean save(EquipSpecificationDto eq_spec);

    public abstract boolean delete(EquipSpecificationDto eq_spec);
    
    public abstract List<EquipSpecificationDto> searchFor(EquipSpecificationDto eq_spec);
    
    public abstract List<EquipSpecificationDto> listall();
}
