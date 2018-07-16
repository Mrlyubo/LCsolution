class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //My Way: 49ms,slow, maybe because of the consecutive .append.append.append.
    public String tree2str1(TreeNode t) {
        tree2sb(t);
        return tree2sb(t).toString();
    }

    public StringBuilder tree2sb(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        if (t == null) return sb;
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
        if (!(t.left == null && t.right ==null))
            left.append("(").append(tree2sb(t.left)).append( ")");
        if (t.right != null)
            right.append("(").append(tree2sb(t.right)).append( ")");
        return sb.append(t.val).append(left).append(right);
    }


    //Better Way: 13ms,fast.
    // 1.put StringBuilder in the parameter.
    public String tree2str(TreeNode t) {
        StringBuilder builder = new StringBuilder();
        helper(t, builder);
        return builder.toString();
    }

    private void helper(TreeNode root, StringBuilder builder){
        if(root == null){
            return;
        }
        builder.append(root.val);
        if(root.left != null || root.right != null){
            builder.append("(");
            helper(root.left, builder);
            builder.append(")");
            if(root.right != null){
                builder.append("(");
                helper(root.right, builder);
                builder.append(")");
            }
        }
    }



    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(4);
        System.out.println("1(2(4))(3):" + tree2str(t));

        TreeNode r = new TreeNode(1);
        r.left = new TreeNode(2);
        r.left.right = new TreeNode(4);
        r.right = new TreeNode(3);
        System.out.println("1(2()(4))(3):" + tree2str(r));

        TreeNode r1 = new TreeNode(1);
        r1.left = new TreeNode(2);
        r1.left.right = new TreeNode(4);
        r1.left.right.right = new TreeNode(5);
        r1.right = new TreeNode(3);
        System.out.println("1(2()(4()(5)))(3):" + tree2str(r1));

        TreeNode r4 = new TreeNode(1);
        r4.right = new TreeNode(3);
        System.out.println(":" + tree2str(r4));
    }
}

