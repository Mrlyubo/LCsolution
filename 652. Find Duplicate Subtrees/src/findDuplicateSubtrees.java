import java.util.*;

public class findDuplicateSubtrees {

    Map<Integer, Set<TreeNode>> map = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();


        //reverse the whole tree, and store in the map
        traverse(root);

        //check if the root has the same subtree using serialization
        for(int val: map.keySet()) {
            Set<TreeNode> nodes = map.get(val);
            Map<String , Set<TreeNode>> nodemap = new HashMap<>();

            if(nodes.size() >= 2){
                //serialize the root and put into nodemap
                for(TreeNode node : nodes){
                    String s = serialize(node);
                    nodemap.putIfAbsent(s, new HashSet<>());
                    Set<TreeNode> set = nodemap.get(s);
                    set.add(node);
                    if(set.size() == 2) {
                        res.add(node);
                        System.out.println(s);
                    }
                }
            }

        }
        return res;
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    public void buildString(TreeNode root, StringBuilder sb) {
        if (root == null)
            sb.append("NN").append(",");
        else {
            sb.append(root.val).append(",");
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }

    public void traverse (TreeNode root) {
        if(root == null)
            return;

        map.putIfAbsent(root.val, new HashSet<>());
        map.get(root.val).add(root);
        traverse(root.left);
        traverse(root.right);
    }

    public static void main(String[] args) {
        findDuplicateSubtrees Launcher = new findDuplicateSubtrees();
        Launcher.start();
    }

    public void start() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);
        root.right.right = new TreeNode(4);
        root.left.left = new TreeNode(4);
        findDuplicateSubtrees(root);

    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
