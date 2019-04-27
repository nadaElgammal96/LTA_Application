package com.fym.lta.DTO;

public class DepartBuildingDto {
   
    private int building_id;
    private int department_id;
    
    public DepartBuildingDto(){
        super();
        }

    public void setBuilding_id(int building_id) {
        this.building_id = building_id;
    }

    public int getBuilding_id() {
        return building_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getDepartment_id() {
        return department_id;
    }
}
