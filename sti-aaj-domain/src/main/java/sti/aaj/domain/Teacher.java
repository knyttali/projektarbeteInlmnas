package sti.aaj.domain;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public class Teacher extends Person{

    private int salary;

    public Teacher(String name, String surname, int id, int salary) {
        super(name, surname, id);
        this.salary = salary;
    }


}

