package com.fym.lta.DTO;

public class WorkOnDto {
    
   
        private String course_id;
        private Float work_hrs;
        private String ssn;
        
        
        public WorkOnDto(){
            super();
        }

        public void setCourse_id(String course_id) {
            this.course_id = course_id;
        }

        public String getCourse_id() {
            return course_id;
        }

        public void setWork_hrs(Float work_hrs) {
            this.work_hrs = work_hrs;
        }

        public Float getWork_hrs() {
            return work_hrs;
        }

        public void setSsn(String ssn) {
            this.ssn = ssn;
        }

        public String getSsn() {
            return ssn;
        }
}
