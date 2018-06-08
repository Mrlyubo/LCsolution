import java.util.*;

class A {
    //***************************************
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack3(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack3(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates,when we have [1,2(first),x] ,skip [1,2(second),x],
            tempList.add(nums[i]);
            backtrack3(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
//***************************************************

    //Recursive Approach:
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }


    //My Approach: use stack to backtrace lists;
    public List<List<Integer>> subsets1(int[] nums) {
        LinkedList<LinkedList<Integer>> stack = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        res.add(new LinkedList<>());


        for(int i = 0; i < n; i++ ){
            stack.add(new LinkedList<>());
            stack.get(i).add(nums[i]);
            map.put(nums[i],i);
        }
        //backtrace
        while( !stack.isEmpty()){
            LinkedList<Integer> list = stack.peekFirst();
            for(int j = map.get(list.getLast())+1; j < n; j++){
                LinkedList<Integer> copy = (LinkedList<Integer>) list.clone();
                copy.add(nums[j]);
                stack.add(copy);
            }
            res.add(stack.removeFirst());
        }return res;

    }
    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
      /*  int[] nums = new int[]{1,2,3};
        int[] nums1 = new int[]{1,2,3,4};
        int[] nums2 = new int[]{};
        int[] nums3 = new int[]{1};*/



        /*System.out.println(subsets(nums));
        System.out.println(subsets(nums1));
        System.out.println(subsets(nums2));
        System.out.println(subsets(nums3));*/

        int[] nums4 = new int[]{1,2,2};
        System.out.println(subsetsWithDup(nums4));
    }
}