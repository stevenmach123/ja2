import java.util.Arrays;

public class longestCommonSubSequence {
    public int common(String text1, String text2) {
        int n1= text1.length(); int n2= text2.length(); 
        int[][] dp = new int[n1+1][n2+1];
        for(int i=0;i<=n1;i++){
            Arrays.fill(dp[i],-1);
        }

        help(text1,text2,dp,0,0,0);
        /*for(int i= 0;i<dp.length;i++){
            System.out.println(Arrays.stream(dp[i]).boxed().collect(Collectors.toList())  );
        }  */
        

        return dp[n1-1][n2-1];
    } 
    void help(String text1,String text2,int[][] dp,int prev,int x,int y){
        int n1= text1.length(); int n2= text2.length(); 
 
        if(x >= n1 || y>=n2){
            dp[n1-1][n2-1] = Math.max(dp[n1-1][n2-1],prev);
            return;
        }
        if(text1.charAt(x)==text2.charAt(y)){
            if(prev+1 > dp[x][y]){
                dp[x][y] = prev+1; 
             
                help(text1,text2,dp,dp[x][y],x+1,y+1);  

            }
           
        }
        else{
            if(prev >dp[x][y]){
                dp[x][y] = prev;
                help(text1,text2,dp,dp[x][y],x+1,y);
                help(text1,text2,dp,dp[x][y],x,y+1);
            }

        }
            
    }


    public int common2(String text1, String text2) {
        int n1= text1.length(); int n2= text2.length(); 
        int[][] dp = new int[n1][n2];
        for(int i=0;i<n1;i++){
            Arrays.fill(dp[i],-1);
        }
        return help2(text1,text2,dp,0,0);


    }
    int help2(String text1,String text2,int[][] dp,int x,int y){
        int n1= text1.length(); int n2= text2.length(); 
        if(x >= n1 || y>=n2){
            return 0;
        }
        if(text1.charAt(x)==text2.charAt(y)){
            if(dp[x][y]==-1)
                dp[x][y] = 1+ help2(text1,text2,dp,x+1,y+1);
            
        }else {
            if(dp[x][y]==-1)
                dp[x][y] =Math.max(help2(text1,text2,dp,x+1,y), help2(text1,text2,dp,x,y+1));
         
        }
        return dp[x][y];
        
    }

    public int common3(String text1, String text2) {
        int n1= text1.length(); int n2= text2.length(); 
        int[][] dp = new int[n1+1][n2+1];
        for(int y =n1-1; y>=0;y--){
            for(int x=n2-1;x>=0;x--){
                if(text1.charAt(y)==text2.charAt(x) ){
                    dp[y][x] = 1 + dp[y+1][x+1];
                }
                else{
                    dp[y][x] = Math.max(dp[y][x+1],dp[y+1][x]);
                }

            }
        }
        return dp[0][0];




    }









    public int common4(String text1, String text2) {
        int n1= text1.length(), n2 =text2.length(); 
        int dp[][] = new int[n2+1][n1+1];
        for(int i2 =n2-1;i2>=0; i2--){
            for(int i1=n1-1; i1>=0; i1-- ){
                if(text1.charAt(i1) == text2.charAt(i2))
                    dp[i2][i1]  =1+Math.max(dp[i2+1][i1+1], Math.max(dp[i2+1][i1],dp[i2][i1+1]));
                else 
                    dp[i2][i1]  =Math.max(dp[i2+1][i1+1], Math.max(dp[i2+1][i1],dp[i2][i1+1]));
            }
        }
        //Arrays.stream(dp).map(v->Arrays.toString(v)).forEach(System.out::println);
        return dp[0][0];

    }




    


}
