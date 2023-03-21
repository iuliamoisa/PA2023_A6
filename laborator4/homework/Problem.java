package org.example;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem {

    List<Student> studentsList;
    List<Project> projectsList;
    public int[] projs = new int[5];
    private Map<Student, Project> relationship = new HashMap<Student, Project>();

    public void selectProject(Student s){
        for(int i = 0; i < projs.length; i++)
            if(projs[i] == 0){
                relationship.put(s, projectsList.get(i));
                projs[i] = 1;
                break;
            }
    }
    public Map<Student, Project> printStudProj(){
        return relationship;
    }
    public void printArrayProj(){
        for(int i = 0; i < projs.length; i++){
            System.out.print(projs[i] + "  ");
        }
    }

    public Problem() {
        this.studentsList = new LinkedList<>();
        this.projectsList = new LinkedList<>();
    }

    public void addStudent(Student s) {
        this.studentsList.add(s);
    }

    public void addProject(Project p) {
        this.projectsList.add(p);
    }

    public List<Project> getProjectsList() {
        return this.projectsList;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }
/*
Using Java Stream API, write a query that display all the students that have a number of preferences
lower than the average number of preferences.

 */
    public double getAvgNrOfPreferences(){
        var avgNrOfPreferences = studentsList.stream()
                .mapToDouble(Student::getNrOfPreferences)
                .average()
                .getAsDouble();
        return avgNrOfPreferences;
    }

    public void displayStudentsWithLessPreferences(){
        List<Student> studentsWithLessPreferences = studentsList.stream()
                .filter(student -> student.getNrOfPreferences() < getAvgNrOfPreferences())
                .collect(Collectors.toList());
        studentsWithLessPreferences.forEach(System.out::println);
    }

}
