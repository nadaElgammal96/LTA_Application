package com.fym.lta.BAO;

import com.fym.lta.DTO.EmployeeDto;
import com.fym.lta.DTO.UserDto;

import java.util.List;

public abstract interface EmployeeBao {

    public abstract boolean update(EmployeeDto emp , UserDto user);

    public abstract boolean delete(EmployeeDto emp);

    public abstract List<EmployeeDto> searchFor(EmployeeDto emp);

    public abstract boolean add(EmployeeDto emp , UserDto user);
    
    public abstract List<EmployeeDto> listAll();
    
    public abstract UserDto viewUser(EmployeeDto emp);
}
