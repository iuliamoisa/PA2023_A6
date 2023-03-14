package org.example;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        var students = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Student("S" + i))
                .toArray(Student[]::new);
        var projects = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Project("P" + i))
                .toArray(Project[]::new);

        LinkedList<Student> listOfStud=new LinkedList<>();
        Collections.addAll(listOfStud, students);

        TreeSet<Project> listOfProj=new TreeSet<>();
        Collections.addAll(listOfProj, projects);

        Collections.sort(listOfStud);
        System.out.println(listOfStud);
        //TreeSet --> already sorted
        System.out.println(listOfProj);
    }
}