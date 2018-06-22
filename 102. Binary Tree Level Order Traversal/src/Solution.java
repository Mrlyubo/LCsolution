import java.util.*;

class Solution {
    //Recursion!
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelList = new ArrayList<>();
        BFS(root, levelList, 0);
        return levelList;
    }
    //note: why we need to put levelList in the helper(levelList)?
    //because we need to leverList.get(level);

    private void BFS(TreeNode node, List<List<Integer>> levelList, int level) {
        if (node == null) return;
        if (levelList.size() <= level) {
            levelList.add(new ArrayList<>());
        }
        levelList.get(level).add(node.val);
        BFS(node.left, levelList, level+1);
        BFS(node.right, levelList, level+1);
    }


    //No Recursion!
    public List<List<Integer>> levelOrder1(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>(); // First in, Last out -> Deque.
        List<List<Integer>> res = new ArrayList<>();

        //boundary check
        if(root == null)  return res;

        //initialize
        queue.add(root);
        List<Integer> list0 = new ArrayList<>();
        list0.add(root.val);
        res.add(list0);
        int cnt = queue.size();// the num of node of current level;

        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            while (cnt != 0){ // when cnt == 0, finish the current level.
                TreeNode cur = queue.poll();
                cnt --;
                if(cur.left != null){
                    queue.add(cur.left);
                    list.add(cur.left.val);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                    list.add(cur.right.val);
                }
                //System.out.println("...list:"+list);
            }
            cnt = queue.size();
            //System.out.println("cnt:"+cnt);
            if(!list.isEmpty()) res.add(list);
            //System.out.println("res"+res);
        }
        return res;
    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(levelOrder(root));

        /*TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        System.out.println(levelOrder(root1));

        TreeNode root2 = new TreeNode(0);
        root2.left = new TreeNode(1);
        System.out.println(levelOrder(root2));

        TreeNode root3 = new TreeNode(0);
        System.out.println(levelOrder(root3));*/
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

