package com.fym.lta.DTO;

public class StaffSlotDto {
    public StaffSlotDto() {
        super();
    }
    private StaffDto staff;
    private SlotDto slot;


    public void setStaff(StaffDto staff) {
        this.staff = staff;
    }

    public StaffDto getStaff() {
        return staff;
    }

    public void setSlot(SlotDto slot) {
        this.slot = slot;
    }

    public SlotDto getSlot() {
        return slot;
    }

}
