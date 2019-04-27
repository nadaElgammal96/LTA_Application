package com.fym.lta.DAO;

import com.fym.lta.DTO.StageDto;

import java.util.List;

public abstract interface StageDao {
    public abstract Boolean createNew(StageDto st);

    public abstract Boolean isExist(StageDto st);

    public abstract StageDto searchFor(String code);

    public abstract Boolean delete(StageDto st);

    public abstract List<StageDto> viewAll();

    public abstract Boolean update(StageDto st);
}
