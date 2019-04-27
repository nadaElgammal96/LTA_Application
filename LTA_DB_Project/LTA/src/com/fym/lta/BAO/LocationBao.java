package com.fym.lta.BAO;

import com.fym.lta.DTO.LocationDto;
import com.fym.lta.DTO.SlotDto;

public abstract interface LocationBao {
    public abstract void viewAllEquipments();

    public abstract boolean isAvailable(SlotDto slot);

    public abstract boolean delete(LocationDto l);

    public abstract void searchFor(String code);

    public abstract boolean save(LocationDto l);
}
