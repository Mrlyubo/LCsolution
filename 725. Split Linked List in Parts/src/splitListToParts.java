class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode[] splitListToParts(ListNode root, int k) {
            ListNode iter = root;
            int size = 0;
            while (iter != null){
                iter = iter.next;
                size++;
            }
            int len = size/k;
            int headlen = len + 1;
            int headsize = size % k;

            iter = root;
            ListNode[] res = new ListNode[k];
            ListNode tmp;
            res[0] = iter;
            int idx = 0;
            while (idx < headsize) {
                res[idx++] = iter;
                for (int j = 0; j < headlen; j++) {
                    if (j == headlen - 1) {
                        tmp = iter;
                        iter = iter.next;
                        tmp.next = null;
                        break;
                    }
                    iter = iter.next;
                }
            }

            while (iter != null){
                res[idx++] = iter;
                for (int j = 0; j < len; j++) {
                    if (j == len - 1) {
                        tmp = iter;
                        iter = iter.next;
                        tmp.next = null;
                        break;
                    }
                    iter = iter.next;
                }
            }
            return res;
    }



    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(6);
        root.next.next.next.next.next.next = new ListNode(7);
        root.next.next.next.next.next.next.next = new ListNode(8);
        root.next.next.next.next.next.next.next.next = new ListNode(9);
        root.next.next.next.next.next.next.next.next.next = new ListNode(10);
        printArray(splitListToParts(root, 3));




    }

    public void printArray ( ListNode[] array){
        System.out.print("[");
        for(ListNode n: array){
            ListNode p = n;
            System.out.print("[");
            while (p != null){
                System.out.print(p.val+",");
                p = p.next;
            }
            System.out.print("]");
        }
        System.out.println("]");
    }
}

