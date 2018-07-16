class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(n == 0) return;
        k = k % n;
        if ( k == 0) return;
/**
public void rotate(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
}

public void reverse(int[] nums, int start, int end) {
    while (start < end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }
}
*/
        int cnt = 0, next, prev;
        int start = 0;
        while (cnt < n){
            prev = nums[n-k+start];
            for (int i = start; cnt <= n; i += k){
                if(i >= n){
                    i -= n;
                    if(i == start) break;
                }
                next = nums[i];
                nums[i] = prev;
                prev = next;
                cnt++;
                //System.out.print("i:"+i+",next:"+next+",cnt:"+cnt+"  ");
                //printArray(nums);
            }
            start++;
            if(cnt == n) break;
        }
    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums,2);
        printArray(nums);

        int[] nums3 = {1,2,3,4,5,6};
        rotate(nums3,5);
        printArray(nums3);

        int[] nums1 = {};
        rotate(nums1,7);
        printArray(nums1);

        int[] nums4 = {1};
        rotate(nums4,0);
        printArray(nums4);

        int[] nums5 = {1};
        rotate(nums5,1);
        printArray(nums5);

        int[] nums6 = {1,2};
        rotate(nums6,2);
        printArray(nums6);

       int[] nums2 = {2,3};
        rotate(nums2,3);
        printArray(nums2);
    }
    public void printArray ( int[] array){
        System.out.print("[");
        for(int n: array)
            System.out.print(n+",");
        System.out.println("]");
    }
}

