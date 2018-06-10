
class A {
    public int[] moveZeroes(int[] nums) {

        if (nums == null || nums.length == 0)
            return nums;

        int insertPos = 0;
        for (int num : nums) {
            if (num != 0)
                nums[insertPos++] = num; //insert from nums[0].
        }

        while (insertPos < nums.length) {// insert all elements, set all remain elements equals zero.
            nums[insertPos++] = 0;
        }
        return nums;

    }
    public int[] moveZeroes1(int[] nums) {
        int cnt = 1;
        for(int i = 0 ; i < nums.length; i++) {
            if (nums[i] != 0){
                for (int k = i; k>= cnt ; k--) {
                    nums[k - 1] = nums[k];
                    nums[k] = 0;
                }
                cnt++;
            }
        }
        return nums;
    }


    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        int[] nums = {0,1,0,3,12};
        int[] nums1 = {};
        int[] nums2 = {1,0};
        int[] nums3 = {1,2,3,4,5,0,0,0,0,0};
        int[] nums4 = {0,0,0,1,2,3};
        int[] nums5 = {0,1,0,2,0,3,0,4,0,5};
        int[] nums6 = {0,0,0,0,0,2,0,0,0,3};
        for(int i : moveZeroes(nums))
            System.out.print( i+" " );
    }
}