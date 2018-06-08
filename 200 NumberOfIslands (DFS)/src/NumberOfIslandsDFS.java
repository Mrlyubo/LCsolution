/**
 * My previous idea is too complicated, Now try DFSmarkings.
 * It is my very beginning idea.
 * Question: where to store the marks?
 *
 */
class A {

    public int numIslands(char[][] grid) {
        int cnt = 0;
        for(int i = 0; i < grid.length; i++){
            for( int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    DFSMakings(grid,i,j); // once it traverse all the elements in an island, it returns;
                    cnt++ ;
                }
            }
        }
        return cnt;
    }

    public void DFSMakings(char[][] grid, int i, int j){ // if it is the boundary, it returns;
        if( i < 0 || j < 0 ||i>= grid.length|| j>=grid[i].length || grid[i][j] != '1')
            return;
        grid[i][j] = '0'; // mark as '0' after it is checked.

        DFSMakings(grid,i+1,j);
        DFSMakings(grid,i-1,j);
        DFSMakings(grid,i,j+1);
        DFSMakings(grid,i,j-1);
    }

    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        char[][] grid = new char[][]{{'1','1','0','1','1'},{'0','0','1','1','0'},{'0','1','1','0','1'}};
        System.out.println( numIslands(grid) );
    }
}