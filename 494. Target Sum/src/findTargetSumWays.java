import java.util.LinkedList;
import java.util.List;

class A {

    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return
                sum < s || (s + sum) % 2 > 0 ?
                0 :  subsetSum(nums, (s + sum) >>> 1);
    }

    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n];
        return dp[s];
    }
    //The recursive solution is very slow, because its runtime is exponential.
/*
    int rst = 0; // int rst must be global.
    public int findTargetSumWays(int[] nums, int S) {
        rst = 0;
        if (nums.length == 0) return 0;
        helper(nums, S, 0, 0);
        return rst;
    }

    private void helper(int[] nums, int S, int sum, int i) {
        if (i == nums.length) {
            if (sum == S)
                rst++;
            return;
        }
        helper(nums, S, sum + nums[i], i + 1);
        helper(nums, S, sum - nums[i], i + 1);
    }
*/

    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        int S = 3;
        int[] nums = {1,1,1,1,1};
        System.out.println(findTargetSumWays(nums, S));

        int S1 = -1000;
        int[] nums1 = {1000};
        System.out.println(findTargetSumWays(nums1, S1));

        int S2 = -1000;
        int[] nums2 = {1000};
        System.out.println(findTargetSumWays(nums2, S1));
    }
}