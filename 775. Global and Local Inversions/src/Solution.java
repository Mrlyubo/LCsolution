class Solution {
    public boolean isIdealPermutation(int[] A) {
        int n = A.length;
        if(n == 1) return true;
        int[] dp = new int[n];
        dp[0] = dp[1] = Integer.MIN_VALUE;
        for(int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i-1], A[i-2]);
            if(A[i] < dp[i])
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        System.out.println("true:g=1,l=1::" + isIdealPermutation(new int[]{1,0,2}));
        System.out.println("false:g=2,l=1::" + isIdealPermutation(new int[]{1,2,0}));
        System.out.println("false:g=4,l=2::" + isIdealPermutation(new int[]{0,4,1,3,2}));
        System.out.println("true:g=0,l=0::" + isIdealPermutation(new int[]{0}));
    }
}

