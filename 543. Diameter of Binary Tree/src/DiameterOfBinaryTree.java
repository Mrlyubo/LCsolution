class A {

    /**
     * 1.Special cases:
           []
           [0]
           [1,2]
           [4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2]
               the max is root -9, not 4.
     * 2. the  diameter path maybe not go across the first root.
     * 3.the 4 recursive method will be too slow.
     * 4. It is no need to use recursive method to compute current diameter. just use global int currDiameter.
     * 5. 2 recursive method is pretty fast.
     *
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int currDiameter=0; // it should be outside the diameterOfBinaryTree and ouside the maxdepth;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        currDiameter = 0;//set to zero for a new Tree.
        maxdepth(root);
        return currDiameter;
    }

    public int maxdepth(TreeNode root) {
        if( root == null) return 0;
        int leftdepth = 0, rightdepth = 0;
        leftdepth =(root.left != null) ? maxdepth(root.left)+1:0;
        rightdepth =(root.right != null) ? maxdepth(root.right)+1:0;
        currDiameter = Math.max(currDiameter,leftdepth+rightdepth); // compute it ,but no need to not return it.
        return  Math.max(leftdepth,rightdepth);
    }
    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeNode root1 = new TreeNode(1);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);

        TreeNode root3 = new TreeNode(1);
        root3.left =  new TreeNode(2);
        root3.right =  new TreeNode(3);
        root3.right.left = new TreeNode(4);
        root3.right.right = new TreeNode(5);
        root3.right.right.left = new TreeNode(6);
        root3.right.left.left = new TreeNode(7);
        root3.right.left.left.left = new TreeNode(8);
        root3.right.left.left.left.left = new TreeNode(9);
        root3.right.left.left.left.left.left = new TreeNode(10);
        root3.right.left.right = new TreeNode(11);
        root3.right.left.right.left = new TreeNode(12);
        root3.right.left.right.left.left = new TreeNode(13);
        root3.right.left.right.left.left.left = new TreeNode(14);



        System.out.println( diameterOfBinaryTree(root));
        System.out.println( diameterOfBinaryTree(root1));
        System.out.println( diameterOfBinaryTree(root2));
        System.out.println( diameterOfBinaryTree(root3));
    }
}