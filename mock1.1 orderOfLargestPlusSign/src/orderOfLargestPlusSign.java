class A {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] grid = new int[N][N];
        for(int i = 0; i < N ; i++)
            for(int j = 0; j < N ; j++)
                grid[i][j] = 1;

        for(int i =0; i < mines.length; i++)
            grid[mines[i][0]][mines[i][1]] =0;

        int resk = 0;
        for(int i = 0; i < N; i++)
            for( int j = 0; j < N; j++){
                if(grid[i][j] != 1) continue;
                for( int k = 0 ; i+k < N && i-k >=0 && j+k < N && j-k >=0 ; k++){
                    if( grid[i][j+k] != 1 || grid[i][j-k] != 1 || grid[i+k][j] != 1  || grid[i-k][j] != 1){
                        break;
                    }resk = Math.max(k+1,resk);
                }
            }
        return resk;
    }


        public static void main(String [] args){
            A Launcher = new A();
            Launcher.start();
        }
        public void start(){
            int[][] mines = {{4,2}};
            System.out.println(orderOfLargestPlusSign(5,mines));
        }

}

