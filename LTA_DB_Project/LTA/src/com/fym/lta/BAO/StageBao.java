package com.fym.lta.BAO;

import com.fym.lta.DTO.StageDto;

import com.fym.lta.DTO.UserDto;

import java.util.List;


public abstract interface StageBao {
  
  
    public abstract boolean update(StageDto S , UserDto user);

    public abstract List<StageDto> viewAll();

    public abstract boolean add(StageDto s , UserDto user) ;

    public abstract List<StageDto> searchFor(StageDto s);

    public abstract boolean delete(StageDto s);
    
    public abstract boolean isExist(StageDto s);
    

}
