package com.fym.lta.DAO;

import com.fym.lta.DTO.RoleScreenDto;

import java.util.List;

public abstract interface RoleScreenDao {
    public abstract boolean isExist(RoleScreenDto rs);

    public abstract boolean createNew(RoleScreenDto rs);

    public abstract boolean delete(RoleScreenDto rs);

    public abstract RoleScreenDto searchFor(int id);

    public abstract boolean update(RoleScreenDto rs);

    public abstract List<RoleScreenDto> viewAll();
}
