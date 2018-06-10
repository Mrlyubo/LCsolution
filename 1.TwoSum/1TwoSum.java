package java_study;


import java.util.Map;
import java.util.HashMap;

class 1TwoSum {
	//answer start
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums == null||nums.length<2){
            res = new int[]{0,0};
            return res;
        }
        Map<Integer,Integer> prevseen = new HashMap<>();
        for(int i = 0; i < nums.length; i += 1){
            //prevseen.put(nums[i],i); Cannot put this line before if ,it will fail when nums={3,3,6}
            if(prevseen.containsKey(target-nums[i])){
                res[0] = prevseen.get(target-nums[i]);
                res[1] =i ;
            }
            prevseen.put(nums[i],i);//
        }
        return res;

    }//answer end. 
	
	public void printres(int[] res){
        for(int i:res){
            System.out.println(i);
        }
    }

	public static void main(String[] args){
            TwoSum Launcher= new TwoSum();
            Launcher.start();
        }
	public void start(){
            int[] test = new int[]{3,3,6};
            int target = 6;
            printres(twoSum(test,target));

        }



}
/**
 * 1. Launcher.start() needed, or you cannot access method twoSum because it is not instantiated;
 * 2. Using Set is not a very easy choice, because it cannot getValue using get(key) method;
 * 3. "prevseen.put(nums[i],i);" Cannot put this line before if ,it will fail when nums={3,3,6};
 * 4. Using Map like Map(Key,Value)=Map(num[i],index of num[])，because the resuls we need is index,
 *    we put index in the Value Position.
 */   


