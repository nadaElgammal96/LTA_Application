package com.fym.lta.BAO;

import com.fym.lta.DTO.WorkOnDto;
import java.util.List;

public interface StaffCourseBao {
    
    public abstract boolean add(WorkOnDto staff_course);
    
    public abstract boolean delete(WorkOnDto staff_course);
    
    public abstract List<WorkOnDto> viewAll();

  /////////////////////Nada El-Gammal ---recently added
  public abstract boolean isExist(WorkOnDto staff_course);
    
}
