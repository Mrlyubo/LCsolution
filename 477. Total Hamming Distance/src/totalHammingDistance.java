class A {
    public int totalHammingDistance(int[] nums) {
        int[][] map = new int[2][30];
        int sum = 0;
        for(int num : nums ) {
            String s ;
            s = Integer.toBinaryString(num);
            int n = s.length();
            char[] cc = s.toCharArray();

            for(int i = 0; i < 30; i++){
                int c = i < n ? cc[n-i-1]-'0' : 0;
                if(i < 30 ) sum += map[1-c][i];
                map[c][i]++;
            }
        }
        return sum;
    }
    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        int[] nums = {4, 14, 2};
        System.out.println(totalHammingDistance(nums));
        int[] nums1 = {};
        System.out.println(totalHammingDistance(nums1));
    }
}