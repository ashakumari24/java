/*
1:- print all posible ways to solve N-Queens
2:- print total number posible ways
 * 3:-Check if problem can be solved & print only 1 solution to N Queens problem.
 */
public class NQueens {
    public static boolean isSafe(char board[][],int row,int col)
    {
        // vertical up
        for (int i = row-1; i>=0; i--) {
               if (board[i][col]=='Q') {
                return false;
               }
        }
        //diag left up
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--)
        {
            if (board[i][j]=='Q') {
                return false;
            }
        }
        //diag right up
        for(int i=row-1,j=col+1;i>=0&&j<board.length;i--,j++)
        {
            if (board[i][j]=='Q') {
                return false;
            }
        }
        return true;
    }
    /*
     * Time Complexicity=O(n!)
     */
    static int count=0;
    public static boolean nQueens(char board[][],int row)
    {
        if (row==board.length) {
            // printBoard(board);
            count++;
            // return ;
            return true;
        }
        for (int j = 0; j < board.length; j++) {
            if(isSafe(board, row, j))
            {
                board[row][j]='Q';
                if(nQueens(board,row+1))
                {
                    return true;
                }
                // nQueens(board,row+1);
                board[row][j]='x';
            }

        }
        return false;
    }
    public static void printBoard(char board[][])
    {
        System.out.println("-----------chess board-------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
           int n=2;
           char board[][]=new char[n][n];
           for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j]='x';
            }
           }
           if(nQueens(board,0))
           {
            System.out.println("Solution is exits");
            printBoard(board);
           }
           else{
            System.out.println("Solution is not exits");
           }
        //    System.out.println("Total number of ways to solve n-Queen= "+count);
       

    }
}
