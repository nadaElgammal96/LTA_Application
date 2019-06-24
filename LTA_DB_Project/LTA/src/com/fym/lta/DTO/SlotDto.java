package com.fym.lta.DTO;

import java.util.List;

public class SlotDto {
    
    private String code;    
    private String end_time;   
    private String start_time;    

    private int num;              
    private String day;           
    private ScheduleSlotDto schedule;              

    private CourseDto course;   //schedule input     
    private List<StaffDto> staff;    //schedule input            
    private LocationTypeDto plt;  //schedule input             
    private int student_number;  //schedule input               
    private String slot_type;    //schedule input               
    
    private LocationDto location; //schedule output

    private String search;
    private List<UserDto> users;
    private int term;

  public void setTerm(int term)
  {
    this.term = term;
  }

  public int getTerm()
  {
    return term;
  }

  public void setUser(List<UserDto> user)
  {
    this.users = user;
  }

  public List<UserDto> getUser()
  {
    return users;
  }

  public void setSearch(String search)
  {
    this.search = search;
  }

  public String getSearch()
  {
    return search;
  }


  public void setSchedule(ScheduleSlotDto schedule)
  {
    this.schedule = schedule;
  }

  public ScheduleSlotDto getSchedule()
  {
    return schedule;
  }

  public void setStaff(List<StaffDto> staff)
  {
    this.staff = staff;
  }

  public List<StaffDto> getStaff()
  {
    return staff;
  }


  public void setPlt(LocationTypeDto plt)
  {
    this.plt = plt;
  }

  public LocationTypeDto getPlt()
  {
    return plt;
  }

  public void setStudent_number(int student_number)
  {
    this.student_number = student_number;
  }

  public int getStudent_number()
  {
    return student_number;
  }

  public void setSlot_type(String slot_type)
  {
    this.slot_type = slot_type;
  }

  public String getSlot_type()
  {
    return slot_type;
  }


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

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getStart_time() {
        return start_time;
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
