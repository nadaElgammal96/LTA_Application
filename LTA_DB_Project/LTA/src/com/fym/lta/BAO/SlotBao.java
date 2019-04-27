package com.fym.lta.BAO;

import com.fym.lta.DTO.DepartmentDto;
import com.fym.lta.DTO.SlotDto;

public abstract interface SlotBao {
    public abstract boolean delete(SlotDto s);

    public abstract boolean add(SlotDto s);

    public abstract SlotDto searchFor(SlotDto s);

    public abstract void viewAll();

    public abstract boolean update(SlotDto s);

    public abstract void viewAvailableLocations(DepartmentDto d);

    public abstract void viewAllAvailableLocations();
}
