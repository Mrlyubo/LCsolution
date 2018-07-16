import jdk.nashorn.api.tree.Tree;

class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //**********************
    int i = 0;
    public TreeNode str2tree1(String s) {
        if (s == null || s.length() == 0) { return null; }
        return helper(s.toCharArray());
    }

    private TreeNode helper(char[] s)
    {
        // done
        if (i == s.length) { return null; }

        // extract number
        StringBuilder num = new StringBuilder();
        while (i < s.length && s[i] != '(' && s[i] != ')') {
            num.append(s[i]);
            i++;
        }

        // create new node
        TreeNode n = null;
        if (num.length() != 0)
        {
            n = new TreeNode(Integer.parseInt(num.toString()));
        }

        // check parenthesis type
        if (i < s.length && s[i] == '(')
        {
            // create left child node
            i++;
            n.left = helper(s);
            i++;

            if (i < s.length && s[i] == '(') // right child node is inside the left child node.
            {
                // create right child node
                i++;
                n.right = helper(s);
                i++;
            }
        }
        // if meets ')', return to parent node
        return n;
    }

//***********************************
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0)
            return null;
        int firstParen = s.indexOf("(");
        int val = firstParen == -1 ? Integer.parseInt(s) : Integer.parseInt(s.substring(0, firstParen));
        TreeNode cur = new TreeNode(val);
        if (firstParen == -1)
            return cur;
        int start = firstParen, leftParenCount = 0;
        for (int i=start;i<s.length();i++) {
            if (s.charAt(i) == '(')
                leftParenCount++;
            else if (s.charAt(i) == ')')
                leftParenCount--;
            if (leftParenCount == 0 && start == firstParen) {
                cur.left = str2tree(s.substring(start+1,i)); // s.substring !!!!!!
                start = i+1;
            }
            else if (leftParenCount == 0)
                cur.right = str2tree(s.substring(start+1,i));
        }
        return cur;
    }

    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        System.out.println("4(12(3)(1))(6(5))："+tree2str1(str2tree("4(12(3)(1))(6(5))")));
        System.out.println("4()(3)："+tree2str1(str2tree("4()(3)")));
    }



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

    public void printArray ( String[] array){
        System.out.print("[");
        for(String n: array)
            System.out.print(n+",");
        System.out.println("]");
    }
}

