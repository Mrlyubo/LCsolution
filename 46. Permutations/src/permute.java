import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class A {
    //*****************************************************************
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> templist = new LinkedList<>();
        backtrack(list,templist,nums);
        return list;
    }

    public void backtrack( List<List<Integer>> list, List<Integer> templist, int[] nums){
        if( templist.size() == nums.length)
            list.add(new LinkedList(templist));
        else{
            for(int i = 0; i < nums.length  ; i++){
                if(templist.contains(nums[i])) continue;
                templist.add(nums[i]);
                backtrack(list, templist, nums);
                templist.remove(templist.size()-1);
            }
        }
    }
    //*****************************************************************
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums); // it is necessary. so when we have  [1(first),x,x] we can skip [ 1(second),x,x];
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;// for the later statement, when we have  [1(first),x,x] we can skip [ 1(second),x,x];
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    //*****************************************************************

/*    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(),nums, target, target,0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int target, int remain,int start) {
        if (remain == 0) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < nums.length; i++) {
                if(remain < 0) continue;
                tempList.add(nums[i]);
                remain = remain - nums[i];
                backtrack(list, tempList, nums, target, remain ,i);
                remain = remain + tempList.get(tempList.size()-1);
                tempList.remove(tempList.size() - 1);

            }
        }
    }*/
    //*****************************************************************

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack2(list, new ArrayList<>(),nums, target, target,0,new boolean[nums.length]);
        return list;
    }

    private void backtrack2(List<List<Integer>> list, List<Integer> tempList, int [] nums, int target, int remain,int start,boolean [] used) {
        if (remain == 0) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < nums.length; i++) {
                if(remain < 0) continue;
                if(used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                tempList.add(nums[i]);
                remain = remain - nums[i];
                used[i] = true;
                backtrack2(list, tempList, nums, target, remain ,i+1, used);
                remain = remain + tempList.get(tempList.size()-1);
                used[i]= false;
                tempList.remove(tempList.size() - 1);

            }
        }
    }
    //*****************************************************************

    public static void main(String[] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        //int[] nums = new int[]{1,1,3};
        //System.out.println(permuteUnique(nums));

        //int[] nums1 = new int[]{2,3,5};int target = 8;
        //System.out.println(combinationSum(nums1,target));

        int[] nums2 = new int[]{1,1,2,5,6,7,10};int target2 = 8;
        System.out.println(combinationSum2(nums2,target2));
    }
}