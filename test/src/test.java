import java.util.LinkedList;
import java.util.List;

class A {
    public List<Integer> list(int r, int c){
        List<Integer> list = new LinkedList<>();
        for(int i = 0; i < r; i++)
            for(int j = 0; j < c ; j++ )
                list.add(i * c + j);
        return list;
    }

    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        int r = 4, c = 3;
        System.out.println(list(r,c));
    }
}