package com.fym.lta.DAO;

public class DaoFactory {
    public EmployeeDao createEmployeeDao() {
        return new EmployeeDaoImpl();
    }

    public UserDao createUserDao() {
        return new UserDaoImpl();
    }

    public LocationDao createLocationDao() {
        return new LocationDaoImpl();
    }

    public LocationTypeDao createLocationTypeDao() {
     return new LocationTypeDaoImpl();
     }

    public StaffDao createStuffDao() {
        return new StaffDaoImpl();
    }

    public RoleDao createRoleDao() {
        return new RoleDaoImpl();
    }

    public ScreenDao createScreenDao() {
        return new ScreenDaoImpl();
    }

    public EquipmentDao createEquipmentDao() {
        return new EquipmentDaoImpl();
    }

    public EquipmentTypeDao createEquipmentTypeDao() {
        return new EquipmentTypeDaoImpl();
    }

    public BuildingDao createBuildingDao() {
        return new BuildingDaoImpl();
    }

    public FloorDao createFloorDao() {
        return new FloorDaoImpl();
    }

    public DepartmentDao createDepartmentDao() {
        return new DepartmentDaoImpl();
    }

    public FacultyDao createFacultyDao() {
        return new FacultyDaoImpl();
    }

    public StageDao createStageDao() {
        return new StageDaoImpl();
    }

    public SlotDao createSlotDao() {
        return new SlotDaoImpl();
    }

    public ScheduleDao createScheduleDao() {
        return new ScheduleDaoImpl();
    }

    public EquipmentSpecificationDao createEquipmentSpecificationDao() {
        return new EquipmentSpecificationDaoImpl();
    }
}
