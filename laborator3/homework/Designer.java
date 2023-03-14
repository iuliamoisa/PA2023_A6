public class Designer extends Person{
    private int nrOfProjects;
    Designer(String name, String birthdate){
        this.name = name;
        this.birthdate = birthdate;
    }

    public void setNrOfProjects(int nrOfProjects) {
        this.nrOfProjects = nrOfProjects;
    }
    public int getNrOfProjects() {
        return nrOfProjects;
    }

    @Override
    public String toString() {
        return "\nDesigner{" + super.toString() + "; " +
                "number of projects=" + nrOfProjects +
                "} ";
    }
}
