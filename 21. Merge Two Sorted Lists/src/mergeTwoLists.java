class Solution {
    //****two pointers[optimized], always move the slow pointer.
    //***optimize: when one listNode is null, add all the other listNode;
    //***optimize: use l1 = l1.next, no need to use iterator;

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        if (l1 == null)
            prev.next = l2;
        if (l2 == null)
            prev.next = l1;
        return dummy.next;
    }

    //****two pointers, always move the slow pointer.
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummyhead = new ListNode(0);
        ListNode p = dummyhead;
        while (p1 != null || p2 != null){
            if(p2 == null|| p1 != null && p1.val <= p2.val ){
                p.next = new ListNode(p1.val);
                p1 = p1.next;
            }
            else if(p1 == null || p2 != null && p1.val > p2.val){
                p.next = new ListNode(p2.val);
                p2 = p2.next;
            }
            p = p.next;
        }
        return dummyhead.next;

    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        printListNode(mergeTwoLists(l1,l2));

        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(0);
        printListNode(mergeTwoLists(l3,l4));

        ListNode l5 = new ListNode(1);
        printListNode(mergeTwoLists(null,l5));

        printListNode(mergeTwoLists(null ,null));

        ListNode l7 = new ListNode(1);
        ListNode l8 = new ListNode(2);
        l8.next = new ListNode(2);
        l8.next.next = new ListNode(2);
        l8.next.next.next = new ListNode(2);
        printListNode(mergeTwoLists(l7,l8));

    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public void printListNode(ListNode node){
        ListNode p = node;
        System.out.print("{");
        while (p != null){
            System.out.print(p.val+",");
            p = p.next;
        }
        System.out.println("}");
    }
}

