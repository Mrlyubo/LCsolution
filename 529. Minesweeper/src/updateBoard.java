class Solution {

    int[] xx = {0,0,1,-1,1,1,-1,-1};
    int[] yy = {1,-1,0,0,1,-1,1,-1};
    public char[][] updateBoard(char[][] board, int[] click) {
        int rr = click[0], cc = click[1];
        if(board[rr][cc] == 'M'){
            board[rr][cc] = 'X';
            return board;
        }
        dfs(board, rr, cc);
        return board;
    }

    private void dfs(char[][] board, int i, int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return;
        if( board[i][j] != 'E')
            return;
        else{
            board[i][j] = 'B';
            bfs(board, i, j);
        }
        for(int ii = 0; ii < 8; ii++ ){
            if(board[i][j] >= '1'&& board[i][j] <='8') break;
            dfs(board,i+xx[ii],j+yy[ii]);
        }
    }

    private void bfs(char[][] board, int i, int j){
        int cnt = 0;
        int r = board.length, c = board[0].length;
        for(int idx = 0; idx < 8; idx++){
            int newr = i+xx[idx];
            int newc = j+yy[idx];
            if(newr < 0 || newr >= r || newc < 0 || newc >= c)
                continue;
            char sur = board[newr][newc];
            if( sur == 'M')
                cnt++;
        }
        if(cnt != 0)
            board[i][j] = (char) (cnt+'0');
    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        char[][] board = {
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}
        };
        printMatrix(updateBoard(board, new int[]{3,0}));

        char[][] board1 = {
                {'B', '1', 'E', '1', 'B'},
                {'B', '1', 'M', '1', 'B'},
                {'B', '1', '1', '1', 'B'},
                {'B', 'B', 'B', 'B', 'B'}
        };
        printMatrix(updateBoard(board1, new int[]{1,2}));
    }

    public void printMatrix ( char[][] matrix){
        for(char[] arr: matrix){
            System.out.print("[");
            for(int n: arr)
                System.out.print((char)n+",");
            System.out.println("]");
        }
        System.out.println("******************");
    }
}

