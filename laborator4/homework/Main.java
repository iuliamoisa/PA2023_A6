package org.example;
import com.github.javafaker.Faker;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();

        var students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student(faker.name().fullName()))
                .toArray(Student[]::new);
        var projects = IntStream.rangeClosed(0, 4)
                .mapToObj(i -> new Project(faker.app().name()))
                .toArray(Project[]::new);

        Problem problem1 = new Problem();
        //adaugare studenti la instanta
        for(int i = 0; i <= 3; i++)
            problem1.addStudent(students[i]);
        System.out.println(problem1.getStudentsList());

        //adaugare proiecte la instanta
        for(int i = 0; i <= 4; i++)
            problem1.addProject(projects[i]);
        System.out.println(problem1.getProjectsList());

        //preferintele fiecarui student
        students[0].addAdmissibleProject(projects[0]);
        students[0].addAdmissibleProject(projects[1]);
        students[0].addAdmissibleProject(projects[2]);
        students[0].addAdmissibleProject(projects[3]);
        students[0].addAdmissibleProject(projects[4]); //students[0] are 5 proiecte
        System.out.println(students[0].getName() + " has the projects:");
        System.out.println(students[0].getAdmissibleProjects());
        students[1].addAdmissibleProject(projects[1]);
        students[1].addAdmissibleProject(projects[3]);
        students[1].addAdmissibleProject(projects[4]); //students[1] are 3 proiecte
        students[2].addAdmissibleProject(projects[0]); //students[2] are 1 proiect
        students[3].addAdmissibleProject(projects[2]);
        students[3].addAdmissibleProject(projects[3]);//students[3] are 2 proiecte

        //System.out.println("Average nr of preferences: " + problem1.getAvgNrOfPreferences());

        System.out.println("Students that have a number of preferences lower than the average number of preferences: ");
        problem1.displayStudentsWithLessPreferences();

        problem1.selectProject(students[0]);
        problem1.selectProject(students[3]);
        problem1.selectProject(students[1]);
        problem1.selectProject(students[2]);
        System.out.println(problem1.printStudProj());
    }
}