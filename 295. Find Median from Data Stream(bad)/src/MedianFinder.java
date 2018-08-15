class MedianFinder {

    /** initialize your data structure here. */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int lchildNum = 0;
    int rchildNum = 0;
    TreeNode root;

    public MedianFinder() {
        root = null;
    }

    public void addNum(int num) {
        if(root == null){
            root = new TreeNode(num);
            return;
        }

        if(num >= root.val)
            rchildNum ++;
        else if (num < root.val) {
            lchildNum ++;
        }

        insert(root, num);

        if(lchildNum - rchildNum ==2) { //
            rotateRight();
        }else if (rchildNum - lchildNum == 2) { //
            rotateLeft();
        }

    }

    public void rotateRight() {
        TreeNode rchild = root;
        TreeNode lchild = root.left;


        root = rootLeft(root.left);
        root.right = rchild;
        if(root != lchild)
            root.left = lchild;

        rchild.left = null;
        lchild.right = null;

        root.right = rchild;


        rchildNum++;
        lchildNum--;
    }
    public void rotateLeft() {
        TreeNode lchild = root;
        TreeNode rchild = root.right;


        root = rootRight(root.right);
        root.left = lchild;
        if(root != rchild)
            root.right = rchild;

        lchild.right = null;
        rchild.left = null;




        rchildNum--;
        lchildNum++;
    }


    public void insert(TreeNode tmp, int num) {

        if(tmp.right == null && num >= tmp.val) {
            tmp.right = new TreeNode(num);
        }
        else if(tmp.right != null && num >= tmp.val) {
            insert(tmp.right, num);
        }
        else if(tmp.left == null && num < tmp.val) {
            tmp.left = new TreeNode(num);

        }
        else if(tmp.left != null && num < tmp.val) {
            insert(tmp.left, num);
        }
    }


    public double findMedian() {
        double res = (double)root.val;
        if(lchildNum -rchildNum == 1){
            res =  ((double)(root.val + rootLeft(root.left).val))/2;
        }else if (rchildNum - lchildNum == 1) {
            res =  ((double)(root.val + rootRight(root.right).val))/2;
        }
        return res;
    }
    public TreeNode rootLeft (TreeNode ltmp) {
        while (ltmp.right != null) {
            ltmp = ltmp.right;
        }
        return ltmp;
    }

    public TreeNode rootRight (TreeNode rtmp) {
        while (rtmp.left != null) {
            rtmp = rtmp.left;
        }
        return rtmp;
    }

    public static void main (String[] args) {
//        MedianFinder obj = new MedianFinder();
//        obj.addNum(12);
//        System.out.println("12,"+obj.findMedian());// -> 12
//        obj.addNum(10);
//        System.out.println("11,"+obj.findMedian());// -> 8
//        obj.addNum(13);
//        System.out.println("12,"+obj.findMedian());// -> 6
//        obj.addNum(11);
//        System.out.println("11.5,"+obj.findMedian());// -> 6
//        obj.addNum(5);
//        System.out.println("11,"+obj.findMedian());// -> 6
//        obj.addNum(15);
//        System.out.println("11.5,"+obj.findMedian());// -> 5.5
//        obj.addNum(1);
//        System.out.println("11,"+obj.findMedian());// -> 6
//        obj.addNum(11);
//        System.out.println("11,"+obj.findMedian());// -> 5.5
//        obj.addNum(6);
//        System.out.println("11,"+obj.findMedian());// -> 5
//        obj.addNum(17);
//        System.out.println("11,"+obj.findMedian());// -> 4
//        obj.addNum(14);
//        System.out.println("11,"+obj.findMedian());// -> 3
//        obj.addNum(8);
//        System.out.println("11,"+obj.findMedian());// -> 3
//
//        MedianFinder obj2 = new MedianFinder();
//        obj2.addNum(-1);
//        System.out.println("-1,"+obj2.findMedian());// -> 12
//        obj2.addNum(-2);
//        System.out.println("-1.5,"+obj2.findMedian());// -> 8
//        obj2.addNum(-3);
//        System.out.println("-2,"+obj2.findMedian());// -> 6
//        obj2.addNum(-4);
//        System.out.println("-2.5,"+obj2.findMedian());// -> 6
//        obj2.addNum(-5);
//        System.out.println("-3,"+obj2.findMedian());// -> 6


        MedianFinder obj3 = new MedianFinder();
        obj3.addNum(40);
        System.out.println("40,"+obj3.findMedian());// -> 12
        obj3.addNum(12);
        System.out.println("26,"+obj3.findMedian());// -> 8
        obj3.addNum(16);
        System.out.println("16,"+obj3.findMedian());// -> 6
        obj3.addNum(14);
        System.out.println("15,"+obj3.findMedian());// -> 6
        obj3.addNum(35);
        System.out.println("16,"+obj3.findMedian());// -> 6
        obj3.addNum(19);
        System.out.println("17.5,"+obj3.findMedian());// -> 12
        obj3.addNum(34);
        System.out.println("19,"+obj3.findMedian());// -> 8
        obj3.addNum(35);
        System.out.println("26.5,"+obj3.findMedian());// -> 6
        obj3.addNum(28);
        System.out.println("28,"+obj3.findMedian());// -> 6
        obj3.addNum(35);
        System.out.println("31,"+obj3.findMedian());// -> 6
        obj3.addNum(26);
        System.out.println("28,"+obj3.findMedian());// -> 12
        obj3.addNum(6);
        System.out.println("27,"+obj3.findMedian());// -> 8
        obj3.addNum(8);
        System.out.println("26,"+obj3.findMedian());// -> 6
        obj3.addNum(2);
        System.out.println("22.5,"+obj3.findMedian());// -> 6
        obj3.addNum(14);
        System.out.println("19,"+obj3.findMedian());// -> 6
        obj3.addNum(25);
        System.out.println("22,"+obj3.findMedian());// -> 6


    }
}





//Your MedianFinder object will be instantiated and called as such:
