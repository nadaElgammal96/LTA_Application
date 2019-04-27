package com.fym.lta.BAO;

import com.fym.lta.DTO.RoleDto;
import com.fym.lta.DTO.ScreenDto;

public abstract interface ScreenBao {
    public abstract void viewAll();

    public abstract boolean delete(ScreenDto s);

    public abstract boolean update(int id);

    public abstract boolean add(ScreenDto s);

    public abstract RoleDto searchFor(int id);
}
