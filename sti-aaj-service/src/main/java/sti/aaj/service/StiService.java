package sti.aaj.service;

import sti.aaj.domain.Course;
import sti.aaj.domain.Student;
import sti.aaj.domain.Teacher;

public interface StiService {

    Course createCourse(String courseName, int yhPoints , Teacher teacher, int courseId, int hours);
    Teacher createTeacher(String name, String surname, int id, int salary);
    Student getStudent(int id);
    Student createStudent(int id, String name, String surname, int courseId);

    void setCourse(Student student, int courseId, int input);

}
