package com.fym.lta.DAO;

import com.fym.lta.DTO.UserDto;

import java.util.List;

public abstract interface UserDao {
    public abstract Boolean createNew(UserDto u);

    public abstract Boolean delete(UserDto u);

    public abstract Boolean isExist(UserDto u);

    public abstract UserDto searchFor(String username);

    public abstract List<UserDto> viewAll();

    public abstract Boolean update(UserDto u);
}
