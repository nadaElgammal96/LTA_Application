package com.fym.lta.DAO;


import com.fym.lta.DTO.RoleDto;

import java.util.List;

public abstract interface RoleDao {
    
    public abstract Boolean update(RoleDto r);

    public abstract Boolean createNew(RoleDto r);

    public abstract Boolean isExist(RoleDto r);

    public abstract List<RoleDto> viewAll();

    public abstract List<RoleDto> searchFor(RoleDto role);

    public abstract Boolean delete(RoleDto r);
}
