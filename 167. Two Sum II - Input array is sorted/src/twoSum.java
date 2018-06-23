class Solution {
    //two pointers
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int sum = 0;
        int i = 0, j = numbers.length-1;
        while (i < j){
            sum = numbers[i]+numbers[j];
            if(sum == target) {
                res[0] = i+1;
                res[1] = j+1;
                break;
            }
            else if(sum < target){
                i++;
            }
            else {
                j--;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        int[] numbers = {2,7,11,15};
        System.out.println(twoSum(numbers, 9));
    }
}

