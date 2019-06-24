package com.fym.lta.BAO;

import com.fym.lta.DTO.BuildingDto;
import com.fym.lta.DTO.RoleDto;

import com.fym.lta.DTO.UserDto;

import java.util.List;

public abstract interface RoleBao {
    public abstract boolean delete(RoleDto r);
    
     public abstract List <RoleDto> searchFor(RoleDto role);
    
    public abstract List<RoleDto> listAll();

    public abstract boolean add(RoleDto r , UserDto user);
    public abstract boolean update(RoleDto role , UserDto user);

}