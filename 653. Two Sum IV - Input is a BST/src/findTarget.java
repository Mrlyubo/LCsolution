import java.util.*;

public class findTarget {

    // HashSet and BST traverse

    Set<Integer> set = new HashSet<>();
    boolean flag ;
    public boolean findTarget(TreeNode root, int k) {

        flag = false;
        traverse(root, set, k);
        return flag;

    }

    public void traverse (TreeNode root, Set set,int k){
        if(root == null)
            return;
        if(set.contains(k - root.val)){
            flag = true;
        }
        set.add(root.val);

        traverse(root.left, set, k);
        traverse(root.right, set, k);

    }

    public static void main(String[] args) {
        findTarget Launcher = new findTarget();
        Launcher.start();
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public void start() {
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(3);
//        root.right = new TreeNode(6);
//        System.out.println(findTarget(root, 6));

        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(3);
        root1.right= new TreeNode(6);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(4);
        root1.right.right = new TreeNode(7);
        System.out.println(findTarget(root1, 28));
    }
}
