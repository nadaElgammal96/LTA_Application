package com.fym.lta.DAO;


import com.fym.lta.DTO.*;

import java.util.List;

public abstract interface FloorDao {
    
    
    public abstract Boolean createNew(FloorDto f1);

    public abstract Boolean delete(FloorDto  f2);

    public abstract Boolean update(FloorDto  f);

    public abstract List<BuildingDto> viewAll();

    public abstract FloorDto  searchFor(String c);

    public abstract Boolean isExist(FloorDto  f);
}
