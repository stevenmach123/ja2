
public class GameofLife{
    public void game(int[][] board) {
        int nr = board.length;
        int nc = board[0].length;
        int[][] c_board  = new int[nr][nc];
        int moves[][] = new int[][]{{1,1},{-1,-1},{1,-1},{-1,1},{0,1},{1,0},{0,-1},{-1,0}};
        for(int r =0;r<board.length;r++){

            for(int c=0;c<board[0].length;c++){
            int l =0;
            int d = 0;
            for(int[] move: moves ){
                int mr = move[0]+r;
                int mc = move[1] +c;
                if(mr <0 || mr >= nr || mc <0 || mc >=nc)
                    continue;
                if(board[mr][mc] ==0) d++;
                else l++;    
                
            }
            if(board[r][c] ==0){
                if(l==3 )
                    c_board[r][c] =1;
            }
            else if(board[r][c]==1){
                if(l < 2 || l>3)
                    c_board[r][c] = 0;
                else    
                    c_board[r][c]=1;
            }
            

            }

        } 
        
        for(int r =0;r<board.length;r++){
            for(int c=0;c<board[0].length;c++)
                board[r][c] =c_board[r][c];
        }
      

    }  
}