package com.fym.lta.DTO;

public class ScheduleDto {
    
    private int id;
    private int slot_num;
    private ScheduleSlotDto slots;
    private StageDto stage;
    private int term ;
    private String search;
    private String file_path;

  public void setFile_path(String file_path)
  {
    this.file_path = file_path;
  }

  public String getFile_path()
  {
    return file_path;
  }
  private DepartmentDto department;
    private LocationTypeDto default_location_type;

  public void setDefault_location_type(LocationTypeDto default_location_type)
  {
    this.default_location_type = default_location_type;
  }

  public LocationTypeDto getDefault_location_type()
  {
    return default_location_type;
  }

  public void setSlots(ScheduleSlotDto slots)
  {
    this.slots = slots;
  }

  public ScheduleSlotDto getSlots()
  {
    return slots;
  }

  public void setStage(StageDto stage)
  {
    this.stage = stage;
  }

  public StageDto getStage()
  {
    return stage;
  }

  public void setDepartment(DepartmentDto department)
  {
    this.department = department;
  }

  public DepartmentDto getDepartment()
  {
    return department;
  }


  public ScheduleDto(){
        super();
    }


    public void setSearch(String search) {
        this.search = search;
    }

    public String getSearch() {
        return search;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getTerm() {
        return term;
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
