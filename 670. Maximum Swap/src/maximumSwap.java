import java.util.ArrayList;
import java.util.List;

class A {

    /**
     * Use buckets to record the last position of digit 0 ~ 9 in this num.
     * Loop through the num array from left to right. For each position,
     * we check whether there exists a larger digit in this num (start from 9 to current digit).
     * We also need to make sure the position of this larger digit is behind the current one.
     * If we find it, simply swap these two digits and return the result.
     *
     */
    public int maximumSwap(int num) {
        List<Integer> list = new ArrayList<>();

        while( num > 0){ // add every num into a list.
            list.add(0,num%10);
            num = num/10;
        }

        int n = list.size();
        int[] arr = new int[n];
        int[] idx = new int[n];
        arr[n-1] = list.get(n-1);
        idx[n-1] = n-1;
        for(int i = n-2; i >= 0; i--) { // DP: find the max num after index.
            int curr = list.get(i);
            if(curr >arr[i+1]){
                arr[i] = curr;
                idx[i] = i;
            }else {
                arr[i] = arr[i + 1];
                idx[i] = idx[i + 1];
            }
        }

        for(int i = 0; i < n; i++){// Swap the number.
            if( list.get(i) < arr[i]){

                list.remove(idx[i]);
                list.add(idx[i],list.get(i));

                list.remove(i);
                list.add(i,arr[i]);

                break;
            }
        }

        int sum = 0; // build the number.
        for(int i = 0; i < n ; i++)
            sum = sum*10+list.remove(0);
        return sum;
    }
    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        int num = 2736;
        System.out.println("7236:"+maximumSwap(num));

        int num1 = 123;
        System.out.println("321:"+maximumSwap(num1));

        int num2 = 321;
        System.out.println("321:"+maximumSwap(num2));

        int num4 = 1444;
        System.out.println("4441:"+maximumSwap(num4));

        int num3 = 4141;
        System.out.println("4411:"+ maximumSwap(num3));

        int num5 = 10;
        System.out.println("10:"+ maximumSwap(num5));

    }
}