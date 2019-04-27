package com.fym.lta.DAO;

import com.fym.lta.DTO.LocationDto;
import com.fym.lta.DTO.LocationTypeDto;
import java.util.List;

/**
 *
 * @author Mai-AbdEltwab
 */


public abstract interface LocationTypeDao {
    public abstract Boolean update(LocationTypeDto lt);

    public abstract List<LocationTypeDto> viewAll();

    public abstract Boolean isExist(LocationTypeDto lt);

    public abstract List<LocationTypeDto> searchFor(LocationTypeDto type);

    public abstract Boolean delete(LocationTypeDto lt);

    public abstract Boolean createNew(LocationTypeDto lt);
}
