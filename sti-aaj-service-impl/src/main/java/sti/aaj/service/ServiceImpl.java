package sti.aaj.service;


import sti.aaj.domain.Course;
import sti.aaj.domain.Student;
import sti.aaj.domain.Teacher;
import sti.aaj.domain.Vault;
import sti.aaj.service.StiService;

public class ServiceImpl implements StiService {

    private static Vault vault;

    public Course createCourse(String courseName, int yhPoints, Teacher teacher, int courseId, int hours) {
        Course course =  new Course(courseName, yhPoints, teacher, courseId, hours);
        vault.createCourse(courseId, course);

        return course;
    }

    @Override
    public Teacher createTeacher(String name, String surname, int id, int salary) {
        return null;
    }

    @Override
    public Student getStudent(int id) {
        return vault.getStudent(id);
    }

    @Override
    public Student createStudent(int id, String name, String surname, int courseId) {

        Student student = new Student(name, surname, id, courseId);
        vault.createStudent(id, student);

        return student;
    }

    @Override
    public void setCourse(Student student, int courseId, int input) throws NullPointerException{
        student.setCourse(courseId, input);
    }

}
