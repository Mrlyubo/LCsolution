import java.util.*;

public class optimalFlight {
    public List<int[]> optimalFlight (int maxDistance, List<int[]> fwd, List<int[]> rtn ) {
        //1. Collection sort the array Ascending with distance
        //2. Tow pointer to find the pairs'maxSum   <= maxDistance. Move pointer i if fwd[i-1]>rtn[i-1].
        //3. return the index of the pairs.

        //Actually, it is not necessary to sort the List ahead, just do it O(n^2).
        List<int[]> res = new ArrayList<>();

        Collections.sort(fwd, (a,b)->a[1]-b[1]);
        Collections.sort(rtn, (a,b)->a[1]-b[1]);

        int fLen = fwd.size();
        int rLen = rtn.size();


        int sum = -1;
        for( int i = fLen-1; i >= 0; i--) {
            for( int j = rLen-1; j >= 0; j--) {
                int fDist = fwd.get(i)[1];
                int rDist = rtn.get(j)[1];
                if(fDist + rDist <= maxDistance && fDist + rDist >= sum) {
                    if(res.size() == 0 || fDist + rDist == sum) {
                        res.add(new int[] {fwd.get(i)[0], rtn.get(j)[0]});
                        sum = fDist + rDist;
                    } else if ( fDist + rDist > sum) {
                        res.clear();
                        res.add(new int[] {fwd.get(i)[0], rtn.get(j)[0]});
                        sum = fDist + rDist; 
                    }
                }
            }
        }

        if(res.size() == 0) {
            for(int i = fLen - 1 ; i >= 0 ; i--) {
                if(fwd.get(i)[1] < maxDistance) {
                    res.add(new int[]{fwd.get(i)[0], -1});
                    break;
                }
            }
            for(int j = rLen - 1; j >= 0; j--) {
                if(fwd.get(j)[1] < maxDistance && fwd.get(j)[1] > res.get(0)[0]) {
                    res.clear();
                     res.add(new int[]{fwd.get(j)[0], -1});
                     break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        optimalFlight Launcher = new optimalFlight();
        Launcher.start();
    }

    public void start() {

/*        List<int[]> fwd = new ArrayList<>();
        fwd.add(new int[] {1,3000});
        fwd.add(new int[] {2,5000});
        fwd.add(new int[] {3,7000});
        fwd.add(new int[] {4,10000});
        List<int[]> rtn = new ArrayList<>();
        rtn.add(new int[] {2,2000});
        rtn.add(new int[] {1,3000});
        rtn.add(new int[] {3,4000});
        rtn.add(new int[] {4,5000});
        printListArray(optimalFlight(10000, fwd, rtn));*/

        List<int[]> fwd1 = new ArrayList<>();
        fwd1.add(new int[] {1,2000});
        fwd1.add(new int[] {2,4000});
        fwd1.add(new int[] {3,6000});
        List<int[]> rtn1 = new ArrayList<>();
        rtn1.add(new int[] {1,2000});
        printListArray(optimalFlight(7000, fwd1, rtn1));

        

    }

    public void printListArray(List<int[]> list) {
        System.out.print("{");
        for (int[] arr : list){
            System.out.print("[");
            for ( int i : arr) {
                System.out.print(i+",");
            }
            System.out.print("], ");
        }
        System.out.print("}");
    }
}
