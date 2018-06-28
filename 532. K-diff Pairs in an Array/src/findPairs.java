import java.util.Arrays;

class Solution { // 20ms ,beats 92.4%.
    public int findPairs(int[] nums, int k) {
        int cnt = 0;
        Arrays.sort(nums);
        int n = nums.length;
        if(n == 0) return 0;
        int s = 0, f = 1; //slow pointer and fast pointer.
        Integer prev = null;
        while (f < n && s < f){
            int diff = nums[f] - nums[s];//
            if( diff == k) {
                if(prev != null && nums[s] == prev){
                    f++;
                    continue;
                }
                cnt++;
                f++;
                prev = nums[s];
                s++;
            }
            else if (diff > k){
                s++;
                if(s == f)
                    f++;
            }
            else {
                f++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        int[] nums = {1,2,3};
        System.out.println("1:"+findPairs(nums, 2));

        int[] nums1 = {3, 1, 3, 1, 5};
        System.out.println("2:"+findPairs(nums1, 0));

        int[] nums2 = {3, 1, 4, 1, 5};
        System.out.println("2:"+findPairs(nums2, 2));

        int[] nums3 = {1,2,3,4,5};
        System.out.println("3:"+findPairs(nums3, 2));

        int[] nums5 = {1,1,1,1,1};
        System.out.println("1:"+findPairs(nums5, 0));
    }
}

