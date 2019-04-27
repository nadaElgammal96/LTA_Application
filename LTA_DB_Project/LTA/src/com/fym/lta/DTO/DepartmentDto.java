package com.fym.lta.DTO;

import java.util.List;

public class DepartmentDto {
    
    private String code;
    private String name;
    private int id;
    private String search;
    private List<BuildingDto> buildings;


    public void setFaculty(FacultyDto faculty) {
        this.faculty = faculty;
    }

    public FacultyDto getFaculty() {
        return faculty;
    }

    public void setBuilding(DepartBuildingDto building) {
        this.building = building;
    }

    public DepartBuildingDto getBuilding() {
        return building;
    }

    public void setDepart_staff(List<StaffDto> depart_staff) {
        this.depart_staff = depart_staff;
    }

    public List<StaffDto> getDepart_staff() {
        return depart_staff;
    }

    public void setStages(List<StageDto> Stages) {
        this.Stages = Stages;
    }

    public List<StageDto> getStages() {
        return Stages;
    }

    public void setCourses(CourseDepartDto courses) {
        this.courses = courses;
    }

    public CourseDepartDto getCourses() {
        return courses;
    }

    private FacultyDto faculty;
    private DepartBuildingDto building;
    private List<StaffDto> depart_staff;
    private List<StageDto> Stages;
    private CourseDepartDto courses;

    public DepartmentDto(){
        super();
        }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public DepartmentDto(String code, String name, int id) {
        this.code = code;
        this.name = name;
        this.id = id;
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

    public void setSearch(String search) {
        this.search = search;
    }

    public String getSearch() {
        return search;
    }


    public void setBuildings(List<BuildingDto> buildings) {
        this.buildings = buildings;
    }

    public List<BuildingDto> getBuildings() {
        return buildings;
    }
}
