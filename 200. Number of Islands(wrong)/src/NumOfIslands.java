import java.util.HashSet;
import java.util.Set;

/**Idea:
 * Traverse the grid from west to east, north to south:
     * if it is land, then :
     *    if it has at least one land neighbors
     *    ( consider only north and west,no need to consider the south and east), then:
     *        if the land has one neighbor with coordinates, chase coordinates util the (i,j)==(x,y), a.k.a the root.
     *        if the land neighbor has no coordinates, set itself as root.
     *             and add the roots' coordinates to the root_set.
     *        if the land neighbor has two neighbors with coors, then:
     *             compare the size of neighbors' roots's size,
     *             union (this, neighbors with smaller size);
     *             union (this ,neighbors with bigger size);
     *  if is is not land , then: continue;
 *  return the size of set.
 */

class A {
    public class Coors{
        int x;
        int y;
        Coors(int x , int y){
            this.x=x;
            this.y=y;
        }
    }

    Set<Coors> rootset = new HashSet<>();
    public int numIslands(char[][] grid) {
        Coors[][] coors = new Coors[grid.length][grid[0].length];
        for( int i = 0; i < grid.length; i++ ){
            for( int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'&& j > 0 ){// isLand
                        if( grid[i][j-1] == '1'){
                            if(coors[i][j-1] != null)
                                union(coors,i,j,i,j-1);
                            else
                                rootset.add(new Coors(i,j));
                        }
                        if( i>0 && grid[i-1][j] == '1')
                            if(coors[i-1][j] != null)
                                union(coors,i,j,i-1,j);
                            else
                                rootset.add(new Coors(i,j));
                        else if( i == 0)
                            rootset.add(new Coors(i,j));
                    }
                else if (j == 0){
                    coors[i][j] = new Coors(i,j);
                    rootset.add(new Coors(i,j));
                }
                else { // is not Land.
                    continue;
                }
            }
        }
        return rootset.size();
    }

    public void union(Coors[][] coors, int A,int B, int C, int D){ // set roots equal.
        Coors curr = root(coors,A,B);
        Coors prev = root(coors,C,D);
        curr.x = prev.x;
        curr.y = prev.y;
    }
    public  Coors root(Coors coors[][],int i,int j){// find the root.
        if(coors[i][j] == null) coors[i][j] = new Coors(i,j);
        while(coors[i][j].x != i || coors[i][j].y != j){
            i = coors[i][j].x;
            j = coors[i][j].y;
        }
        rootset.add(coors[i][j]);
        return coors[i][j];
    }
    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void printarry(char[][] arr){
        for(char[] arr1: arr) {
            System.out.print("[");
            for (char arr2 : arr1)
                System.out.print(arr2 + ",");
            System.out.println("]");
        }
    }

    public void start(){
        char[][] gird = new char[][]{{'1','1','0','1','1'},{'0','0','1','1','0'},{'0','1','1','0','1'}};
        System.out.println( numIslands(gird) );
    }
}