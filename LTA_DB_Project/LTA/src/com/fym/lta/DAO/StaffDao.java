package com.fym.lta.DAO;

import com.fym.lta.DTO.StaffDto;

import java.util.List;

public abstract interface StaffDao {
    public abstract Boolean isExist(StaffDto s);

    public abstract Boolean createNew(StaffDto s);

    public abstract Boolean delete(StaffDto s);

    public abstract Boolean update(StaffDto s);

    public abstract List<StaffDto> searchFor(StaffDto s1);

    public abstract List<StaffDto> viewAll();
}
