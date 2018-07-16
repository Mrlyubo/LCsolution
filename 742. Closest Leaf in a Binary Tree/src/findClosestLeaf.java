import java.util.*;
class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
//My way:
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    public int findClosestLeaf2(TreeNode root, int k) {
        graph.clear();
        resCnt =  Integer.MAX_VALUE;
        res = null;
        if(root.left == null  && root.right == null )
            return root.val;
        buildGraph(root);
        dfs(graph, k,0, new HashSet<>(), root.val);
        return res;
    }

    // Build an undirected map of the whole tree recursively.
    private void buildGraph(TreeNode root){
        if(root == null)
            return;
        //put   Parent -> child   into the map.
        int key = root.val;
        if(!graph.containsKey(key))
            graph.put(key, new HashSet<>());
        if(root.left != null)
            graph.get(key).add(root.left.val);
        if(root.right != null)
            graph.get(key).add(root.right.val);

        //put   child -> Parent   into the map
        for(int v : graph.get(key)){
            if(!graph.containsKey(v))
                graph.put(v, new HashSet<>());
            graph.get(v).add(key);
        }

        // Build the map of the rest tree recursively.
        buildGraph(root.left);
        buildGraph(root.right);
    }

    int resCnt = Integer.MAX_VALUE;
    Integer res = null;
    private void dfs(Map<Integer, Set<Integer>> graph, int cur, int cnt, Set<Integer> seen, int ori){
        if(graph.get(cur).size() == 1 && cur != ori){ //*****Note: cnt != 0
            if (cnt < resCnt){
                resCnt = cnt;
                res = cur;
            }
            return;
        }
        seen.add(cur);
        for(int val : graph.get(cur)){
            if(!seen.contains(val))
                dfs(graph, val, cnt+1, seen, ori);
        }
    }

//************************************Java DFS + BFS 27ms********************************
    //1. First, preform DFS on root in order to find the node whose val = k,
    //   at the meantime use HashMap to keep record of all back edges from child to parent;
    //2. Then perform BFS on this node to find the closest leaf node

    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        TreeNode match = dfsCheck(root, map, k);
        Queue<TreeNode> que = new LinkedList<>();
        que.add(match);
        while(!que.isEmpty()){
            TreeNode cur = que.poll();
            if(cur.left==null && cur.right==null){
                return cur.val;
            }
            if(cur.left != null)  que.add(cur.left);
            if(cur.right != null) que.add(cur.right);
            if(map.containsKey(cur)){
                que.add(map.get(cur));
                map.remove(cur);
            }
        }
        return -1;
    }

    private TreeNode dfsCheck(TreeNode root, Map<TreeNode, TreeNode> map, int k){
        if(root == null) return null;
        if(root.val == k) return root;
        if(root.left != null){
            map.put(root.left, root);
            TreeNode left = dfsCheck(root.left, map, k);
            if(left != null) return left;
        }
        if(root.right != null){
            map.put(root.right, root);
            TreeNode right = dfsCheck(root.right, map, k);
            if(right != null) return right;
        }
        return null;
    }

    //***********************************************************
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
/*        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        System.out.println("2/3:"+findClosestLeaf(root, 1));

        TreeNode root1 = new TreeNode(1);
        System.out.println("1:"+findClosestLeaf(root1, 1));

        TreeNode root11 = new TreeNode(1);
        root11.right = new TreeNode(2);
        System.out.println("2:"+findClosestLeaf(root11, 1));

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(4);
        root2.left.left.left = new TreeNode(5);
        root2.left.left.left.left = new TreeNode(6);
        root2.right = new TreeNode(3);
        System.out.println("3:"+findClosestLeaf(root2, 2));*/

        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(3);
        root3.left.left = new TreeNode(4);
        root3.left.left.left = new TreeNode(6);
        root3.left.left.left.left = new TreeNode(7);
        root3.left.right = new TreeNode(5);
        root3.left.right.left = new TreeNode(9);
        root3.left.right.right = new TreeNode(8);
        root3.right = new TreeNode(3);
        System.out.println("7:"+findClosestLeaf(root3, 4));


    }
}

