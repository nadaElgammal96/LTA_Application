package com.fym.lta.BAO;

import com.fym.lta.DTO.LocationTypeDto;

import java.util.List;

/**
 *
 * @author Mai-AbdEltwab
 */

public abstract interface LocationTypeBao {
    public abstract boolean update(LocationTypeDto lt);

    public abstract boolean add(LocationTypeDto lt);

    public abstract List<LocationTypeDto> viewAll();
    
    public abstract List<LocationTypeDto> searchFor(LocationTypeDto lt);

    public abstract boolean delete(LocationTypeDto lt);
}
