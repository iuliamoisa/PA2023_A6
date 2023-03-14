public class Main {
    public static void main(String[] args) {
        Network network = new Network();
        Programmer ana = new Programmer("Ana", "12.05.1998");
        ana.setSpecialization("Frontend");
        Programmer stefan = new Programmer("Stefan", "22.06.1997");
        stefan.setSpecialization("Backend");
        Designer andrei = new Designer("Andrei", "17.01.1995");
        andrei.setNrOfProjects(3);
        Designer cristi = new Designer("Cristi", "31.10.1994");
        cristi.setNrOfProjects(2);
        Programmer diana = new Programmer("Diana", "12.03.1999");
        diana.setSpecialization("Fullstack");
        Company comp1 = new Company("Microsoft");
        comp1.setNrOfEmployees(20000);
        Company comp2 = new Company("Facebook");
        comp2.setNrOfEmployees(15000);
        ana.addRelationship(diana, "best friend");
        ana.addRelationship(andrei, "boyfriend");
        ana.addRelationship(comp1, "Front-end developer");
        comp1.addRelationship(ana);
        diana.addRelationship(comp1, "Back-end developer");
        comp1.addRelationship(diana);
        diana.addRelationship(cristi, "Co-worker");
        cristi.addRelationship(stefan, "Co-worker");
        andrei.addRelationship(cristi, "Co-worker");
        andrei.addRelationship(comp2, "Boss");
        comp2.addRelationship(andrei);

        network.addNode(ana);
        network.addNode(diana);
        network.addNode(andrei);
        network.addNode(cristi);
        network.addNode(stefan);
        network.addNode(comp1);
        network.addNode(comp2);

        System.out.println(comp1.getName() + " has " + comp1.getImportance() + " connections");
        System.out.println(comp2.getName() + " has " + comp2.getImportance() + " connections");
        System.out.println(diana.getName() + " has " + diana.getImportance() + " connections");
        System.out.println(ana.getName() + " has " + ana.getImportance() + " connections");
        System.out.println(network.ordering());

    }
}
