package com.fym.lta.BAO;
/**
 *
 * @author Islam
 */
import com.fym.lta.DTO.BuildingDto;

import java.util.List;

public abstract interface BuildingBao {
    public abstract void ListEmptyLocations(BuildingDto build);

    public abstract List<BuildingDto> ListAll();

    public abstract void ListAllLocations(BuildingDto build);

    public abstract Boolean insert(BuildingDto build);

    public abstract Boolean update(BuildingDto build);

    public abstract Boolean delete(BuildingDto build);

    public abstract List<BuildingDto> searchFor(BuildingDto build);
}
