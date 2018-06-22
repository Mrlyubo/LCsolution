import java.util.*;


class Codec {
    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
    // Encodes a tree to a single string.



    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    public void buildString(TreeNode root, StringBuilder sb) {
        if (root == null)
            sb.append(NN).append(spliter);
        else {
            sb.append(root.val).append(spliter);
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }

    private static final String spliter = ",";
    private static final String NN = "null";
    private static int idx = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        idx = 0;
        String[] arr = data.split(spliter);
        return buildTree(arr);
    }

    public TreeNode buildTree(String[] arr) {
        String p = arr[idx++];
        if (p.equals(NN)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(p));
        root.left = buildTree(arr);
        root.right = buildTree(arr);
        return root;
    }

    public static void main(String [] args){
          Codec Launcher = new Codec();
          Launcher.start();
    }
     public void start(){
          /*TreeNode root = new TreeNode(1);
          root.left = new TreeNode(2);
          root.right = new TreeNode(3);
          root.right.left = new TreeNode(4);
          root.right.right = new TreeNode(5);
          System.out.println(serialize(root));

          String data = "5,4,7,3,null,2,null,-1,null,9",data1 ="";
          String data2 = "1,2,3,null,null,4,5",data3="1,X,2";
          List data4 = new LinkedList();
          data4.add(1);
          data4.add(null);
          data4.add(2);
          //System.out.println( serialize(deserialize(data3)));*/

         TreeNode root3 = new TreeNode(1);
         root3.left = new TreeNode(2);
         root3.left.left = new TreeNode(4);
         root3.left.right = new TreeNode(5);
         root3.left.right.left = new TreeNode(7);
         root3.left.right.right = new TreeNode(8);
         root3.right = new TreeNode(3);
         root3.right.left = new TreeNode(6);
         root3.right.left.left = new TreeNode(9);
         root3.right.left.right = new TreeNode(10);
         System.out.println(serialize(root3));
     }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));