package com.fym.lta.BAO;

import com.fym.lta.DTO.UserDto;

public abstract interface UserBao {
    public abstract void viewAll();

    public abstract boolean update(String username);

    public abstract boolean add(UserDto u);

    public abstract boolean delete(UserDto u);

    public abstract UserDto searchFor(String username);
}
