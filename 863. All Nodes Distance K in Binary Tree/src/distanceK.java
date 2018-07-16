import java.util.*;

class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        if (root == null || K < 0) return res;

        build(root, null);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> seen = new HashSet<>();
        q.add(target);
        seen.add(target);
        while (!q.isEmpty()){

            int size = q.size();
            if(K == 0){
                for (int i = 0; i < size ; i++)
                    res.add(q.poll().val);
                return res;
            }

            for(int i = 0; i < size ; i++) {
                for (TreeNode next : graph.get(q.poll())) {
                    if (!seen.contains(next)) {
                        seen.add(next);
                        q.add(next);
                    }
                }
            }
            K--;
        }
        return res;
    }

    private void build(TreeNode root, TreeNode parent){
        if(root == null)
            return;
        if(!graph.containsKey(root)) {
            graph.put(root, new ArrayList<>());

            if (parent != null) {
                graph.get(root).add(parent);
                graph.get(parent).add(root);
            }
            build(root.left, root);
            build(root.right, root);
        }

    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        System.out.println(distanceK(root, root.left, 2));
    }
}

