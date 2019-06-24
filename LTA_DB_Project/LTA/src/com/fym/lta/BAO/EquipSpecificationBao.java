package com.fym.lta.BAO;

/**
 *
 * @author Nada El-Gammal
 */

import com.fym.lta.DTO.EquipSpecificationDto;

import com.fym.lta.DTO.UserDto;

import java.util.List;


public abstract interface EquipSpecificationBao {
    public abstract boolean insert(EquipSpecificationDto eq_spec , UserDto user);
    
    public abstract boolean update(EquipSpecificationDto eq_spec , UserDto user);

    public abstract boolean delete(EquipSpecificationDto eq_spec);
    
    public abstract List<EquipSpecificationDto> searchFor(EquipSpecificationDto eq_spec);
    
    public abstract List<EquipSpecificationDto> listAll();
}
