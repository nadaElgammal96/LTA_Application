package com.fym.lta.DAO;

import com.fym.lta.DTO.LocationDto;

import java.util.List;

public abstract interface LocationDao {
    public abstract Boolean delete(LocationDto l);

    public abstract Boolean createNew(LocationDto l);

    public abstract LocationDto searchFor(String c);

    public abstract Boolean update(LocationDto l);

    public abstract Boolean isExist(LocationDto l);

    public abstract List<LocationDto> viewAll();
}
