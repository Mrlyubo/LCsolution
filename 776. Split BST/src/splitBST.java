class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
        public TreeNode[] splitBST(TreeNode root, int V) {
            if (root == null)
                return new TreeNode[]{null, null};
            else if (root.val <= V) {
                TreeNode[] bns = splitBST(root.right, V);
                root.right = bns[0];
                bns[0] = root;
                return bns;
            } else {
                TreeNode[] bns = splitBST(root.left, V);
                root.left = bns[1];
                bns[1] = root;
                return bns;
            }
        }
    public TreeNode[] splitBST1(TreeNode root, int V) {
        TreeNode[] res = new TreeNode[2];
        res[0] = root;
        res[1] = null;
        TreeNode p = root, p0 = null, prev;
        boolean found = false, isRight = false;
        while (p != null) {
            prev = p;

            //p -> p.right
            if (p.right != null && V >= p.val) {
                p = p.right;

                if (V < p.val) {
                    //add res[1]
                    if (!found) {
                        res[1] = p;
                        p0 = prev;
                        found = true;
                        isRight = true;
                        continue;
                    }

                    //add new link
                    if (isRight) {
                        p0.right = p;

                    } else {
                        p0.left = p;
                    }
                    p0 = prev;
                    isRight = true;
                }
            }

            //p -> p.left
            else if (p.left != null && V < p.val) {
                p = p.left;

                if (V >= p.val) {
                    //add res[1]
                    if (!found) {
                        res[1] = p;
                        p0 = prev;
                        found = true;
                        isRight = false;
                        continue;
                    }

                    //add new link
                    if (isRight) {
                        p0.right = p;
                    } else {
                        p0.left = p;
                    }
                    p0 = prev;
                    isRight = false;
                }
            }

            else
                break;
        }

        if(isRight) {
            if (p0 != null)
                p0.right = null;
        }
        else {
            if (p0 != null)
                p0.left = null;
        }

        //swap res[0] and res[1] if necessary.
        if(root != null && V < p.val){
            TreeNode tmp = res[0];
            res[0] = res[1];
            res[1] = tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
/*        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        TreeNode[] res2 = splitBST(root,5);
        System.out.print("0:"+tree2str(res2[0])+"   &&&   ");
        System.out.println("1:"+tree2str(res2[1]));
        System.out.println("**********************");*/

        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(10);
        root1.right.right = new TreeNode(30);
        root1.right.right.left = new TreeNode(20);
        root1.right.right.left.right = new TreeNode(25);
        root1.right.right.left.right.left = new TreeNode(24);
        root1.right.right.left.right.right = new TreeNode(28);
        root1.right.right.left.right.right.left = new TreeNode(26);
        root1.right.right.left.right.right.right = new TreeNode(29);
        root1.right.right.right = new TreeNode(31);
        TreeNode[] res3 = splitBST(root1,27);
        System.out.print("0:"+tree2str(res3[0])+"   &&&   ");
        System.out.println("1:"+tree2str(res3[1]));
        System.out.println("**********************");

        TreeNode root4 = new TreeNode(1);
        TreeNode[] res4 = splitBST(root4,1);
        System.out.print("0:"+tree2str(res4[0])+"   &&&   ");
        System.out.println("1:"+tree2str(res4[1]));
        System.out.println("**********************");

    }

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
}

