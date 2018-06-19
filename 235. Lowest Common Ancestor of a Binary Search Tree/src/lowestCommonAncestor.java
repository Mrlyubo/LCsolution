class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ( root == null ) return root;
        TreeNode ans ;
        if(root.val < p.val && root.val < q.val)
            ans = lowestCommonAncestor(root.right, p, q);
        else if (root.val > p.val && root.val > q.val)
            ans = lowestCommonAncestor(root.left, p, q);
        else
            return root;
        return ans;
    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);


        TreeNode p = root.left;//2
        TreeNode q = root.right;//8
        System.out.println("6:"+lowestCommonAncestor(root,p,q).val);

        TreeNode p1 = root.left;//2
        TreeNode q1 = root.left.right;//4
        System.out.println("2:"+lowestCommonAncestor(root,p1,q1).val);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(1);
        TreeNode p2 = root2.left;//1
        TreeNode q2 = root2;//3
        System.out.println("3:"+lowestCommonAncestor(root2,p2,q2).val);


        TreeNode root3 = new TreeNode(1);
        TreeNode p3 = root3;//1
        TreeNode q3 = root3;//1
        System.out.println("1:"+lowestCommonAncestor(root3,p3,q3).val);
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}

