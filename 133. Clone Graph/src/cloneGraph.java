import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class A {

        class UndirectedGraphNode {
            int label;
            List<UndirectedGraphNode> neighbors;
            UndirectedGraphNode(int x) {
                label = x;
                neighbors = new ArrayList<>();
            }
        }
        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            return clone(node);
        }
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        private UndirectedGraphNode clone(UndirectedGraphNode node){
            if(node == null) return null;
            if(map.containsKey(node.label)){
                return map.get(node.label);
            }

            UndirectedGraphNode clone = new UndirectedGraphNode(node.label);// clone the node and put it into map
            map.put(clone.label,clone);

            for(UndirectedGraphNode neighbor: node.neighbors){//clone/add  neighbors.
                clone.neighbors.add(clone(neighbor));
            }
            return clone;
        }

        public static void main(String [] args){
            A Launcher = new A();
            Launcher.start();
        }
        public void start(){
            UndirectedGraphNode node0 = new UndirectedGraphNode(0);
            UndirectedGraphNode node1 = new UndirectedGraphNode(1);
            UndirectedGraphNode node2 = new UndirectedGraphNode(2);
            node0.neighbors.add(node1);node0.neighbors.add(node2);
            node1.neighbors.add(node2);
            node2.neighbors.add(node2);

            cloneGraph(node0);

            System.out.println();
    }
}
