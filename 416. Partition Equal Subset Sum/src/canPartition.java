class A {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n: nums)
            sum += n;
        return sum%2 != 0 ? false : cansplit(nums, sum/2);
    }
    private boolean cansplit( int[] nums, int Sum ){
        int[] dp = new int[Sum+1];
        dp[0] = 1;
        for(int n: nums)
            for(int i = Sum; i >= n; i--)
                dp[i] += dp[i - n];
        return dp[Sum] > 0;
    }
    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        Strin
        System.out.println(canPartition(nums));
    }
}