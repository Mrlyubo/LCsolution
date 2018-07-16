import java.util.HashSet;
import java.util.Set;

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    private Set<Integer> set = new HashSet<>();
    public boolean checkEqualTree(TreeNode root) {
        if (root == null) return false;
        int t = // the sum of the whole tree.
                root.val +
                dfs(root.left) +
                dfs(root.right);
        return (t % 2 == 0) &&
                set.contains(t / 2);
    }
    private int dfs(TreeNode n) {
        if (n == null) return 0;
        int t =
                n.val +
                dfs(n.left) +
                dfs(n.right);
        set.add(t); // record all the different sums of each subtree in the tree.
        return t;
    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(10);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(3);
        System.out.println("true:"+checkEqualTree(root));

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(10);
        root1.right.left = new TreeNode(2);
        root1.right.right = new TreeNode(20);
        System.out.println("false:"+checkEqualTree(root1));

        TreeNode root2 = new TreeNode(0);
        root1.left = new TreeNode(-1);
        root1.right = new TreeNode(1);
        System.out.println("false:"+checkEqualTree(root2));
    }
}

