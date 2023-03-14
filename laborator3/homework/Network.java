import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class Network {
    private static List<Node> nodes = new ArrayList<>();
    public void addNode(Node node) {
        nodes.add(node);
    }

    public List<Node> ordering() {
        List<Node> sortedNodes = new ArrayList<>(nodes);
        Collections.sort(sortedNodes, new Comparator<Node>() {
            public int compare(Node n1, Node n2) {
                return n2.getImportance() - n1.getImportance();
            }
        });
        return sortedNodes;
    }

    @Override
    public String toString() {
        return "Network{" +
                "nodes=" + nodes +
                '}';
    }

}
