package com.fym.lta.BAO;

import com.fym.lta.DTO.EmployeeDto;

import java.util.List;

public abstract interface EmployeeBao {

    public abstract boolean update(EmployeeDto emp);

    public abstract boolean delete(EmployeeDto emp);

    public abstract List<EmployeeDto> searchFor(EmployeeDto emp);

    public abstract boolean add(EmployeeDto emp);
    
    public abstract List<EmployeeDto> listAll();
}
