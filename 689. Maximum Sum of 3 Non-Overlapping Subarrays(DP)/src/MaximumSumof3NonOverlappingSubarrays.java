
class A {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] res = new int[3];
        int n = nums.length;

        //compute the sum[], maxleft/maxright = sum[i]-sum[i-k],
        int sum[] = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++)
            sum[i] = sum[i - 1] + nums[i];

        //DP to find the maxleftindex[i],where i is the startindex of left interval;
        //iterate from left to right;
        int len = n - 3 * k + 1;
        int[] maxleftindex = new int[len];
        maxleftindex[0] = 0;
        int maxleft = sum[k - 1];
        for (int i = 1; i <= n - 3 * k; i++) {
            int currleft = sum[i + k - 1] - sum[i - 1];
            if (currleft > maxleft) {
                maxleftindex[i] = i;
                maxleft = currleft;
            } else maxleftindex[i] = maxleftindex[i - 1];
        }

        //DP to find the maxrightindex[i],where i is the endindex of right interval;
        //interate from right to left.
        int[] maxrightindex = new int[len];
        maxrightindex[len - 1] = n - k;
        int maxright = sum[n - 1] - sum[n - 1 - k];
        for (int i = n - k - 1; i >= 2 * k; i--) {
            int currright = sum[i + k - 1] - sum[i - 1];
            if (currright > maxright) {
                maxrightindex[i - 2 * k] = i;
                maxright = currright;
            } else maxrightindex[i - 2 * k] = maxrightindex[i - 2 * k + 1];
        }

        //middle
        int triplets = 0;
        for (int i = k; i <= n - 2 * k; i++) {
            int l = maxleftindex[i - k];
            int r = maxrightindex[i - k];
            int lsum = (l > 0) ? sum[l - 1 + k] - sum[l - 1] : sum[l - 1 + k];
            int rsum = (r > 0) ? sum[r - 1 + k] - sum[r - 1] : sum[r - 1 + k];
            int currtriplets = sum[i - 1 + k] - sum[i - 1] + lsum + rsum;
            if (currtriplets > triplets) {
                triplets = currtriplets;
                res[0] = l;
                res[1] = i;
                res[2] = r;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        A Launcher = new A();
        Launcher.start();
    }

    public void start() {
        int[] nums = {1, 2, 1, 2, 6, 7, 5, 1}, nums2 = {7, 13, 20, 19, 19, 2, 10, 1, 1, 19}, nums3 = {20, 18, 9, 2, 14, 1, 10, 3, 11, 18};
        int k = 2, k2 = 3, k3 = 3;

        for (int i : maxSumOfThreeSubarrays(nums, k)) {
            System.out.print(i + ",");
        }
        System.out.println(" ");
        for (int i : maxSumOfThreeSubarrays(nums2, k2)) {
            System.out.print(i + ",");
        }
        System.out.println(" ");
        for (int i : maxSumOfThreeSubarrays(nums3, k3)) {
            System.out.print(i + ",");
        }
        System.out.println(" ");
    }
}
