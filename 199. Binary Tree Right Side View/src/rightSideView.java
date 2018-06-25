import java.util.*;

class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
//BFS： level order traversal;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        getrightSideView(root, 0, res);
        return res;
    }

    private void getrightSideView(TreeNode root, int lev, List<Integer> res){
        if(root == null)
            return;
        if(lev == res.size())
            res.add(root.val);
        getrightSideView(root.right, lev+1, res);
        getrightSideView(root.left, lev+1, res);
    }

    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.left.right = new TreeNode(3);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        //root.right.left.right = new TreeNode(10);
        root.right.right = new TreeNode(7);

        System.out.println("1,3,7,8,3:"+rightSideView(root));
    }
}

