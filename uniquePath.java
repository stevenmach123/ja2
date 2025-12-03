
import java.util.Arrays;

public class uniquePath {
    int cn; 
    int cm;
    int[][] dp; 
    public int unique(int m, int n){
        dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        cn =n; cm=m;
        return help(0,0); 
    } 
    int help(int m,int n){
        if(m+1==cm && n+1==cn)
          return 1;
        if(m>=cm || n >=cn)
            return 0;
        if(dp[m][n] < 0)
            dp[m][n] = help(m+1,n)  + help(m,n+1);

        return dp[m][n];
    } 

    public int unique2(int m, int n){
        dp =  new int[m][n];
         for(int i=0;i<m;i++){
            Arrays.fill(dp[i],1);
        } 
        for(int x=1;x<m;x++){
            for(int y=1;y<n;y++){
                dp[x][y] = dp[x-1][y]+dp[x][y-1];

            }
        }
        return dp[m-1][n-1];

    }
    public int unique3(int m, int n){ 
        dp =  new int[2][n];
        for(int x=0;x<m;x++){
            for(int y=0;y<n;y++){ 
                if(x==0 ||y==0 )
                    dp[x%2][y] =1;
                else 
                    dp[x%2][y] = dp[(x+1)%2][y]+ dp[x%2][y-1];
            }
        }
        return dp[(m-1)%2][n-1];
        
    }






    public int uni(int m,int n){
        int[][] dp = new int[m][n];
        for(int y =m-1;y>=0;y--){
            for(int x=n-1;x>=0;x--){
                if(y ==m-1 || x==n-1)
                    dp[y][x] =1;
                else
                    dp[y][x]= dp[y+1][x] + dp[y][x+1];
            }
        }
        return dp[0][0];
    }

    





}
