import java.util.*;

public class maxSubtree {

    double res = -1;
    public double maxSubtree(TreeNode root) {
        if(root == null)
            return 0;

        double left = maxSubtree(root.left);
        double right = maxSubtree(root.right);

        int leftNum = subtreeNum(root.left);
        int rightNum = subtreeNum(root.right);

        double tmpres = (root.val + left * leftNum + right * rightNum)/(leftNum + rightNum + 1);
        System.out.println("roo = "+ root.val + ", tmpres = " + tmpres);
        if(tmpres > res)
            res = tmpres;
        return tmpres;

    }

    public int subtreeNum ( TreeNode root) {
        if(root == null)
            return 0;
        return subtreeNum(root.left) + subtreeNum(root.right) + 1;
    }

    public static void main(String[] args) {
        maxSubtree Launcher = new maxSubtree();
        Launcher.start();
    }

    public void start() {
        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(120);
        root.right = new TreeNode(80);
        root.left.left = new TreeNode(40);
        root.left.left.left = new TreeNode(50);
        root.left.right = new TreeNode(60);
        root.right.left = new TreeNode(50);
        root.right.right = new TreeNode(70);

        System.out.println(maxSubtree(root));
        System.out.println(res);

//        TreeNode root1 = new TreeNode(100);
//        root1.left = new TreeNode(80);
//        root1.right = new TreeNode(40);
//        root1.left.left = new TreeNode(60);
//        System.out.println(maxSubtree(root1));
//        System.out.println(res);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}

