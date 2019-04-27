package com.fym.lta.DTO;

public class StageScheduleDto {
    
    private int schedule_id;
    private int slot_number;
    private int no_of_std;
    private String stage_code;
    private int stage_num;
    
    
    public StageScheduleDto(){
        super();
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }

    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSlot_number(int slot_number) {
        this.slot_number = slot_number;
    }

    public int getSlot_number() {
        return slot_number;
    }

    public void setNo_of_std(int no_of_std) {
        this.no_of_std = no_of_std;
    }

    public int getNo_of_std() {
        return no_of_std;
    }

    public void setStage_code(String stage_code) {
        this.stage_code = stage_code;
    }

    public String getStage_code() {
        return stage_code;
    }

    public void setStage_num(int stage_num) {
        this.stage_num = stage_num;
    }

    public int getStage_num() {
        return stage_num;
    }
}
