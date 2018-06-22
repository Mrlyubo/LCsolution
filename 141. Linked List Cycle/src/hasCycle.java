
class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

// Better Solution: slow and fast pointer.
    public boolean hasCycle (ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if (head == null) return false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    //idea: reverse a Singly-linked list,
    //if the end is null,          then the list has no cycle,
    //else(the end is the head),   then the list has cycle.
    public boolean hasCycle1(ListNode head) {
        ListNode newHead = null;
        ListNode p = head;
        if(p == null) return false;
        ListNode next = p.next;
        p.next = newHead;
        newHead = p;
        p = next;
        while (p != null && p != head){
            next = p.next;
            p.next = newHead;
            newHead = p;
            p = next;
        }
        if( p == null)
            return false;
        else
            return true;
    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        /*ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        //head.next.next.next.next = head.next.next;
        System.out.println("true:"+hasCycle(head));*/

        ListNode head1 = new ListNode(1);
        head1.next = head1;
        System.out.println("true:"+hasCycle(head1));

        ListNode head2 = null;
        System.out.println("true:"+hasCycle(head2));
    }
}

