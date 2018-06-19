class Solution {

    //Follow up:
    //Could you do it in O(n) time and O(1) space?
    /**
     * 1. Traverse the ListNode and get the Length. Length/2 is the center.  ***************************n times.
     * 2. Traverse to the center, back_pointer = center_index - 1, front_pointer = center_index + 1;****n/2 times.
     * 3. Reverse the link from back_pointer to the beginning.********** n/2 times.
     * 4. Traverse from back_pointer to beginning and traverse from front_pointer to the end. ********** n times.
     * 5. Time Complexity : 3n -> O(n). Space Complexity : O(n).( Without creating a new ListNode )
     * 6. Example:[1, 1, 2, 1]:
     *
     * In the beginning, set two pointers fast and slow starting at the head.
     *
     * 1 -> 1 -> 2 -> 1 -> null
     * sf
     * (1) Move: fast pointer goes to the end, and slow goes to the middle.
     *
     * 1 -> 1 -> 2 -> 1 -> null
     *           s          f
     * (2) Reverse: the right half is reversed, and slow pointer becomes the 2nd head.
     *
     * 1 -> 1    null <- 2 <- 1
     * h                      s
     * (3) Compare: run the two pointers head and slow together and compare.
     *
     * 1 -> 1    null <- 2 <- 1
     *      h            s
     * */

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        //Move: fast pointer goes to the end, and slow goes to the middle.
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the 2nd half, and slow pointer becomes the 2nd head.
        ListNode newhead = null;
        while (slow != null){
            ListNode next = slow.next;
            slow.next = newhead;
            newhead = slow;
            slow = next;
        }
        // Compare: run the two pointers head and slow together and compare.
        ListNode p = head;
        ListNode bp = newhead;
        while ( p != null && bp != null){
            if( p.val == bp.val){
                p = p.next;
                bp = bp.next;
            }
            else
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {

        ListNode l0 = new ListNode(1);
        System.out.println(isPalindrome(l0));

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        System.out.println(isPalindrome(l1));

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(2);
        l3.next.next = new ListNode(2);
        System.out.println(isPalindrome(l3));

        ListNode l4 = new ListNode(1);
        l4.next = new ListNode(2);
        l4.next.next = new ListNode(1);
        System.out.println(isPalindrome(l4));

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(2);
        l2.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(l2));
    }

    public void printListNode(ListNode node){
        ListNode p = node;
        while (p != null){
            System.out.println(p.val);
            p = p.next;
        }
    }
}

