class Solution  {
    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        int slow = 0, fast = 0, sum = 0;
        if(nums.length == 0 || nums == null)
            return 0;


        while (fast < nums.length) {
            sum += nums[fast++];
            while (sum >= s) {
                res = Math.min(res, fast - slow);
                sum -= nums[slow++];
            }
        }
/*
        while (sum < s && fast < nums.length) {
            sum += nums[fast];
            fast++;
        }
        if(sum >= s){
            res = Math.min(res, fast - slow);
        }
        while (sum-nums[slow] >= s && slow < fast){
            sum -= nums[slow++];
            res = Math.min(res, fast - slow);
        }


        while( slow < fast && fast < nums.length) {
            if(fast < nums.length)
                sum = sum + nums[fast++] - nums[slow++];
                //Don't move fast pointer and slow pointer at the same time.
            while (sum-nums[slow] >= s && slow < fast){
                sum -= nums[slow++];
                res = Math.min(res, fast - slow);
            }
        }
*/

        return res == Integer.MAX_VALUE ? 0 : res;
    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        System.out.println("2:"+minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
        System.out.println("0:"+minSubArrayLen(100,new int[]{}));
        System.out.println("0:"+minSubArrayLen(100,new int[]{1}));
        System.out.println("3:"+minSubArrayLen(11,new int[]{1,2,3,4,5}));
        System.out.println("5:"+minSubArrayLen(15,new int[]{1,2,3,4,5}));
    }
}

