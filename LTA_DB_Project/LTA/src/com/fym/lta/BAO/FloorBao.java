package com.fym.lta.BAO;

import com.fym.lta.DTO.FloorDto;

public abstract interface FloorBao {
    public abstract void ListAll();

    public abstract void ListEmptyLocations(FloorDto floor);

    public abstract boolean udate(String code);

    public abstract Boolean save(FloorDto floor);

    public abstract Boolean delete(FloorDto floor);

    public abstract void searchForDep(String code);

    public abstract void ListAllLocations(FloorDto floor);
}
