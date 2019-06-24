package com.fym.lta.DTO;

public class WorkOnDto {
    
   
        private int course_id;
        private int work_hrs;
        private int staff_id;
        
        
        public WorkOnDto(){
            super();
        }

        public void setCourse_id(int course_id) {
            this.course_id = course_id;
        }

        public int getCourse_id() {
            return course_id;
        }

        public void setWork_hrs(int work_hrs) {
            this.work_hrs = work_hrs;
        }

        public int getWork_hrs() {
            return work_hrs;
        }

        public void setStaff_id(int staff_id) {
            this.staff_id = staff_id;
        }

        public int getStaff_id() {
            return staff_id;
        }
}
