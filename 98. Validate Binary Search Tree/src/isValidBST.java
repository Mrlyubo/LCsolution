import java.util.Stack;

class A {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isValidBST1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if( root == null ) return true;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur.left != null){
                stack.push(cur.left);
                if(cur.left.val >= cur.val)
                    return false;
            }
            if(cur.right != null){
                stack.push(cur.right);
                if(cur.right.val <= cur.val)
                    return false;
            }
        } return true;
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean helper(TreeNode root, long min, long max){
        if(root == null)
            return true;
        if(root.val >= max || root.val <= min)
            return false;
        return helper(root.left, min, root.val) &&// min(same as root's min) < root.left < root.val;
               helper(root.right, root.val, max);// root.val < root.right < max(same as root's max);
    }

    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(10);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(25);
        System.out.println(isValidBST(root));
    }
}

