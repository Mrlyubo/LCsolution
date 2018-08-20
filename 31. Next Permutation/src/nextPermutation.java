import java.util.*;

public class nextPermutation {

    public void nextPermutation(int[] nums) {
        //find a[i-1] < a[i] from the right
        int N = nums.length-1;
        int i = N;
        while (i > 0 && nums[i-1] >= nums[i]) {
            i--;
        }

        //find a smallest number that greater than nums[i-1],then swap nums[i-1] and nums[j]
        int j = i;
        if(j == 0){
            Arrays.sort(nums);
            return;
        }

        while (j < N && nums[j] > nums[i-1] ){
            j++;
        }
        if(nums[j]<= nums[i-1]){
            j--;
        }
        swap(i-1, j, nums);


        //reverse the array from index i to N.
        reverse(i, nums);
        return;
    }

    public void reverse (int start, int[] arr) {
        int e = arr.length-1;
        int s = start;
        while (s < e){
            swap(s, e, arr);
            s++;
            e--;
        }
    }

    public void swap (int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args) {
        nextPermutation Launcher = new nextPermutation();
        Launcher.start();
    }

    public void start() {
        int[] arr = {5,1,1};
        nextPermutation(arr);
        printarray(arr);

/*        int[] arr1 = {0,1,2,3,4};
        nextPermutation(arr1);
        printarray(arr1);*/
    }
    public void printarray (int[] A) {
        System.out.print("{");
        for(int i: A)
            System.out.print(i+",");
        System.out.println("}");
    }
}
