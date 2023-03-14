import java.util.HashMap;
import java.util.Map;

public class Company implements Node, Comparable<Company>{
    private String name;
    private int nrOfEmployees;
    public Company(String name){
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }
    public void setNrOfEmployees(int nrOfEmployees) {
        this.nrOfEmployees = nrOfEmployees;
    }
    public int getNrOfEmployees() {
        return nrOfEmployees;
    }

    @Override
    public int compareTo(Company o) {
        return this.name.compareTo(o.name);
    }
    private Map<Node, Integer> relationship = new HashMap<Node, Integer>();
    int i = 0;
    public void addRelationship(Node node){
        relationship.put(node, ++i);
    }
    public int getImportance(){
        return relationship.size();
    }

    @Override
    public String toString() {
        return "\n" + name +
                " ; nrOfEmployees=" + nrOfEmployees;
    }
}
