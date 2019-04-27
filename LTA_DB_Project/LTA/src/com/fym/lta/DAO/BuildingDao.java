package com.fym.lta.DAO;
/**
 *
 * @author Islam
 */

import java.util.List;
import com.fym.lta.DTO.BuildingDto;

public abstract interface BuildingDao {
    
    public abstract List<BuildingDto> SearchFor(BuildingDto b);

    public abstract List<BuildingDto> viewAll();

    public abstract Boolean createNew(BuildingDto b);

    public abstract Boolean delete(BuildingDto b);

    public abstract Boolean isExist(BuildingDto b);

    public abstract Boolean update(BuildingDto b);
}
