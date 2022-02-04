package sti.aaj.domain;

import java.util.HashMap;
import java.util.Map;

public class Vault {
    private static Map<Integer, Course> courses = new HashMap();
    private static Map<Integer, Student> students = new HashMap();


    public static Course createCourse(int courseId, Course course){
        if(!courses.containsValue(course)){
            return courses.put(courseId, course);
        }
        return null;
    }

    public static Student createStudent(int id, Student student) {

        return students.put(id, student);
    }

    public static Student getStudent(int id) {
        if (students.get(id) == null) {
            throw new IllegalArgumentException("\nDet finns ingen student med detta id.\n");
        }
        return students.get(id);
    }

    public static Course getCourse(int courseId) {

        return courses.get(courseId);
    }
    public static void removeCourse(int courseId){
        courses.remove(courseId);
    }
}