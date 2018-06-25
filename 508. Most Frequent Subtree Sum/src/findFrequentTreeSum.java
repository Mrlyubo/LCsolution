import java.util.*;

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //********************* HashMap.
    List<Integer> list = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    int max = 1;
    public int[] findFrequentTreeSum(TreeNode root) {
        traverse1(root);
        int[] res = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public TreeNode traverse1(TreeNode root) {
        if(root == null) return null;
        TreeNode l = traverse1(root.left);
        TreeNode r = traverse1(root.right);
        int sum = root.val;
        sum = l == null ? sum : sum+l.val;
        sum = r == null ? sum : sum+r.val;
        root.val = sum;
        int val = 1;
        if(map.containsKey(sum)) {
            val += map.get(sum);
        }
        map.put(sum, val);
        if(val > max) {
            list.clear();
            list.add(sum);
            max = val;
        }
        else if(val == max) {
            list.add(sum);
        }
        return root;
    }

    //*********************PriorityQueue + HashMap: Too Slow.
    // No need to use priorityQueue, because of the reason above.
    public int[] findFrequentTreeSum1(TreeNode root) {
        if(root == null) return new int[]{};
        else treeSum(root);
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        for(Map.Entry e : map1.entrySet()) pq.add(e);

        int frq0 = pq.peek().getValue();
        List<Integer> list = new ArrayList<>();
        list.add(pq.poll().getKey());
        while (!pq.isEmpty() && pq.peek().getValue() == frq0){
            int next = pq.poll().getKey();
            list.add(next);
        }

        int[] res = new int[list.size()];
        int i = 0;
        for(int n: list) res[i++] = n;
        return res;
    }

    Map<Integer, Integer> map1 = new HashMap<>();
    private int treeSum (TreeNode root){
        int sum;
        int leftval = root.left == null? 0: treeSum(root.left);
        int rightval = root.right == null? 0: treeSum(root.right);
        sum = leftval+rightval+root.val;
        map1.put(sum, map1.getOrDefault(sum,0)+1);
        return sum;
    }

    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
/*        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);
        System.out.println("2,-3,4");
        printArray(findFrequentTreeSum(root));

        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(-5);
        System.out.println("2");
        printArray(findFrequentTreeSum(root1));*/

        TreeNode root2 = null;
        printArray(findFrequentTreeSum(root2));
    }

    public void printArray ( int[] array){
        System.out.print("[");
        for(int n: array)
            System.out.print(n+",");
        System.out.println("]");
    }
}

