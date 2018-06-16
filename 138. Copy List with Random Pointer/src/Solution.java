
class Solution {
    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        // First round: make copy of each node,
        // and link them together side-by-side in a single list.
        RandomListNode p = head,  next;
        while(p != null){
            RandomListNode clone = new RandomListNode(p.label);
            next = p.next;
            p.next = clone;
            clone.next = next;
            p = next;
        }

        // Second round: assign random pointers for the copy nodes.
        p = head;
        while(p != null){
            if (p.random != null)///
                p.next.random = p.random.next;
            p = p.next.next;
        }

        // Third round: restore the original list, and extract the copy list.
        RandomListNode clonehead = new RandomListNode(0);
        RandomListNode cp = clonehead;
        p = head;
        while ( p != null){ // use next to anchor the next node.
            next = p.next.next;
            cp.next = p.next;
            p.next = next;
            p = p.next;
            cp = cp.next;
        }
        return clonehead.next;
    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {

        RandomListNode head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);
        head.random = head.next.next;
        head.next.random = head.next.next;
        head.next.next.random = head.next;
        copyRandomList(head);
    }
}

