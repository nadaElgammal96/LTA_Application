package com.fym.lta.DAO;



import java.util.List;
import com.fym.lta.DTO.CourseDto;

public abstract interface CourseDao {
    
    public abstract Boolean isExist(CourseDto c);

    public abstract CourseDto searchFor(String code);

    public abstract Boolean delete(CourseDto c);

    public abstract List<CourseDto> viewAll();

    public abstract Boolean update(CourseDto c);

    public abstract Boolean createNew(CourseDto c);
}
