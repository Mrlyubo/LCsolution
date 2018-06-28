import java.util.LinkedList;

class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /** we keep track of the running sum of all nodes which we have traversed thus far.
    * because the value that is going to added by root is not in the root.right nor the root.left,
    * and it is a little like the "Count" in DFS search.*/
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        convertBST(root.right); // no need to consider the further detail inside the function.
        root.val += sum;
        sum = root.val;
        convertBST(root.left);
        return root;
    }


    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        TreeNode root = new TreeNode(6);
        root.right = new TreeNode(9);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(8);
        root.right.left.left = new TreeNode(7);
        root.right.right = new TreeNode(11);

        System.out.println(serialize(convertBST(root)));
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

