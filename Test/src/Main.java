public class Main {

    /*
    [
    


    ]
    * */
    public static void main(String[] args)
    {
        System.out.println("Hello world!");
    }

    void solve(int[][] grid, int i, int j, int row, int col) {
        if(i > row || j > col || i < 0 || j < 0) return;
        if(i > row && j > col) {
            System.out.println("Solution Found!");
            return;
        }
        for(int num = 0; num<=9; num++) {
            if(canPlace(grid,i,j,num, row, col)){
                grid[i][j] = num;
                if(j == col - 1){
                    solve(grid,i+1,0,row, col);
                } else {
                    solve(grid,i,j+1,row, col);
                }
            }
        }

    }

    boolean canPlace(int[][] grid, int i, int j, int row, int col, int num){
        if(grid[i][j] == -1){
            // check horizontally
            for(int index = 0; index<col; index++){
                if(grid[i][index] == num) return false;
            }

            // check vertically
            for(int index = 0; index<row; index++){
                if(grid[index][j] == num) return false;
            }
        }
        return false;
    }
}