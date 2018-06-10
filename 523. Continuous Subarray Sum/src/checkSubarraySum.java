import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class A {

    // My approach : too slow, use HashMap next time.
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        boolean flag = false;
        if(n < 2) return false;
        if(k == 0) {
            for (int i = 0; i< n-1 ;i++) {
                if( nums[i]==0 && nums[i+1]==0)
                    flag = true;
            }
            return flag;
        }
        Set<Integer> set = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        int f = nums[0]%k;
        stack.add(f);
        for( int i = 1; i < n; i++){
            int r = nums[i]%k;
            while (!stack.isEmpty()){
                set.add((stack.pop()+r)%k);
            }
            if(i>1)set.add((nums[i-1]%k+r)%k);
            if(set.contains(0)){
                flag = true;
                break;
            }
            for(int e: set) stack.add(e);
            set.clear();
        }
        return flag;
    }
    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        /*int[] nums ={23, 2, 4, 6, 7};  int k=6;
        System.out.println("true:"+checkSubarraySum(nums,k));

        int[] nums1 ={23, 2, 6, 4, 7};  int k1=6;
        System.out.println("true:"+checkSubarraySum(nums1,k1));

        int[] nums2 ={0,1,0};  int k2=0;
        System.out.println("flase:"+checkSubarraySum(nums2,k2));

        int[] nums3 ={23, 2, 6, 4, 7};  int k3=0;
        System.out.println("false:"+checkSubarraySum(nums3,k3));*/

        int[] nums4 ={1,2,3};  int k4=5;
        System.out.println("true:"+checkSubarraySum(nums4,k4));
    }
}