package com.fym.lta.DAO;

import com.fym.lta.BAO.ScheduleSlotBao;
import com.fym.lta.BAO.ScheduleSlotBaoImpl;

public class DaoFactory {
    public EmployeeDao createEmployeeDao() {
        return new EmployeeDaoImpl();
    }

    public UserDao createUserDao() {
        return new UserDaoImpl();
    }
    
    public StageScheduleDao createStageScheduleDao()
    {
      return new StageScheduleDaoImpl();  
    }

  public ScheduleSlotDao createScheduleSlotDao()
  {
    return new ScheduleSlotDaoImpl();

  }


  public LocationDao createLocationDao() {
        return new LocationDaoImpl();
    }
    
    public RoleScreenDao createRoleScreenDao() {
        return new RoleScreenDaoImpl();
      }

    public LocationTypeDao createLocationTypeDao() {
     return new LocationTypeDaoImpl();
     }

    public StaffDao createStaffDao() {
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
    
    public EqTypeSpecDao createEqTypeSpecDao(){
        return new EqTypeSpecDaoImpl();
    }
    public CourseDao createCourseDao() {
        return new CourseDaoImpl();
    }
    public StaffUSerDao createStaffUserDao(){
        return new StaffUserDaoImpl();
    }
    public EmpUserDao createEmpUserDao(){
        return new EmpUserDaoImpl();
    }
    public StaffCourseDao createStaffCourseDao(){
        return new StaffCourseDaoImpl();
    }
}
