import java.util.*;
public class Solution {
    int t;
    Map<String, Integer> trees;
    Map<Integer, Integer> count;
    List<TreeNode> ans;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {//60ms
        t = 1;
        trees = new HashMap();
        count = new HashMap();
        ans = new ArrayList();
        lookup(root);
        return ans;
    }

    public int lookup(TreeNode node) {
        if (node == null) return 0;
        String serial = node.val + "," +
                lookup(node.left) + "," +
                lookup(node.right);
        //if the Map trees do not containsKey(serial), then t++;
        int uid = trees.computeIfAbsent(serial, x-> t++);
        //computeIfAbsent 相当于 put ，but do not need to check existence

        count.put(uid, count.getOrDefault(uid, 0) + 1);
        if (count.get(uid) == 2)
            ans.add(node);
        return uid;
    }
    //*****************************************************************************************
        public List<TreeNode> findDuplicateSubtrees1(TreeNode root) {//14ms
            List<TreeNode> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            // key -> [id, count]
            Map<Long, int[]> map = new HashMap<>(); // int[] id: id[0] is id unique id of the subtree, id[1] is the # of same subtree
            getId(root, map, res);
            return res;
        }
        private int getId(TreeNode root, Map<Long, int[]> map, List<TreeNode> res) {
            if (root == null) {
                return 0;
            }
            // getId 返回的 0,1,2,3...这样的id, 因此|的话不会丢信息

            // | (按位或)
            //  对每一对比特位执行或（OR）操作。如果 a 或 b 为 1，则 a OR b 结果为 1。或操作的真值表：
            Long key = ((long)(root.val)) << 32 |
                    getId(root.left, map, res) << 16 |
                    getId(root.right, map, res);
            int[] id = map.get(key);
            if (id == null) {
                id = new int[]{map.size() + 1, 1};
                map.put(key, id);
            } else {
                id[1]++;
                if (id[1] == 2) {
                    res.add(root);
                }
            }
            return id[0];
        }
//*****************************************************************************************
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);
        root.right.right = new TreeNode(4);
        root.left.left = new TreeNode(4);
        findDuplicateSubtrees1(root);

    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
//*****************************************************************************************
}

