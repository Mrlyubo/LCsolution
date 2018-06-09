class A {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n: nums)
            sum += n;
        System.out.println ("sum % 2 =" + sum%2);
        return
                sum%2 != 0 ?
                false :
                cansplit(nums, sum/2);
    }
    private boolean cansplit( int[] nums, int Sum ){
        long[] dp = new long[Sum+1];
        dp[0] = 1;
        for(int n: nums)
            for(int i = Sum; i >= n; i--)
                dp[i] += dp[i - n];
        System.out.println(dp[Sum]);
        return
                dp[Sum] != 0; // Don't use dp[Sum] >0 , it may cause int overflow.
    }
    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        int[] nums ={100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
                     100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
                     100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
                     100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100};
        System.out.println(canPartition(nums));

        int[] nums1 ={100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
                      100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100};
        System.out.println(canPartition(nums1));
    }
}