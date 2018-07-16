class Solution {

    //Using Math.
    public String optimalDivision1(int[] nums) {
        int n = nums.length;
        if(n == 0)
            return "";
        else if (n == 1)
            return nums[0]+"";
        else if (n == 2)
            return nums[0]+"/"+nums[1];
        else {
            StringBuilder sb = new StringBuilder(nums[0]+"/("+nums[1]);
            for (int i = 2; i < n; i++) {
                sb.append("/"+nums[i]);
            }
            sb.append(")");
            return sb.toString();
        }
    }

        //Approach #2 Using Memorization [Accepted]
        class T {
            float max_val, min_val;
            String min_str, max_str;
        }
        public String optimalDivision(int[] nums) {
            T[][] memo = new T[nums.length][nums.length];
            T t = optimal(nums, 0, nums.length - 1, "", memo);
            return t.max_str;
        }
        public T optimal(int[] nums, int start, int end, String res, T[][] memo) {
            if (memo[start][end] != null)
                return memo[start][end]; // if it has been computed, return.

            T t = new T();
            if (start == end) {
                t.max_val = nums[start];
                t.min_val = nums[start];
                t.min_str = "" + nums[start];
                t.max_str = "" + nums[start];
                memo[start][end] = t;
                return t;
            }
            t.min_val = Float.MAX_VALUE;// if it has not been computed, set it to default value.
            t.max_val = Float.MIN_VALUE;
            t.min_str = t.max_str = "";

            for (int i = start; i < end; i++) {
                T left = optimal(nums, start, i, "", memo);
                T right = optimal(nums, i + 1, end, "", memo);
                if (t.min_val > left.min_val / right.max_val) {
                    t.min_val = left.min_val / right.max_val;
                    t.min_str = left.min_str + "/" + (i + 1 != end ? "(" : "") + right.max_str + (i + 1 != end ? ")" : "");
                }
                if (t.max_val < left.max_val / right.min_val) {
                    t.max_val = left.max_val / right.min_val;
                    t.max_str = left.max_str + "/" + (i + 1 != end ? "(" : "") + right.min_str + (i + 1 != end ? ")" : "");
                }
            }
            memo[start][end] = t;
            return t;
        }

    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        int[] nums = {1000,100,10,5,2};
        System.out.println(optimalDivision(nums));
    }
}

