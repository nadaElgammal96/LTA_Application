package com.fym.lta.BAO;

import com.fym.lta.DTO.StageScheduleDto;

public interface StageScheduleBao {
    
    public abstract boolean isExist(StageScheduleDto ss);
    public abstract boolean add(StageScheduleDto ss);
    public abstract boolean delete(StageScheduleDto ss);

}
