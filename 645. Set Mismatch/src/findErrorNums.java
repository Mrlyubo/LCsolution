import java.util.Arrays;

class Solution {
    public int[] findErrorNums(int[] nums) {//
        // 以空间换时间，27ms. 如果不限制O(1) Space，可以7ms。
        int[] res = new int[2];
        Arrays.sort(nums);
        int n = nums.length;
        if(nums[0] != 1) res[1] = 1;
        int prev = nums[0];
        for(int i = 1; i < n; i++){
            if(nums[i] == prev)
                res[0] = prev;
            if(res[1] == 0 && nums[i]-prev == 2)
                res[1] = prev+1;
            prev = nums[i];
        }
        if(res[1] == 0)
            res[1] = n;
        return res;
    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        int[] nums = {3,2,3,4,6,5};
        printArray(findErrorNums(nums));

        int[] nums2 = {4,2,2,1};
        printArray(findErrorNums(nums2));

        int[] nums1 = {1,5,3,2,2,7,6,4,8,9};
        printArray(findErrorNums(nums1));
    }
    public void printArray ( int[] array){
        System.out.print("[");
        for(int n: array)
            System.out.print(n+",");
        System.out.println("]");
    }
}

