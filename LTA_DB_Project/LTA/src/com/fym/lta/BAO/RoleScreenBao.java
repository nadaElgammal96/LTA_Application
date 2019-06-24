package com.fym.lta.BAO;



import com.fym.lta.DTO.RoleScreenDto;

import java.util.List;

public interface RoleScreenBao {
    public abstract boolean update(RoleScreenDto rs);

    public abstract boolean add(RoleScreenDto rs);

    public abstract List<RoleScreenDto> viewAll();
    
    public abstract List<RoleScreenDto> searchFor(RoleScreenDto rs);

    public abstract boolean delete(RoleScreenDto rs);
}
