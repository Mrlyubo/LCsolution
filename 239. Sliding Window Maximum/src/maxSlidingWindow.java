import java.util.HashSet;
import java.util.*;
import java.util.Set;

class Solution {

// 2ms
    public int[] maxSlidingWindow(int[] nums, int k) {

        if(k <= 0 || nums.length < k){
            return new int[0];
        }
        int [] ret = new int[nums.length - k + 1];
        for(int i = 0; i < ret.length; ++i){
            ret[i] = Integer.MIN_VALUE;
        }

        for(int i = 0; i < k; ++i){
            if(ret[0] < nums[i]){
                ret[0] = nums[i];
            }
        }

        for(int i = 1; i < ret.length; ++i){
            if(nums[i+k-1] > ret[i - 1]){
                ret[i] = nums[i+k-1];
            }
            else if(nums[i-1]<ret[i-1]){
                ret[i] = ret[i-1];
            }
            else{
                for(int j = i; j < i+k; ++j){
                    if(ret[i] < nums[j]){
                        ret[i] = nums[j];
                    }
                }
            }
        }
        return ret;
    }

//LinkedList of valid Index: 24ms
//DequeArray of valid Index: 22ms

    public int[] maxSlidingWindow2(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        // store index
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peekFirst() < i - k + 1) {
                q.removeFirst();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.removeLast();
            }
            // q contains index... r contains content
            q.addLast(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peekFirst()];
            }
        }
        return r;
    }

//*********************PriorityQueue: 70ms
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        if(n == 0) return nums;
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)->y-x);
        //Set<Integer> set = new HashSet<>();
        int[] res = new int[n-k+1];
        for(int j = 0; j < k; j++){
            pq.add(nums[j]);
            //set.add(nums[j]);
        }
        res[0] = pq.peek();
        for(int i = k; i < n; i++){
            int next = nums[i];
            int last = nums[i-k];
            pq.remove(last);
            pq.add(next);
            //pq.add(next);
            while(!pq.isEmpty()){
                int cur = pq.peek();
                if(pq.contains(cur)) {
                    res[i-k+1] = cur;
                    break;
                }
                else  pq.poll();
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        printArray(maxSlidingWindow(nums, 3));
        int[] nums2 = {};
        printArray(maxSlidingWindow(nums2, 0));

        int[] nums1 = {1,-1};
        printArray(maxSlidingWindow(nums1, 1));
    }
    public void printArray ( int[] array){
        System.out.print("[");
        for(int n: array)
            System.out.print(n+",");
        System.out.println("]");

    }
}

