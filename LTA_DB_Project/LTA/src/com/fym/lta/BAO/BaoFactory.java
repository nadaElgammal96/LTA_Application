package com.fym.lta.BAO;

public class BaoFactory {
    public BuildingBao createBuildingBao() {
        return new BuildingBaoImpl();
    }
    
     public StageScheduleBao createSatgeScheduleBao()
    {
       return new StageScheduleBaoImpl();
    }
    public ScheduleSlotBao  createScheduleSlotBao()
    {
      return new ScheduleSlotBaoImpl();
    }
    public FloorBao createFloorBao() {
        return new FloorBaoImpl();
    }

   public SlotBao createSLotBao()
   {
     return new SlotBaoImpl();
   }
   
 

  public RoleScreenBao createRoleScreenBao()
    {
      return new RoleScreenBaoImpl();  
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

  

    public ScheduleBao createScheduleBao() {
        return new ScheduleBaoImpl();
    }

    public StageBao createStageBao() {
        return new StageBaoImpl();
    }

    public StaffBao createStuffBao() {
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
    public EqTypeSpecBao createEqTypeSpecBao(){
        return new EqTypeSpecBaoImpl();
    }
    public StaffUserBao createStaffUserBao(){
        return new StaffUserBaoImpl();
    }
    public EmpUserBao createEmpUserBao(){
        return new EmpUserBaoImpl();
    }
    public StaffCourseBao createStaffCourseBao(){
        return new StaffCourseBaoImpl();
    }

  static SlotBao createSlotBao()
  {
    return null;
  }
}
