import java.util.Random;

class Solution {

        int[] nums;
        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int pick(int target) {
            int index = -1;
            int count = 1;
            Random random = new Random();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    if (random.nextInt(count++) == 0) {//with possibility == 1 / cnt;
                        index = i;
                    }
                }
            }
            return index;
        }

    public static void main(String [] args){
        int[] nums = {1,2,3,3,3};
        Solution obj = new Solution(nums);
        System.out.print(obj.pick(3)+",");
        System.out.print(obj.pick(1)+",");
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */