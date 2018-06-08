import java.util.*;

class A {
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int x) {
          val = x;
      }
  }
  // Recursive Approach: 15ms
    public List<String> binaryTreePaths (TreeNode root) {
        List<String> sol = new ArrayList();
        if (root == null) return sol;
        paths(root, ""+root.val, sol);//""+Interger will be String. No need to use StringBuilder.
        return sol;
    }
    private void paths(TreeNode root, String path, List<String> sol) {
        if (root.left == null && root.right == null) {
            sol.add(path);
            return;
        }
        if (root.left != null) {
            paths(root.left, path + "->" + root.left.val, sol);
        }
        if (root.right != null) {
            paths(root.right, path + "->" + root.right.val, sol);
        }
        return;
    }
    //My Approach: 18ms
    public List<String> binaryTreePaths1(TreeNode root) {
        LinkedList<String> res = new LinkedList<>();
        LinkedList<String> res1 = new LinkedList<>();
        Queue<TreeNode> node = new LinkedList<>();
        if(root == null )  return res;
        TreeNode n;
        node.add(root);
        res.add(String.valueOf(root.val));
        while (!node.isEmpty()) {
            n = node.poll();
            String s = res.peek();

            if(n.left != null) {
                StringBuilder sbl = new StringBuilder();
                node.add(n.left);
                sbl.append(s).append("->").append(n.left.val);
                res.add(sbl.toString());
            }
            if(n.right != null){
                StringBuilder sbr = new StringBuilder();
                node.add(n.right);
                sbr.append(s).append("->").append(n.right.val);
                res.add(sbr.toString());
            }
            if(n.left != null || n.right != null)
                res.removeFirst();
            else res1.add(res.removeFirst());
        }
        return res1;
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

/*        TreeNode root1  = new TreeNode(1);

        TreeNode root2  = new TreeNode(1);
        root2.left = new TreeNode(2);

        TreeNode root3 =null;

        TreeNode root4 = new TreeNode(2);
        root4.left = new TreeNode(1);
        root4.right = new TreeNode(6);
        root4.right.left = new TreeNode(5);
        root4.right.left.left = new TreeNode(4);
        root4.right.left.left.left = new TreeNode(3);*/

        System.out.println( binaryTreePaths(root).toString() );
/*        System.out.println( binaryTreePaths(root1).toString() );
        System.out.println( binaryTreePaths(root2).toString() );
        System.out.println( binaryTreePaths(root3).toString() );
        System.out.println( binaryTreePaths(root4).toString() );*/
    }
}