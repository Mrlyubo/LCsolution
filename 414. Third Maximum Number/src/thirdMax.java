import java.util.Arrays;

class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int max0 = nums[n-1];
        int cnt = 0, i = n-2, max = max0;
        while (cnt < 3 && i >= 0){
            if(nums[i] < max){
                cnt ++;
                max = nums[i];
            }
            if(cnt == 2)
                break;
            i--;
        }
        return cnt == 2 ? max : max0;

    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        System.out.println(thirdMax(new int[]{2,2,3,1}));
        System.out.println(thirdMax(new int[]{1,2}));
        System.out.println(thirdMax(new int[]{3, 2, 1}));
        System.out.println(thirdMax(new int[]{1,2,2,5,3,5}));
    }
}

