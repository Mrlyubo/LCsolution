import java.util.*;

public class zigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> leverList = new ArrayList<>();
        zBFS(root, leverList, 0);

        return leverList;

    }

    public void zBFS(TreeNode node, List<List<Integer>> leverList, int lever) {
        if(node == null){
            return;
        }
        if(leverList.size() <= lever){
            leverList.add(new ArrayList<>());
        }

        if(lever % 2 == 0){
            leverList.get(lever).add(node.val);
        } else {
            leverList.get(lever).add(0,node.val);
        }


            zBFS(node.left, leverList, lever+1);
            zBFS(node.right, leverList, lever+1);

    }

    public static void main(String[] args) {
        zigzagLevelOrder Launcher = new zigzagLevelOrder();
        Launcher.start();
    }

    public void start() {
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);
//
//        System.out.println(zigzagLevelOrder(root));

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        System.out.println(zigzagLevelOrder(root1));

        TreeNode root2 = new TreeNode(0);
        root2.left = new TreeNode(1);
        System.out.println(zigzagLevelOrder(root2));
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


}
