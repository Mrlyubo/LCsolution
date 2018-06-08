import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

/**
 Key Point:
1. sort the array first;
2. bi-directional pointers;
3. skip the duplicates answers.  skip both in i, j, k;
4. res.add(Arrays.asList(int,int,int));
5. nums[i] must <= 0.
 */

class A {

    public List<List<Integer>> threeSum(int[] nums) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] > 0) continue; // this can save half of the time on average.
            int target = -nums[i];
            int j = i + 1;
            int k = nums.length-1;
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) { // nums[i] != nums[i+1] is not correct.
                while (j < k) {
                    if (nums[j] + nums[k] == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (j<k && nums[j] == nums[j + 1]) j++;// skip the duplicates BEFORE the iteration.
                        while (j<k && nums[k] == nums[k - 1]) k--;// skip the duplicates BEFORE the iteration.
                        j++;
                        k--;
                    } else if (nums[j] + nums[k] > target)
                        k--;
                    else
                        j++;
                }
            }
        } return res;
    }
    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        int[] nums = {-4,-1,-1,0,1,2}, nums1 = {0,0,0},nums2= {-2,0,1,1,2};
        System.out.println( threeSum(nums).toString());
        System.out.println( threeSum(nums1).toString());
        System.out.println( threeSum(nums2).toString());

    }
}
