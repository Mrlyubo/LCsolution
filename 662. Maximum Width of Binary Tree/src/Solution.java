import java.util.ArrayList;
import java.util.List;

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 0, 1, new ArrayList<>(), new ArrayList<>());
    }

    private int dfs(TreeNode root, int lev, int order, List<Integer> start, List<Integer> end){
        if(root == null) return 1;
        if(start.size() == lev){
            start.add(order);
            end.add(order);
        }
        else {
            end.set(lev, order);
        }
        int cur = end.get(lev) - start.get(lev) + 1;
        int left = dfs( root.left, lev +1, 2*order, start, end);
        int right = dfs( root.right, lev + 1, 2 * order + 1, start, end);
        return Math.max(cur, Math.max(left, right));
    }

    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);
        System.out.println("4:" + widthOfBinaryTree(root));



        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.left.left = new TreeNode(5);
        root1.left.right = new TreeNode(3);
        System.out.println("2:" + widthOfBinaryTree(root1));

        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(1);
        root3.left.left = new TreeNode(1);
        root3.left.right = new TreeNode(1);
        root3.left.right.right = new TreeNode(1);
        root3.left.right.right.left = new TreeNode(2);
        root3.left.right.right.left.left = new TreeNode(2);
        root3.left.right.right.left.left.left = new TreeNode(2);
        root3.left.right.right.right = new TreeNode(2);
        root3.left.right.right.right.right = new TreeNode(2);
        root3.left.right.right.right.right.right = new TreeNode(2);
        root3.right = new TreeNode(1);
        root3.right.left = new TreeNode(1);
        root3.right.right = new TreeNode(1);
        System.out.println("8:" + widthOfBinaryTree(root3));

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(3);
        root2.left.right.left = new TreeNode(6);
        root2.left.right.left.left = new TreeNode(8);
        root2.left.right.right = new TreeNode(7);
        root2.left.right.right.left = new TreeNode(11);
        root2.left.right.right.left.left = new TreeNode(12);
        root2.right = new TreeNode(3);
        root2.right.left = new TreeNode(6);
        root2.right.right = new TreeNode(5);
        root2.right.right.left = new TreeNode(7);
        root2.right.right.left.right = new TreeNode(10);
        root2.right.right.left.right.right = new TreeNode(13);
        System.out.println("16:" + widthOfBinaryTree(root2));

        TreeNode root4 = new TreeNode(1);
        System.out.println("1:" + widthOfBinaryTree(root4));

        TreeNode root6 = new TreeNode(1);
        root6.left = new TreeNode(1);
        System.out.println("1:" + widthOfBinaryTree(root6));

        TreeNode root5 = new TreeNode(1);
        root5.left = new TreeNode(2);
        root5.left.left = new TreeNode(2);
        root5.left.right = new TreeNode(5);
        System.out.println("2:" + widthOfBinaryTree(root5));

        TreeNode root7 = new TreeNode(1);
        root7.left = new TreeNode(2);
        root7.left.left = new TreeNode(4);
        root7.left.right = new TreeNode(5);
        root7.right = new TreeNode(3);
        System.out.println("2:" + widthOfBinaryTree(root7));
    }
}

