class A {
    /**
     * do BST to find the  pivot and then do BST search to find the target.
     */
    public int search(int[] nums, int target) {
        // find the pivot position;
        int n = nums.length;
        if( n == 0)return -1;
        if( n == 1){
            if(nums[0] == target) return 0;
            else return -1;
        }
        int min = 0, max = n-1;
        int i = min + (max-min)/2;
        while(nums[i]<nums[i+1] && min < max-1){
            if(nums[i]>nums[min])
                min = i;//pivot in the right hand of i
            else if(nums[i]<nums[max])
                max = i;//pivot in the left hand of i
            i = min + (max-min)/2;
        }
        if(nums[i] < nums[i+1]) i = max;



        if(nums[0] <= target ){// target in the left hand of pivot
            min = 0;
            max = i;
        }
        else if(nums[n-1] >= target && i != n-1 ) { //target int hte right hand of pivot
            min = i+1;
            max = n-1;
        }


        //find the index of target;
        i = min +(max-min)/2;
        int res = -1;
        if(nums[min] == target ) res = min;
        else if(nums[max] == target) res = max;
        else if(nums[i] == target) res = i;
        while ( nums[i] != target && min < max-1){
            if(nums[i] > target) max = i;
            else min = i;
            i = min + (max-min)/2;
            if(nums[i] == target)
                res = i;
            else
                continue;
        }
        return res;

    }
    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        int[] nums = {4,5,6,7,1,2};
        int target = 4;
        System.out.println("0:"+search(nums,target));

        int target1 = 5;
        System.out.println("1:"+search(nums,target1));

        int target2 = 6;
        System.out.println("2:"+search(nums,target2));

        int target3 = 7;
        System.out.println("3:"+search(nums,target3));

        int[] nums5 = {4,5,6,7,1,2};
        int target5 = 1;
        System.out.println("4:"+search(nums5,target5));

        int target7 = 2;
        System.out.println("5:"+search(nums,target7));

        int target8 = 3;
        System.out.println("-1:"+search(nums,target8));

        int[] nums11 = {3,1};
        int target11 = 0;
        System.out.println("-1:"+search(nums11,target11));

        int[] nums12 = {3,1};
        int target12 = 3;
        System.out.println("0:"+search(nums12,target12));

        int[] nums13 = {3,1};
        int target13 = 1;
        System.out.println("1:"+search(nums13,target13));

        int[] nums9 = {1};
        int target9 = 0;
        System.out.println("-1:"+search(nums9,target9));

        int[] nums10 = {1,3};
        int target10 = 3;
        System.out.println("1:"+search(nums10,target10));

        int[] nums15 = {1,2,3};
        int target15 = 3;
        System.out.println("2:"+search(nums15,target15));

        int target16 = 1;
        System.out.println("0:"+search(nums15,target16));



        int[] nums19 = {5,1,3};
        int target19 = 3;
        System.out.println("2:"+search(nums19,target19));

        int[] nums17 = {1,2,3};
        int target17 = 0, target18 = 4;
        System.out.println("-1:"+search(nums17,target17));
        System.out.println("-1:"+search(nums17,target18));
    }
}