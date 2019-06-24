package com.fym.lta.DTO;

import java.util.List;

public class CourseDto {
    
    private String description;
    private String name;
    private String code;
    private int id;
    private Float no_of_hrs;
    private LocationTypeDto plt_lecture, plt_section;
    private List<DepartmentDto> departs;

  public CourseDto(int id)
  {
    this.id = id;
  }

  public void setDeparts(List<DepartmentDto> departs)
  {
    this.departs = departs;
  }

  public List<DepartmentDto> getDeparts()
  {
    return departs;
  }
  private  CourseDepartDto depart;
    private WorkOnDto staff;
    private String search;


  public void setPlt_lecture(LocationTypeDto plt_lecture)
  {
    this.plt_lecture = plt_lecture;
  }

  public LocationTypeDto getPlt_lecture()
  {
    return plt_lecture;
  }

  public void setPlt_section(LocationTypeDto plt_section)
  {
    this.plt_section = plt_section;
  }

  public LocationTypeDto getPlt_section()
  {
    return plt_section;
  }


  public void setSearch(String search) {
        this.search = search;
    }

    public String getSearch() {
        return search;
    }
    
    public CourseDto(){
        super();
        }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setNo_of_hrs(Float no_of_hrs) {
        this.no_of_hrs = no_of_hrs;
    }

    public Float getNo_of_hrs() {
        return no_of_hrs;
    }


  public CourseDto(String search) {
        this.search = search;
    }
  
}
