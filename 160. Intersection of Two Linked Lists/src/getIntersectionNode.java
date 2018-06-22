class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        ListNode C = new ListNode(3);
        ListNode A = new ListNode(1);
        C.next = A;

        ListNode D = new ListNode(4);
        ListNode B = new ListNode(2);
        D.next = B;
        B.next = C;
        System.out.println(getIntersectionNode(C,D).val);
    }
    public void printListNode(ListNode node){
        ListNode p = node;
        while (p != null){
            System.out.println(p.val);
            p = p.next;
        }
    }
}

