package com.fym.lta.BAO;

public class BaoFactory {
    public BuildinBao createBuildingBao() {
        return new BuildingBaoImpl();
    }

    public FloorBao createFloorBao() {
        return new FloorBaoImpl();
    }

    public LocationBao createLocationBao() {
        return new LocationBaoImpl();
    }

    public LocationTypeBao createLocationTypeBao() {
        return new LocationTypeBaoImpl();
    }

    public EquipmentBao createEquipmnetBao() {
        return new EquipmentBaoImpl();
    }

    public EquipmentTypeBao createEquipmentTypeBao() {
        return new EquipmentTypeBaoImpl();
    }

    public EquipSpecificationBao createEquipmentSpecificationBao() {
        return new EquipSpecificationBaoImpl();
    }

    public DepartmentBao createDepartmentBao() {
        return new DepartmentBaoImpl();

    }

    public CourseBao createCourseBao() {
        return new CourseBaoImpl();
    }

    public SlotBao createSLotBao() {
        return new SlotBaoImpl();
    }

    public ScheduleBao createScheduleBao() {
        return new ScheduleBaoImpl();
    }

    public StageBao createStageBao() {
        return new StageBaoImpl();
    }

    public StafffBao createStuffBao() {
        return new StaffBaoImpl();
    }

    public UserBao createUserBao() {
        return new UserBaoImpl();
    }

    public RoleBao createRoleBao() {
        return new RoleBaoImpl();
    }

    public ScreenBao createScreenBao() {
        return new ScreenBaoImpl();
    }

    public FacultyBao createFacultyBao() {
        return new FacultyBaoImpl();
    }
    
    public EmployeeBao createEmployeeBao() {
        return new EmployeeBaoImpl();
    }
}
