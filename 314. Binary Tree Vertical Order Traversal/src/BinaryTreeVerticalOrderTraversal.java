import java.util.*;

class A {
    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
    }

    /**
     * At First, I stuck at how to get the index of columns,
     * I try to use the pointer, the iterator, However, it doesn't work well.
     * The solution is simple: use a Queue that is similar to the TreeNodeQueue.
     *
     * Second, the total number of the columns can be stores in two integers that
     * severed as the maxIndex and the minIndex.
     *
     *
     * @param root
     * @return
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {

          List<List<Integer>> res = new LinkedList<>();
          if(root == null) return res;
          LinkedList<TreeNode> q = new LinkedList<>();
          LinkedList<Integer> cols = new LinkedList<>();
          Map<Integer,List> map = new HashMap<>();

          q.add(root);
          cols.add(0);
          int max = 0, min = 0, col;
          TreeNode node;

          while (! q.isEmpty() ){
              node = q.poll();
              col = cols.poll();

              if(!map.containsKey(col))
                  map.put(col,new LinkedList());
              map.get(col).add(node.val);

              if(node.left != null){
                  q.add(node.left);
                  cols.add(col-1);
                  min = Math.min(col - 1, min);
              }

              if(node.right != null){
                  q.add(node.right);
                  cols.add(col+1);
                  max = Math.max(col + 1,max);
              }
          }

          for(int i = min ; i < max+1;i ++){
              res.add(map.get(i));
          }
          return  res;
    }

    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(8);
        root1.left.right = new TreeNode(0);
        root1.left.left = new TreeNode(4);
        root1.right.left = new TreeNode(1);
        root1.right.right = new TreeNode(7);
        root1.left.right.right = new TreeNode(2);
        root1.right.left.left = new TreeNode(5);

        System.out.println( verticalOrder(root) );
        System.out.println( verticalOrder(root1) );
    }
}