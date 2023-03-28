package org.example;

import org.jgrapht.Graph;
import org.jgrapht.alg.matching.HopcroftKarpMaximumCardinalityBipartiteMatching;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.DepthFirstIterator;

import java.util.*;

public class Problem {

    List<Student> studentsList;
    List<Project> projectsList;
    private Map<Student, List<Project>> preferancesMap = new HashMap<>();
    public Map<Student, Project> assignmentMap = new HashMap<>();
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

    public void addPreferences(Student s, List<Project> projectsList){
        preferancesMap.put(s, projectsList);
    }
    public double getAvgNrOfPreferences(){
        return studentsList.stream()
                .mapToDouble(Student::getNrOfPreferences)
                .average()
                .getAsDouble();
    }
    public void displayStudentsWithLessPreferences(){
        List<Student> studentsWithLessPreferences = studentsList.stream()
                .filter(student -> student.getNrOfPreferences() < getAvgNrOfPreferences())
                .toList();
        studentsWithLessPreferences.forEach(System.out::println);
    }
    public List<Project> getProjectsList() {
        return this.projectsList;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }


    public void selectProject(){
        for(Map.Entry<Student, List<Project>> entry : preferancesMap.entrySet()){
            int i = 0;
            if(assignmentMap.isEmpty())
                assignmentMap.put(entry.getKey(), entry.getValue().get(i));
            while(i < entry.getValue().size())
                if(assignmentMap.containsValue(entry.getValue().get(i)))
                    i++;
                else
                    assignmentMap.put(entry.getKey(), entry.getValue().get(i));
        }
    }
    public Map<Student, List<Project>> getPrefMap(){
        return preferancesMap;
    }
    public Map<Student, Project> afterGreedy(){
        return assignmentMap;
    }

    ///////////////bonus

    private Graph<String, DefaultEdge> graph;
    Set<DefaultEdge> edges;
    public void HopfortKarp(){

        SimpleGraph<String,DefaultEdge> g = new SimpleGraph<String,DefaultEdge>(DefaultEdge.class);
        Set<String> s1 = new HashSet<>(); //set studenti
        Set<String> s2 = new HashSet<>(); //set proiecte
        /*
            creare graf in care nodurile sunt studenti & proiecte, iar muchiile sunt intre
            studenti si proiectele preferate
         */
        for(Map.Entry<Student,List<Project>> i : preferancesMap.entrySet()){
            g.addVertex(i.getKey().getName());
            s1.add(i.getKey().getName());
        }
        for(var p : projectsList){
            g.addVertex(p.getName());
            s2.add(p.getName());
        }
        for(Map.Entry<Student,List<Project>> i : preferancesMap.entrySet()){
            for(Project p : preferancesMap.get(i.getKey())){
                g.addEdge(i.getKey().getName(), p.getName());
            }
        }

        HopcroftKarpMaximumCardinalityBipartiteMatching<String, DefaultEdge> alg =
                new HopcroftKarpMaximumCardinalityBipartiteMatching<>(g, s1, s2);
        graph = g;
        edges = alg.getMatching().getEdges();
        System.out.println(edges.toString());

    }
    private void edgesToRemove(){
        Set<DefaultEdge> toRemove = new HashSet<>();
        Iterator<String > it = new DepthFirstIterator<>(graph);
        while(it.hasNext()){
            Set<DefaultEdge> edgesTouchingV = graph.edgesOf(it.next());
            for(DefaultEdge e : edgesTouchingV)
                if(edges.contains(e) == false) //daca muchia nu se regaseste, o sterg
                    toRemove.add(e);
        }
        for(DefaultEdge e : toRemove)
            if(graph.containsEdge(e))
                graph.removeEdge(e); //remove edges which are not part of admissible pairs
    }
/*
 minimum cardinality set formed of students and projects with the property that each admissible pair (student-project)
  contains at least an element of this set.
 */
    void minCard(){
        edgesToRemove();
        String vertex;
        Iterator<String> iterator = new DepthFirstIterator<>(graph);
        while(iterator.hasNext()){
            vertex = iterator.next();
            if(graph.degreeOf(vertex) != 0)
                System.out.println(vertex);
        }
    }
/*
maximum cardinality set of of students and projects such that there is no admissible pair (student-project)
 formed with elements of this set.
 */
    void maxCard(){
        edgesToRemove();
        String vertex;
        Iterator<String> it = new DepthFirstIterator<>(graph);
        while(it.hasNext()){
            vertex = it.next();
            if(graph.degreeOf(vertex) == 0)
                System.out.println(vertex);
        }
    }
}