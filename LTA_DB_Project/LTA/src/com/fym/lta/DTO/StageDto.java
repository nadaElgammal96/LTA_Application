package com.fym.lta.DTO;

public class StageDto {
    
    private String code;
    private int num_of_std;
    private int number;
    private StageScheduleDto schedule;
   
    
    public StageDto(){
       super();
       }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setNum_of_std(int num_of_std) {
        this.num_of_std = num_of_std;
    }

    public int getNum_of_std() {
        return num_of_std;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
