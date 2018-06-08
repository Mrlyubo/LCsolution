import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
class A {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
   }
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists==null||lists.size()==0) return null;

        PriorityQueue<ListNode> queue= new PriorityQueue<>((ListNode o1,ListNode o2) -> o1.val-o2.val);

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (ListNode node:lists)
            if (node!=null)
                 queue.add(node);

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;
            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        LinkedList<ListNode> lists = new LinkedList<>();

        ListNode A = new ListNode(1);
        A.next = new ListNode(4);
        A.next.next = new ListNode(5);

        ListNode B = new ListNode(1);
        B.next = new ListNode(3);
        B.next.next = new ListNode(4);

        ListNode C = new ListNode(2);
        C.next = new ListNode(6);

        lists.add(A);
        lists.add(B);
        lists.add(C);

        ListNode p = mergeKLists(lists);
        while ( p.next != null){
            System.out.print(p.val+",");
            p = p.next;
        }
    }
}

