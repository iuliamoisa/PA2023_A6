import java.util.*;
abstract class Person implements Node, Comparable<Person>{
    protected String name;
    protected String birthdate;
    @Override
    public String getName() {
        return name;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getBirthdate() {
        return birthdate;
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }

    private Map<Node, String> relationship = new HashMap<Node, String>();
    public void addRelationship(Node node, String typeOfRelationship){
        relationship.put(node, typeOfRelationship);
    }
    public int getImportance(){
        return relationship.size();
    }

    @Override
    public String toString() {
        return name + " - " + birthdate + " ";
    }
}
