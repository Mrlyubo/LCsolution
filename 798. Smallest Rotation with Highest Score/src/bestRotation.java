public class bestRotation {
    public int bestRotation(int[] A) {
        int N = A.length;
        int change[] = new int[N];
        for (int i = 0; i < N; ++i)
            change[(i - A[i] + 1 + N) % N] -= 1;
        //printarray(change);
        int max_i = 0;
        for (int i = 1; i < N; ++i) {
            change[i] += change[i - 1] + 1;//index 0 -> index N-1, increase 1.
            max_i = change[i] > change[max_i] ? i : max_i;
        }
        return max_i;
    }
    public static void main(String [] args){
        bestRotation Launcher = new bestRotation();
        Launcher.start();
    }
    public void start(){
        System.out.println(bestRotation(new int[] {2,3,1,4,0}));
        System.out.println(bestRotation(new int[] {1,3,0,2,4}));
    }
    public void printarray (int[] A) {
        System.out.print("{");
        for(int i: A)
            System.out.print(i+",");
        System.out.println("}");
    }
}

