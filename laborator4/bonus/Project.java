package org.example;

import java.util.Objects;

public class Project implements Comparable<Project>
{
    private String name;
    public Project(String name){
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {return name;}

    @Override
    public int compareTo(Project o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Project project) || o == null) return false;

        Project other = (Project) o;
        return getName().equals(other.getName());
    }
}
