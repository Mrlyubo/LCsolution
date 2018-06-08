class A {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        int[] front = new int[n];
        int[] back = new int[n];
        front[0] = nums[0];
        for(int i = 1; i< n; i++)
            front[i] = nums[i]*front[i-1];
        back[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--)
            back[i] = nums[i]*back[i+1];
        int front_product, back_product;
        for(int i = 0; i < n; i++ ){
            front_product = i!=0 ? front[i-1]: 1;
            back_product = i!= n-1 ? back[i+1]:1;
            output[i] = front_product*back_product;
        }
        return output;
    }
    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void print(int[] nums ){
        for(int num: nums)
            System.out.print(num+",");
    }

    public void start(){
        int[] nums = new int[]{1,2,3,4};
        print(productExceptSelf(nums));
    }
}