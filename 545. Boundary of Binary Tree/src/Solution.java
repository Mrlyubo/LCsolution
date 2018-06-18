import java.util.*;

class Solution {
    LinkedList<Integer> list = new LinkedList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        list.clear();
        if(root == null) return list;
        list.add(root.val); //***note: Add the root.val first!!!!!!!!
        if(root.left != null)
            findleft(root.left);
        if(root.left != null || root.right != null)
            findleaves(root);
        if(root.right != null)
            findright(root.right);
        return list;
    }

    public void findleft(TreeNode root){
        if(root.left == null && root.right == null)
            return;
        if(root.left == null){
            list.add(root.val);
            findleft(root.right);
        }
        else{
            list.add(root.val);
            findleft(root.left);
        }
    }

    public void findright(TreeNode root){
        if(root.left == null && root.right == null)
            return;
        if(root.right == null){
            findright(root.left);
            list.add(root.val); // ***note: list.add() after child visit(reverse)!!!!!!!!
        }

        else{
            findright(root.right);
            list.add(root.val);
        }
    }
    public void findleaves(TreeNode root){
        if(root.left == null && root.right == null){
            list.add(root.val);
            return;
        }
        if(root.left != null)  findleaves(root.left);
        if(root.right != null) findleaves(root.right);
    }



    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        TreeNode root1 = deserialize("1,2,4,null,null,5,7,null,null,8,null,null,3,6,9,null,null,10,null,null,null");
        System.out.println("1,2,4,7,8,9,10,6,3"+":"+boundaryOfBinaryTree(root1));

        TreeNode root2 = deserialize("1,null,2,3,null,null,4,null,null");
        System.out.println("1, 3, 4, 2"+":"+boundaryOfBinaryTree(root2));

        TreeNode root4 = deserialize("1,2,3,null,null,4,null,null,null");
        System.out.println("1, 2, 3, 4"+":"+boundaryOfBinaryTree(root4));

        TreeNode root3 = deserialize("1,null,null");
        System.out.println("1"+":"+boundaryOfBinaryTree(root3));

        TreeNode root5 = deserialize("1,null,2,null,null");
        System.out.println("1,2"+":"+boundaryOfBinaryTree(root5));

        TreeNode root6 = deserialize("1,2,null,null,null");
        System.out.println("1,2"+":"+boundaryOfBinaryTree(root6));
    }

    private static int idx = 0;
    public TreeNode deserialize(String data) {
        idx = 0;
        String[] arr = data.split(",");
        return buildTree(arr);
    }

    public TreeNode buildTree(String[] arr) {
        String p = arr[idx++];
        if (p.equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(p));
        root.left = buildTree(arr);
        root.right = buildTree(arr);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

