import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Person ana = new Person("Ana","designer");
        System.out.println("Ana's position is: " + ana.getPosition());
        
        Company comp1 = new Company("Microsoft");
        List<Node> nodes = new ArrayList<>();
        nodes.add(ana);
        nodes.add(comp1);
        System.out.println(nodes);

    }
}
