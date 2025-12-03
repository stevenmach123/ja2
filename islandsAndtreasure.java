
public class islandsAndtreasure {
    public void islandsAndTreasure(int[][] grid) { 
       
        int nr = grid.length;
        int nc =  grid[0].length;
        for(int r = 0; r<nr;r++ ){
            for(int c = 0; c<nc;c++ ){
                if(grid[r][c] == Integer.MAX_VALUE)
                  help(grid,r,c);
            }
        }
   
    }
    void help(int[][]grid,int r,int c){
        if(grid[r][c]  == 0  ){
            return;          
        }
        int nr = grid.length;
        int nc =  grid[0].length; 
        int[][] moves  = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        grid[r][c] = -1;
        
        for(int[] move : moves){
            int mr = r + move[0];
            int mc = r + move[1];  
            if(mr <0 || mr>=nr ||  mc<0 || mc>= nc || grid[mr][mc] == -1 )
                continue;
            help(grid,mr,mc); 
            grid[r][c] = grid[mr][mc] == Integer.MAX_VALUE? grid[r][c]:Math.min(grid[r][c],grid[mr][mc]+1);
        }
        
    
        
    }









}
