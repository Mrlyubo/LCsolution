class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        char[] chs = s.toCharArray();
        int[][] dp = new int[n][n];
        for(int i = n-1; i >= 0; i--){
            dp[i][i] = 1;
            for(int j = i+1; j < n; j++){
                if(chs[i] == chs[j])
                    dp[i][j] = dp[i+1][j-1] + 2;
                else
                    dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
            }
        }
        return dp[0][n-1];
    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        System.out.println("4:"+longestPalindromeSubseq("bbbab"));
        System.out.println("2:"+longestPalindromeSubseq("cbbd"));
    }
}

