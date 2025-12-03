
public class SurroundedRegion {
    //https://leetcode.com/problems/surrounded-regions/solutions/4833974/easy-java-solution-using-dfs/
    char[][] flag;
    //WAY 1: TIMEOUT, BUT CORRECT
    public void solve1(char[][] board) {
        flag = new char[board.length][board[0].length];
    
         for(int r=0;r<board.length;r++){
            for(int c=0;c<board[0].length;c++){
                if(board[r][c] =='O')
                    _help1(board,r,c);
                
            }
        }
       

    }
    boolean _help1(char[][] board,int r, int c){
        int moves[][] = {{0,1},{1,0},{0,-1},{-1,0}};
     
        if(board[r][c] =='X')
            return true;
        if(flag[r][c]!= '\0'){
            if(flag[r][c]=='O') return false;
           else return true;
        }
     
        char prev = board[r][c];
        board[r][c] =' ';
        boolean result =true;
        for(int[] move: moves ){
            int nx = r+move[0];int ny=c+move[1];
            if(nx < 0 || nx >= board.length || ny < 0 || ny>=board[0].length  ){
                flag[r][c] = 'O';
                board[r][c] = 'O';
                return false;
            }
            if(board[nx][ny] == ' '){
                result =false;
                continue;
            }  
            if(!_help1(board,nx,ny)){
                flag[r][c] ='O';
                board[r][c] = 'O';
                return false;
            }
            if(flag[nx][ny] == 'X' && board[nx][ny] =='X'){
                flag[r][c]= 'X';
                board[r][c] = 'X';
                return true;
            }
        }
        board[r][c]=prev;
        if(result){
            flag[r][c]= 'X';
            board[r][c] = 'X';
              
        }
        return true;
        
    }



    //WAY2
    
    
    public void solve(char[][] board) {
        flag = new char[board.length][board[0].length];
        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[0].length;c++){
                if(board[r][c] =='O' && flag[r][c] !='\0')
                    _help(board,r,c);
                
            }
        }   
        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[0].length;c++){ 
                if(flag[r][c] == 'X')
                    mark_dps(board,r,c);
            }
        }  
     } 
     public void mark_dps(char[][]board,int r,int c){
        int moves[][] = {{0,1},{1,0},{0,-1},{-1,0}};  
        board[r][c] = 'X';
        for(int[] move: moves ){ 
            int nx = r+move[0];int ny=c+move[1];
            if(board[nx][ny] == 'X')
                continue;
            mark_dps(board,nx,ny);
             
        }
       
     }
     public boolean _help(char[][]board,int r,int c){
        int moves[][] = {{0,1},{1,0},{0,-1},{-1,0}}; 
        if(board[r][c] =='X')
            return true; 
        if(flag[r][c] == 'O')
            return false;
        flag[r][c] = ' ';
        boolean result = true;
    
        for(int[] move: moves ){
            int nx = r+move[0];int ny=c+move[1];
            if(nx < 0 || nx >= board.length || ny < 0 || ny>=board[0].length  ){
                flag[r][c] = 'O'; 
                return false;
            }
            if(flag[nx][ny] == ' '){
                result =false;
                continue;
            } 
            if(!_help(board,nx,ny)){
                flag[r][c] ='O';
                return false;
            } 
              
        }
        if(result){
            flag[r][c]= 'X';
        } 
        return true; 
     }





}
