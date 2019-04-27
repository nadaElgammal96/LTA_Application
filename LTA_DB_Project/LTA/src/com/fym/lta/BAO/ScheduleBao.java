package com.fym.lta.BAO;

import com.fym.lta.DTO.ScheduleDto;

public abstract interface ScheduleBao {
    public abstract void viewAll();

    public abstract boolean update(ScheduleDto s);

    public abstract boolean add(ScheduleDto s);

    public abstract void searchFor(int i);

    public abstract void uploadFile();
}
