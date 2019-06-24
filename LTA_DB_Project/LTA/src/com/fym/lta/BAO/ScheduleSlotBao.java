package com.fym.lta.BAO;

import com.fym.lta.DTO.ScheduleSlotDto;


public interface ScheduleSlotBao {
    
    public abstract boolean insert (ScheduleSlotDto ss);
    
    public abstract boolean delete (ScheduleSlotDto ss);
        
    public abstract boolean update (ScheduleSlotDto ssc);
}
