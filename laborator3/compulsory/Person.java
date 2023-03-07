import java.util.*;
public class Person implements Node, Comparable<Person>{
    private final String name;
    private String position;
    public Person(String name, String position){
        this.name = name;
        this.position = position;
    }
    public String getPosition() {
        return position;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person o) {
        if(name != null)
            return this.name.compareTo(o.name);
        return 0;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
