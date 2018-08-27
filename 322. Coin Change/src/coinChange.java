import java.util.*;

public class coinChange {

    public int coinChange(int[] coins, int amount) {
        if(coins == null)
            return 0;

        long[] dp = new long[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0; i<coins.length; i++){
            for(int amt=1; amt<dp.length; amt++){
                if(amt-coins[i]>=0)
                    dp[amt] = Math.min(dp[amt],dp[amt-coins[i]]+1);
                System.out.println("i = "+ i + ",amt = " + amt);
                printarray(dp);
            }

            printarray(dp);
            System.out.println("==============================");
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : (int) dp[amount];
    }

    public static void main(String[] args) {
        coinChange Launcher = new coinChange();
        Launcher.start();
    }

    public void start() {
        int[] coins = {1,2,5}; int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

    public void printarray (long[] A) {
        System.out.print("{");
        for(long i: A)
            System.out.print(i+",");
        System.out.println("}");
    }
}
