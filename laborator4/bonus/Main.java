package org.example;
import com.github.javafaker.Faker;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();
/*
        var students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student(faker.name().fullName()))
                .toArray(Student[]::new);
        var projects = IntStream.rangeClosed(0, 4)
                .mapToObj(i -> new Project(faker.app().name()))
                .toArray(Project[]::new);

        Problem problem1 = new Problem();
        for(int i = 0; i <= 3; i++)
            problem1.addStudent(students[i]);//adaugare studenti la instanta
        System.out.println("List of students: ");
        System.out.println(problem1.getStudentsList());

        System.out.println();

        for(int i = 0; i <= 4; i++)
            problem1.addProject(projects[i]);//adaugare proiecte la instanta
        System.out.println("List of projects: ");
        System.out.println(problem1.getProjectsList());
        System.out.println();

        //preferintele fiecarui student
        students[0].addAdmissibleProject(projects[0]);
        students[0].addAdmissibleProject(projects[1]);
        students[0].addAdmissibleProject(projects[2]);
        students[0].addAdmissibleProject(projects[3]);
        students[0].addAdmissibleProject(projects[4]); //students[0] are 5 proiecte
        System.out.println(students[0].getName() + " prefers the projects:");
        System.out.println(students[0].getAdmissibleProjects());
        students[1].addAdmissibleProject(projects[1]);
        students[1].addAdmissibleProject(projects[3]);
        students[1].addAdmissibleProject(projects[4]); //students[1] are 3 proiecte
        System.out.println(students[1].getName() + " prefers the projects:");
        System.out.println(students[1].getAdmissibleProjects());
        students[2].addAdmissibleProject(projects[0]); //students[2] are 1 proiect
        System.out.println(students[2].getName() + " prefers the projects:");
        System.out.println(students[2].getAdmissibleProjects());
        students[3].addAdmissibleProject(projects[2]);
        students[3].addAdmissibleProject(projects[3]);//students[3] are 2 proiecte
        System.out.println(students[3].getName() + " prefers the projects:");
        System.out.println(students[3].getAdmissibleProjects());

        //creare map cu preferintele fiecarui student
        problem1.addPreferences(students[0], students[0].getAdmissibleProjects());
        problem1.addPreferences(students[1], students[1].getAdmissibleProjects());
        problem1.addPreferences(students[2], students[2].getAdmissibleProjects());
        problem1.addPreferences(students[3], students[3].getAdmissibleProjects());
        //System.out.println("Average nr of preferences: " + problem1.getAvgNrOfPreferences());

        System.out.println("Students that have a number of preferences lower than the average number of preferences: ");
        problem1.displayStudentsWithLessPreferences();

        System.out.println();
        System.out.println("Greedy: ");
        problem1.selectProject();

        System.out.println(problem1.afterGreedy());
        System.out.println();
        problem1.HopfortKarp();
        */

        Problem problem2 = new Problem();//bonus
        var students2 = IntStream.rangeClosed(0, 1000)
                .mapToObj(i -> new Student(faker.name().fullName()))
                .toArray(Student[]::new);
        for(int i = 0; i <= 1000; i++)
            problem2.addStudent(students2[i]);
        var projects2 = IntStream.rangeClosed(0, 1000)
                .mapToObj(i -> new Project(faker.app().name()))
                .toArray(Project[]::new);
        for(int i = 0; i <= 1000; i++)
            problem2.addProject(projects2[i]);
        for(int i = 0; i <= 1000; i++)
            for(int j = 0; j <= 1000-i; j++)
                students2[i].addAdmissibleProject(projects2[j]);
        for(int i = 0; i<= 1000; i++)
            problem2.addPreferences(students2[i], students2[i].getAdmissibleProjects());
        long runTime = System.currentTimeMillis();
        problem2.selectProject();
        System.out.println(problem2.afterGreedy());
        System.out.println(System.currentTimeMillis() - runTime + "ms");
        runTime = System.currentTimeMillis();
        problem2.HopfortKarp();
        System.out.println(System.currentTimeMillis() - runTime + "ms");
        System.out.println("Minimum cardinality set:");
        problem2.minCard();
        System.out.println("Maximum cardinality set :");
        problem2.maxCard();
    }
}