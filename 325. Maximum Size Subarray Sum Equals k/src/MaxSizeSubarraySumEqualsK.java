import java.util.*;

class A {
    //At first, I do not notice that it my be the SUBARRAYS.
    //Selecting random elements it the array is not the case.
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0, max = 0;
        for(int i = 0; i < nums.length; i++){
            sum = sum +nums[i];
            if(sum == k) max = i+1;
            else if (map.containsKey(sum-k)) max = Math.max(max,i-map.get(sum-k));
            if(!map.containsKey(sum)) map.put(sum,i);

        }
        return max;
    }
    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        int[] nums = new int[]{1,2,3};
        int k = 1;
        System.out.println( maxSubArrayLen(nums,k) );
    }
}