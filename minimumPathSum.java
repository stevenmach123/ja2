
public class minimumPathSum{
    public int sum(int[][] grid){
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i=0;i< grid.length;i++){
            for(int y=0;y< grid[0].length;y++){
                if(i==0 && y==0)
                    dp[i][y] = grid[0][0];
                else if(y==0)
                    dp[i][y] = grid[i][y]+ dp[i-1][y];
                else if(i==0)
                     dp[i][y] = grid[i][y]+ dp[i][y-1];
                else   
                    dp[i][y]=Math.min(grid[i][y]+dp[i-1][y],grid[i][y]+dp[i][y-1]);  


            }


        }
        /*   List<ArrayList<Integer>> e = new ArrayList<>();
        
        for(int[] ar:dp){
            ArrayList<Integer> er = (ArrayList) Arrays.stream(ar).boxed().collect(Collectors.toList()); 
            e.add(er);
        }
          for(List<Integer> t: e){
            System.out.println(t);
        } */
        
        return dp[grid.length-1][grid[0].length-1];
    }
    public int sum2(int[][] grid){
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i=grid.length-1;i>=0;i--){
            for(int y=grid[0].length-1;y>=0;y--){ 
                if(i==grid.length-1 && y==grid[0].length-1)
                    dp[i][y] = grid[grid.length-1][grid[0].length-1]; 
                else if(y==grid[0].length-1 )
                    dp[i][y] =  grid[i][y]+ dp[i+1][y]; 
                else if(i==grid.length-1)
                    dp[i][y] =  grid[i][y]+ dp[i][y-1]; 
                else 
                    dp[i][y]=Math.min(grid[i][y]+dp[i+1][y],grid[i][y]+dp[i][y+1]);   
            }
        }

        return dp[0][0];
        

    }










   


}