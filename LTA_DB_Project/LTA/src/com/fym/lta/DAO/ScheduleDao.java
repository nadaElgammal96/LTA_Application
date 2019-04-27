package com.fym.lta.DAO;

import com.fym.lta.DTO.ScheduleDto;

import java.util.List;

public abstract interface ScheduleDao {
    public abstract Boolean createNew(ScheduleDto sch);

    public abstract Boolean isExist(ScheduleDto sch);

    public abstract List<ScheduleDto> viewAll();

    public abstract Boolean delete(ScheduleDto sch);

    public abstract Boolean update(ScheduleDto sch);

    public abstract ScheduleDto searchFor(int id);
}
