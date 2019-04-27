package com.fym.lta.DTO;

public class CourseDepartDto {
    
    
    private int course_id;
    private int department_id;
    private int no_of_courses;

    public int getNo_of_courses() {
        return no_of_courses;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setNo_of_courses(int no_of_courses) {
         this.no_of_courses = no_of_courses;
    }

    public void setCourse_id(int course_id) {
          this.course_id = course_id;
    }
    public CourseDepartDto(){
        super();
        }
}
