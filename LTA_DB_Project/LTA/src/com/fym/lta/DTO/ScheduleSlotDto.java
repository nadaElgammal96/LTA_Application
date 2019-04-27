package com.fym.lta.DTO;

import java.util.List;

public class ScheduleSlotDto {
    
    private String slot_code;
    private int schedule_id;
   
    
    public ScheduleSlotDto(){
        super();
    }

    public void setSlot_code(String slot_code) {
        this.slot_code = slot_code;
    }

    public String getSlot_code() {
        return slot_code;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }

    public int getSchedule_id() {
        return schedule_id;
    }

}
