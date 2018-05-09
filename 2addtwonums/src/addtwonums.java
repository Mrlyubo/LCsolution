
public class addtwonums {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public class ListNode{
        int val;
        ListNode next;
        /** No need to use to Constructor below;

        ListNode(int x, ListNode n){
            val = x;
            next = n;
        }
         */
        ListNode(int x ){
            val = x;
        }



    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);//Better: res = dummyHead.
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p3 = res;//Better: ListNode p1 = l1, p2 = l2 , p3 = res;
        int count = 0;
        int prev = 0;

/**
 * 1. Three special cases:
 *       p1.val+p2.val >10 a.k.a extra carry.
 *       l1.length != l2.length;
 *       extra carry at the end.
 * 2. No need to creat a LinkedList to store a extra carry.
 *       we can simply use prev and count;
 *       futher, we can just use count, a.k.a carry.
 * 3. No need to use addFirst or addLast. Just simply use New keyword.


 */
        while(p1 != null||p2 != null){//Check if l1 or l2 is null;
            int digitres = 0;// Better: digitres = sum.
            if(p1 == null){ // Better :int x = (p! == null)? p.val:0;
                digitres = p2.val;
            }
            else if (p2 == null){
                digitres = p1.val;
            }
            else{
                digitres = p1.val+ p2.val;
            }

            // Check if the digitres > 10;
            if(digitres + prev > 9){
                digitres = digitres -10; // %10 seems better.
                count = 1 ;
            }
            else{
                count = 0;// %10 seems better.
            }

            p3.next = new ListNode(digitres + prev);
            p3 = p3.next;

            if(p1!=null) p1 = p1.next;// No need to use {}if there is only one statement.
            if(p2!=null) p2 = p2.next;
            prev = count;

        }
        // Add the final extra carry if it exists.
        if (prev != 0){
            p3.next = new ListNode(1);
        }
        return res.next;
    }

    public void printres(ListNode res) {
        ListNode p = res;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;

        }
    }
    public static void main (String[] args){
        addtwonums Launcher = new addtwonums();//this can not be a nested class.
        Launcher.start();
    }

    public void start(){
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(4);
        ListNode l2 = new ListNode(5);
        printres(addTwoNumbers(l1,l2));

    }
}



