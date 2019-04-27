package com.fym.lta.DTO;

public class ScheduleDto {
    
    private int id;
    private int slot_num;
    private ScheduleSlotDto slots;
    private StageScheduleDto stage;
    
    
    public ScheduleDto(){
        super();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setSlot_num(int slot_num) {
        this.slot_num = slot_num;
    }

    public int getSlot_num() {
        return slot_num;
    }
}
