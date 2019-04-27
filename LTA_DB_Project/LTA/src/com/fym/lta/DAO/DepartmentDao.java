package com.fym.lta.DAO;


import com.fym.lta.DTO.DepartmentDto;

import java.util.List;

public abstract interface DepartmentDao {
    
    public abstract List<DepartmentDto> searchFor(DepartmentDto d);

    public abstract boolean delete(DepartmentDto d);

    public abstract boolean createNew(DepartmentDto d);

    public abstract List<DepartmentDto> viewAll();

    public abstract boolean update(DepartmentDto d);

    public abstract boolean isExist(DepartmentDto d);
}
