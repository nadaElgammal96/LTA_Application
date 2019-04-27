package com.fym.lta.DAO;

import com.fym.lta.DTO.ScheduleSlotDto;
import java.util.List;

public abstract interface ScheduleSlotDao {
    public abstract Boolean update(ScheduleSlotDto ss);

    public abstract List<ScheduleSlotDto> viewAll();

    public abstract Boolean isExist(ScheduleSlotDto ss);

    public abstract Boolean createNew(ScheduleSlotDto ss);

    public abstract Boolean delete(ScheduleSlotDto ss);

    public abstract ScheduleSlotDto searchFor(int id);
}
