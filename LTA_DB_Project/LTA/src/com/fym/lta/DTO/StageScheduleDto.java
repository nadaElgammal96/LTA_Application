package com.fym.lta.DTO;

public class StageScheduleDto {
    
    private int schedule_id;
    private String stage_code;
    
    
    public StageScheduleDto(){
        super();
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }

    public int getSchedule_id() {
        return schedule_id;
    }

    public void setStage_code(String stage_code) {
        this.stage_code = stage_code;
    }

    public String getStage_code() {
        return stage_code;
    }

}
