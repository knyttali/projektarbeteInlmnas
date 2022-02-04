package sti.aaj.domain;
import java.util.ArrayList;

public class Person {
    private String givenName;
    private String surName;
    private int id;

    //---construktor
    public Person(String givenName, String surName, int id){
        setId(id);
        setGivenName(givenName);
        setSurName(surName);
    }

    public Person(Person source) {
        setId(source.id);
        setGivenName(source.givenName);
        setSurName(source.surName);
    }

    //---setters
    public void setSurName(String surName) {
        if (surName == null || surName.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null/blank");
        }
        this.surName = surName;
    }
    public void setGivenName(String givenName) {
        if(givenName == null || givenName.isEmpty()){
            throw new IllegalArgumentException("Name cannot be null/blank");
        }
                this.givenName = givenName;
    }
    public void setId(int id) {

        this.id = id;
    }
    //---getters
    public String getGivenName() {
        return givenName;
    }
    public String getSurName() {
        return surName;
    }
    public int getId() {
        return id;
    }
    //---metoder
    public String getFullName() {
        return givenName + " " + surName;
    }


    public void removeCourse(int courseId) {
        Vault.removeCourse(courseId);
    }

    public String getName() {

        return givenName;
    }
}
