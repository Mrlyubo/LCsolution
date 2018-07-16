import java.util.*;
class Solution {
    public int countPrimeSetBits(int L, int R) {
        Set<Integer> primes = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19 /*, 23, 29 */ ));
        int cnt = 0;
        for (int i = L; i <= R; i++) {
            int bits = 0;
            for (int n = i; n > 0; n >>= 1) // n == n >> 1
                bits += n & 1;
                // n的最后一位二进制代码是否与1的最后一位二进制代码相同。相同，则 n & 1 = 1.
            cnt += primes.contains(bits) ? 1 : 0;
        }
        return cnt;
    }

    //**** int x=Integer.bitCount(i);  计算i的二进制代码中有多少1.

    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {

        System.out.println("5:"+countPrimeSetBits(10,15));
    }
}

