package com.fym.lta.DTO;

public class SlotDto {
    
    private String code;
    private int course_id;
    private Float end_time;
    private Float start_time;
    private int occupancy;
    private int location_id;
    private int num;
    private String day;
    private ScheduleSlotDto schedule;
    private CourseDto course;
    private LocationDto location;

    public void setCourse(CourseDto course) {
        this.course = course;
    }

    public CourseDto getCourse() {
        return course;
    }

    public void setLocation(LocationDto location) {
        this.location = location;
    }

    public LocationDto getLocation() {
        return location;
    }

    public SlotDto(){
        super();
        }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setEnd_time(Float end_time) {
        this.end_time = end_time;
    }

    public Float getEnd_time() {
        return end_time;
    }

    public void setStart_time(Float start_time) {
        this.start_time = start_time;
    }

    public Float getStart_time() {
        return start_time;
    }

    public void setOccupancy(int occupancy) {
        this.occupancy = occupancy;
    }

    public int getOccupancy() {
        return occupancy;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }
}
