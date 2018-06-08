class A {
    public void sortColors(int[] nums) {
        int i, zero = 0 , second = nums.length-1;
        for(i = 0 ; i <= second; i++){
            while(nums[i] == 2 && i < second) {
                nums[i] = nums[second];
                nums[second--] = 2;
            }
            while(nums[i] == 0 && i > zero){
                nums[i] = nums[zero];
                nums[zero++] = 0;
            }
        }
    }
    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        int[] nums = {2,0,1};
        sortColors(nums);
        for(int num: nums)
            System.out.print(num);
    }
}