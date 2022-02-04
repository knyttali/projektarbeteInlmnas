package sti.aaj.domain;

public class Course {
    private int yhPoints;
    private Teacher teacher;
    private int courseId;
    private int hours;
    private String courseName;


    public Course(String courseName, int yhPoints, Teacher teacher, int courseId, int hours) {
        setCourseName(courseName);
        setCourseId(courseId);
        setHours(hours);
        setTeacher(teacher);
        setYhPoints(yhPoints);
    }

    public void setCourseName(String courseName) {
        if(courseName == null || courseName.isEmpty()) {
            throw new IllegalArgumentException("Course name cannot be null/blank");
        }
            this.courseName = courseName;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setTeacher(Teacher teacher) {
        if(teacher == null) {
            throw new IllegalArgumentException("Teacher cannot be null/blank");
        }
            this.teacher = teacher;
    }

    public void setYhPoints(int yhPoints) {
        this.yhPoints = yhPoints;
    }

    public String getCourseName() {
        return courseName;
    }

    public String toString(){
        return "\n" + " course Name: " + courseName + " course ID: " + courseId + " YH poäng: " + yhPoints + " Lärare: " + teacher.getFullName() + " Timmar " + hours;
    }

}