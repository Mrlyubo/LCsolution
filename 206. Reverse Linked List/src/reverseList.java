import java.util.Stack;

/**
public ListNode reverseList(ListNode head) {
    //iterative solution 
    ListNode newHead = null;
    while (head != null) {
        ListNode next = head.next;
        head.next = newHead;
        newHead = head;
        head = next;
    }
    return newHead;
}*/
class A {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public ListNode reverseList1(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        if(head == null) return head;
        ListNode p = head;
        while( p != null){
            stack.push(p.val);
            p=p.next;
        }
        ListNode rlist = new ListNode(stack.pop());
        ListNode rp = rlist;
        while( !stack.isEmpty()){
            rp.next = new ListNode(stack.pop());
            rp=rp.next;
        }
        return rlist;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    public ListNode reverseList(ListNode head) {
        /* recursive solution */
        return reverseListInt(head, null);
    }

    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }


    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);


        reverseList(head);
    }
}