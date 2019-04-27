package com.fym.lta.DAO;


import com.fym.lta.DTO.FacultyDto;

import java.util.List;

public abstract interface FacultyDao {
    public abstract Boolean update(FacultyDto f);

    public abstract FacultyDto  searchFor(String c);

    public abstract Boolean isExist(FacultyDto  f);

    public abstract List<FacultyDto > viewAll();

    public abstract Boolean delete(FacultyDto  f);

    public abstract Boolean createNew(FacultyDto  f);
}
