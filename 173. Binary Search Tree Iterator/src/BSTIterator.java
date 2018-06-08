import java.util.Stack;

class A {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public class BSTIterator {
        Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            if(root == null) return;
            stack.push(root);
            TreeNode node = stack.peek();
            while (node.left != null) {
                node = node.left;
                stack.push(node);
            }
        }
        public boolean hasNext() {
            return !stack.isEmpty();
        }
        public int next() {
            TreeNode cur = stack.peek();
            int res = cur.val;
            stack.pop();

            if (cur.right != null) {
                cur = cur.right;
                stack.push(cur);
                while(cur.left != null){
                    cur = cur.left;
                    stack.push(cur);
                }
            }
            return res;
        }
    }

    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);

        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(10);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(6);
        root1.left.right.left = new TreeNode(4);
        root1.left.right.right = new TreeNode(7);
        root1.right.right = new TreeNode(14);
        root1.right.right.left = new TreeNode(13);

        TreeNode root2 = null;

        TreeNode root3 = new TreeNode(1);

        TreeNode root4 = new TreeNode(1);
        root4.right = new TreeNode(2);


        BSTIterator i = new BSTIterator(root2);
        int[] res = new int[15];
        int j = 0;
        while (i.hasNext()){
            res[j++] = i.next();
        }
        for(int k : res)
            System.out.print(k+",");
    }
}


/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */