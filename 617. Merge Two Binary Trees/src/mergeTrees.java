import java.util.LinkedList;

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //Key: use ?: operator in the function's parameter.
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) return null;

            int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
            TreeNode newNode = new TreeNode(val);

            newNode.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
            newNode.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);

            return newNode;
    }

/*    TreeNode p;
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        p = null;
        if(t1 == null && t2 == null)
            return p;
        int val1 = t1 == null ? 0 : t1.val;
        int val2 = t2 == null ? 0 : t2.val;
        p = new TreeNode(val1+val2);
        merge( t1, t2, p);
        return p;
    }

    public TreeNode merge(TreeNode t1, TreeNode t2, TreeNode p){
        if(t1 == null && t2 == null)
            return p;
        int lval1 = 0, lval2 = 0, rval1 = 0, rval2 = 0;
        boolean hast1 = false, hast2 = false;
        if(t1 != null) {
            hast1 = true;
            lval1 = t1.left == null? 0 : t1.left.val;
            rval1 = t1.right == null? 0 : t1.right.val;
        }
        if(t2 != null) {
            hast2 = true;
            lval2 = t2.left == null? 0 :t2.left.val;
            rval2 = t2.right == null? 0 :t2.right.val;
        }
        if(hast1 || hast2) {
            if(hast1 && t1.left != null || hast2 && t2.left != null)
                p.left = new TreeNode(lval1 + lval2);
            if(hast1 && t1.right!= null || hast2 && t2.right != null)
                p.right = new TreeNode(rval1 + rval2);
            merge(hast1?t1.left:null, hast2?t2.left:null, p.left);
            merge(hast1?t1.right:null, hast2?t2.right:null,p.right);
        }
        return p;
    }*/

    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.left.left = new TreeNode(5);
        t1.left.left.left = new TreeNode(9);
        t1.right = new TreeNode(2);

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.left.right = new TreeNode(4);
        t2.right = new TreeNode(3);
        t2.right.right = new TreeNode(7);

        System.out.println(serialize(mergeTrees(t1, t2)));

        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = null;
        System.out.println(serialize(mergeTrees(t4, t3)));
    }

    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder res = new StringBuilder();
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add( root );
        res.append( root.val).append(","); // Integer to String: String.valueOf()
        TreeNode L, R;


        while( !q.isEmpty()){
            L = q.peek().left;
            R = q.peek().right;
            if(L != null ) q.add(L);
            if(R != null ) q.add(R);
            res.append(( L != null ) ? L.val :"null").append(",");
            res.append(( R != null ) ? R.val :"null").append(",");
            q.poll();
        }
        while (res.charAt(res.length()-1) -'0' >10||res.charAt(res.length()-1)-'0' < 0)
            res.deleteCharAt(res.length()-1);
        return  res.toString();
    }
}

