import java.util.LinkedList;
import java.util.List;

class A {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    // 4 lines Java
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right :
               (right == null ? left : root);
    }
    //********************

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> p_path = new LinkedList<>();
        List<TreeNode> q_path = new LinkedList<>();
        int pn = 0, qn =0;
        int diff ;
        if(match(root,p_path,p))
            pn = p_path.size();
        if(match(root,q_path,q))
            qn = q_path.size();
        diff = Math.abs(pn-qn);
        int cnt = diff;
        int n = pn;
        if(pn > qn) {
            n = qn;
            while (cnt > 0){
                p_path.remove(0);
                cnt--;
            }
        }
        if(pn < qn) {
            n = pn;
            while (cnt > 0){
                q_path.remove(0);
                cnt--;
            }
        }
        int i;
        for(i = 0; i < n; i++){
            if(p_path.get(i).val == q_path.get(i).val)
                break;
        }return p_path.get(i);
    }

    private boolean match(TreeNode node, List<TreeNode> path ,TreeNode target){
        if(node == null) return false;
            path.add(0,node);
        if(node.val == target.val)
            return true;
        boolean isMatch =
                match(node.left,path,target) ||
                match(node.right,path,target);
        if(!isMatch) path.remove(0);
        return isMatch;
    }
    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left;//5
        TreeNode q = root.left.right.right;//4
        System.out.println("5:"+lowestCommonAncestor(root,p,q).val);

        TreeNode p1 = root.left;//5
        TreeNode q1 = root.right;//1
        System.out.println("3:"+lowestCommonAncestor(root,p1,q1).val);



        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(1);
        TreeNode p2 = root2.left;//1
        TreeNode q2 = root2;//3
        System.out.println("3:"+lowestCommonAncestor(root2,p2,q2).val);
    }
}