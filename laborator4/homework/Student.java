package org.example;
import java.util.*;
import java.util.LinkedList;
import java.util.List;

public class Student implements Comparable<Student>{
    private String name;
    List<Project> admissibleProjects = new LinkedList<>();
    private int preferences;
    public Student(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void addAdmissibleProject(Project p){
        this.admissibleProjects.add(p);
        preferences++;
    }
    public List<Project> getAdmissibleProjects(){
        return this.admissibleProjects;
    }

    public int getNrOfPreferences() {
        return preferences;
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Student{" + name +
                '}';
    }
}
