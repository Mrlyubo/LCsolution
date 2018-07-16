class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //if(cost.length == 2)
            //return Math.min(cost[0], cost[1]);
        int[] dp = new int[cost.length];
        dp[0] = cost[0]; dp[1] = cost[1];
        for(int i = 2; i < cost.length; i++){
            dp[i] = cost[i] + Math.min(dp[i-1],dp[i-2]);
        }
        return Math.min(dp[cost.length-1],dp[cost.length-2]);
    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        System.out.println("6:"+minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        System.out.println("1:"+minCostClimbingStairs(new int[]{1, 100}));
        System.out.println("0:"+minCostClimbingStairs(new int[]{0,0,0,1}));
    }
}

