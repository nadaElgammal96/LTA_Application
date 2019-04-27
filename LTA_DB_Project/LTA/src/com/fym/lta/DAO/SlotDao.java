package com.fym.lta.DAO;

import com.fym.lta.DTO.SlotDto;

import java.util.List;

public abstract interface SlotDao {
    public abstract List<SlotDto> viewAll();

    public abstract Boolean createNew(SlotDto s);

    public abstract Boolean isExist(SlotDto s);

    public abstract Boolean delete(SlotDto s);

    public abstract Boolean update(SlotDto s);

    public abstract SlotDto searchFor(String code);
}
