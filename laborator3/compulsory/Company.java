
public class Company implements Node, Comparable<Company>{
    private String name;
    public Company(String name){
        this.name = name;
    }

    @Override
    public int compareTo(Company o) {
        if(name != null)
            return this.name.compareTo(o.name);
        return 0;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                '}';
    }
}
