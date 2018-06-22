import java.util.ArrayList;
import java.util.LinkedList;

class Codec {
    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
    // Encodes a tree to a single string.

    /**
     * At first, the program is pretty slow(660ms), I think the problem is in serialize().
     * In serialize(), the conversion path is :TreeNode -> LinkedList<String> -> String.
     * the String.get(i) is slow.
     * Try : ArrayList<String>, faster, 660ms -> 324ms.Not Bad, but not fast enough.
     * Second thought, it will be fater to not to use List<String>, just use StringBuilder.
     * Yeah!! StringBuilder is much much faster, it only 324ms -> 28ms!!!!!
     *
     * @param root
     * @return
     */
    public String serialize1(TreeNode root) {
        if(root == null) return "";
        ArrayList<String> res = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add( root );
        res.add( String.valueOf(root.val)); // Integer to String: String.valueOf()
        TreeNode L, R;
        String ans = "";

        while( !q.isEmpty()){
            L = q.peek().left;
            R = q.peek().right;
            if(L != null ) q.add(L);
            if(R != null ) q.add(R);
            res.add(( L != null ) ? String.valueOf(L.val) :"null");
            res.add(( R != null ) ? String.valueOf(R.val) :"null");
            q.poll();
        }
        while(res.get(res.size()-1) == "null") res.remove(res.size()-1);
        for( int i = 0 ; i < res.size()-1 ; i ++)
            ans +=  res.get(i) + ",";
        ans += res.get(res.size()-1);
        return  ans;
    }

    //Use StringBuider.
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

    // Decodes your encoded data to tree.

    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        TreeNode root = new TreeNode(0);
        LinkedList<TreeNode> node = new LinkedList<>();
        int i = 0 ;
        TreeNode currNode = null;

        for(String s : data.split(",")){
            int num;
            if(!s.equals("null")) // (String == String) is not allowed.
                num = Integer.parseInt(s);
            else {
                i++;
                if(i%2 == 0) currNode = node.poll();
                continue;
            }
            if(i == 0) {
                root.val = num;
                node.add(root);
                i++;
                continue;
            }
            //if(i%2 == 1)  currNode = node.poll();  
            if(i%2 == 1){
                currNode = node.poll();
                currNode.left = new TreeNode(num);
                node.add(currNode.left);
            }
            else{
                currNode.right = new TreeNode(num);
                node.add(currNode.right);
            }
            i++;
        }
        return  root;
    }

    public static void main(String [] args){
          Codec Launcher = new Codec();
          Launcher.start();
    }
     public void start(){
          TreeNode root = new TreeNode(1);
          root.left = new TreeNode(2);
          root.right = new TreeNode(3);
          root.right.left = new TreeNode(4);
          root.right.right = new TreeNode(5);
          //System.out.println(serialize(root));
          String data = "5,4,7,3,null,2,null,-1,null,9",data1 ="";
          String data2 = "1,2,3,null,null,4,5",data3="1,null,2";
          System.out.println( serialize(deserialize(data3)));
     }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));