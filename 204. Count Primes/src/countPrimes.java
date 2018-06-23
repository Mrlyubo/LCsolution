class Solution {
    //Fast Solution: 11ms
/*    publib int countPrimes(int n) {
        if (n < 3)
            return 0;

        boolean[] f = new boolean[n];
        //Arrays.fill(f, true); boolean[] are initialed as false by default
        int count = n / 2;
        for (int i = 3; i * i < n; i += 2) {
            if (f[i])
                continue;

            for (int j = i * i; j < n; j += 2 * i) {
                if (!f[j]) {
                    --count;
                    f[j] = true;
                }
            }
        }
        return count;
    }*/
            /**
             * Count the number of prime numbers less than a non-negative number, n
             * @param n a non-negative integer
             * @return the number of primes less than n
             */

            // 逆向思维： 小于n的质数 = 小于n的奇数 - 这些奇数中的复合数（composite odd）。
            // 这些奇数中的复合数：j = i*i+ a*i (a为偶数).
            // 初始count = 小于n的奇数，
            // 标记复合数奇数为 True. 遇到复合奇数则continue;
            public int countPrimes(int n) {

                /**
                 * if n = 2, the prime 2 is not less than n,
                 * so there are no primes less than n
                 */
                if (n < 3) return 0;

                /**
                 * Start with the assumption that half the numbers below n are
                 * prime candidates, since we know that half of them are even,
                 * and so _in general_ aren't prime.
                 *
                 * An exception to this is 2, which is the only even prime.
                 * But also 1 is an odd which isn't prime.
                 * These two exceptions (a prime even and a for-sure not-prime odd)
                 * cancel each other out for n > 2, so our assumption holds.
                 *
                 * We'll decrement count when we find an odd which isn't prime.
                 *
                 * If n = 3,  c = 1.
                 * If n = 5,  c = 2.
                 * If n = 10, c = 5.
                 */
                int c = n / 2;

                /**
                 * Java initializes boolean arrays to {false}.
                 * In this method, we'll use truth to mark _composite_ numbers.
                 *
                 * This is the Opposite of most Sieve of Eratosthenes methods,
                 *  which use truth to mark _prime_ numbers.
                 *
                 * We will _NOT_ mark evens as composite, even though they are.
                 * This is because `c` is current after each `i` iteration below.
                 */
                boolean[] s = new boolean[n];

                /**
                 * Starting with an odd prime-candidate above 2, increment by two
                 * to skip evens (which we know are not prime candidates).
                 */
                for (int i = 3; i * i < n; i += 2) {
                    if (s[i]) {
                        // c has already been decremented for this composite odd
                        continue;
                    }

                    /**
                     * For each prime i, iterate through the odd composites
                     * we know we can form from i, and mark them as composite
                     * if not already marked.
                     *
                     * We know that i * i is composite.
                     * We also know that i * i + i is composite, since they share
                     * a common factor of i.
                     * Thus, we also know that i * i + a*i is composite for all real a,
                     * since they share a common factor of i.
                     *
                     * Note, though, that i * i + i _must_ be composite for an
                     * independent reason: it must be even.
                     * (all i are odd, thus all i*i are odd,
                     * thus all (odd + odd) are even).
                     *
                     * Recall that, by initializing c to n/2, we already accounted for
                     * all of the evens less than n being composite, and so marking
                     * i * i + (odd)*i as composite is needless bookkeeping.
                     *
                     * So, we can skip checking i * i + a*i for all odd a,
                     * and just increment j by even multiples of i,
                     * since all (odd + even) are odd.
                     */
                    for (int j = i * i; j < n; j += 2 * i) {
                        if (!s[j]) {
                            c--;
                            s[j] = true;
                        }
                    }
                }
                return c;
            }

    // Easy Solution:101ms
    public int countPrimes1(int n) {
        boolean[] notPrime = new boolean[n];
        int cnt = 0;
        for(int i = 2; i < n; i++){
            if(notPrime[i] == false)
                cnt++;
            for(int j = 2; i*j < n; j++){
                notPrime[i*j] = true;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {

        System.out.println(countPrimes(10));
    }
}

