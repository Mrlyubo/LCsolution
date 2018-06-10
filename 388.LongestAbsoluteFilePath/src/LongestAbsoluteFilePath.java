import java.util.Deque;
import java.util.ArrayDeque;

/**
 * At my first glace, it should use tree to search, it works.
 * However, the input is not in the tree shape. We need to iterate
 * the String input to split it and store the length information in a String LenInfo[level][length],
 * and then LenInfo[i][j] = max LenInfo[i+1][j] + LenInfo[i][j].
 * then return LenInfo[0][0].
 * However, it is hard to detemine the j.
 * Maybe there is a way to organize this input like a tree. and then searh the tree in some way.
 *
 */
class A {
     public int lengthLongestPath(String input) {
         Deque<Integer> stack = new ArrayDeque<>();//Last in Last out , push() ,pop().
         stack.push(0);// push() and add(), both will do. push() is better for readability.
         int maxLen = 0;
         for(String s: input.split("\n")){
             int lev = s.lastIndexOf("\t")+1;// if cannot find ,return -1;
             while(lev + 1 < stack.size()) stack.pop();
             int len = stack.peek() +s.length()-lev+1;
             stack.push(len);
             if(s.contains(".")) maxLen = Math.max(maxLen, len-1);
         } return maxLen;
         /**Deque<Integer> stack = new ArrayDeque<>();//store the currMaxLen.
         stack.push(0); // "dummy" length
         int maxLen = 0;
         for(String s:input.split("\n")){ //
             int lev = s.lastIndexOf("\t")+1; // number of "\t"
             while(lev+1 < stack.size()) stack.pop(); // find parent
             int len = stack.peek()+s.length()-lev+1; // remove "/t", add"/"
             stack.push(len);
             // check if it is file
             if(s.contains(".")) maxLen = Math.max(maxLen, len-1);
         }
         return maxLen;*/
     }
    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        String s = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        System.out.print(lengthLongestPath(s));
    }
}
