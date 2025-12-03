
import java.util.Arrays;


public class maximalSquare {
    int max = 0;
    public int max(char[][] matrix) {
        for(int r =0;r< matrix.length; r++){
            for(int c=0;c<matrix[0].length;c++){
                if(help(matrix,r,c))
                    return max;
            }

        }
        return max; 
        
    }


    boolean help(char[][] matrix,int i,int j){
        int area =0;
        for(int t =0;t < matrix.length - i;t++){
            if(i+t == matrix.length || j+t  == matrix[0].length  ){
                break;
            }
            area =0;
            boolean valid =true;
            for(int x=0; x<=t; x++){                
                for(int y=0; y<=t; y++){
                    if(matrix[i+x][j+y] != '1'){
                        valid =false; break; 
                    }
                        
                }
                if(!valid) return false;
                area++;
            }
            area *= area; 
            max = Math.max(area,max);
            if(i+t == matrix.length-1 && j+t ==  matrix[0].length-1 ){
                return true;
            }

        }
        
        return false;

        
    }

    int max2 =0; 
    public int max2(char[][] matrix) {
        System.out.println("max2");
        
        int[][] count = new int[matrix.length][matrix[0].length];

        for(int r =0;r< matrix.length; r++){ 
            for(int c=0;c<matrix[0].length;c++ ){
                    if( c==0 ||matrix[r][c]=='0')
                        count[r][c] = matrix[r][c] - '0';                   
                    else{
                        count[r][c] = count[r][c-1]+1;
                    }
            }
        }
        for(int r=matrix.length-1;r>=0; r--){ 
            for(int c=matrix[0].length-1;c>=0;c-- ){
               max2 = Math.max(max2,helper2(matrix,count,r,c));
            }
        
        }

        return max2*max2;
    }

    int helper2(char[][] matrix,int[][]count,int row,int col){
        int extend = Math.min(row,col)+1, seq=0;

        for(int i=0;i<extend;i++){
            extend = Math.min(extend,count[row-i][col]);
            if(extend <= i){
                seq =i; 
            }
            else{
                seq = i+1;
            }

            
        }

        return seq; 

    }

    

    int max3 =0;
    public int max3(char[][] matrix) { 
    
        int rowDy[][] = new int[matrix.length+1][matrix[0].length];
        int colDy[][] = new int[matrix.length][matrix[0].length+1];
        int dp[] = new int[matrix[0].length+1]; 
        for(int r =matrix.length -1;r>=0; r--){ 
            for(int c=matrix[0].length-1;c>=0;c--){
                rowDy[r][c] = matrix[r][c]=='1'?rowDy[r+1][c]+1: 0; 
                colDy[r][c] = matrix[r][c]=='1'?colDy[r][c+1]+1: 0; 
            }
        }

        int pre=0;
        for(int r =matrix.length -1;r>=0; r--){ 
            for(int c=matrix[0].length-1 ;c>=0;c--){ 
               
                int prev_dp = dp[c]; 
               dp[c] =Math.min(Math.min(rowDy[r][c]-1,colDy[r][c]-1),pre)+1;  
                max3 = Math.max(max3,dp[c]); 
                pre = prev_dp;
                
            }
        }
    return max3*max3;
    }
    


    int max3_2 =0;
    public int max3_2(char[][] matrix) { 
        int[][] dp = new int[matrix.length+1][matrix[0].length+1] ;  
        for(int r=0; r < matrix.length;r++){
            for(int c=0; c < matrix[0].length;c++){
                dp[r+1][c+1] = matrix[r][c] != '0'? Math.min(dp[r][c],Math.min(dp[r][c+1],dp[r+1][c])  ) +1 : 0; 
                max3_2 = Math.max(max3_2,dp[r+1][c+1]); 
            }
        }        

        return max3_2*max3_2;
    }


   
    public int max3_3(char[][] matrix) { 
        int dp[] = new int [matrix[0].length+1];
        int temp=0; 
        int max = 0 ;
        for(int r =matrix.length -1;r>=0; r--){ 
            for(int c=matrix[0].length-1 ;c>=0;c--){  
                int prev_dp = dp[c]; 
                dp[c] = matrix[r][c] == '1'?Math.min(dp[c+1],Math.min(temp, dp[c]))+1:0; 
                temp = prev_dp;
                max = Math.max(max,dp[c]);
            }
        }
        return max*max;
    }



    int max4 =0 ;
    public int max4(char[][] matrix){
        int dp[] = new int[matrix[0].length]; 
        int prev_dp[] = new int[matrix[0].length]; 
        for(int r=0; r < matrix.length;r++){
            for(int c=0; c < matrix[0].length;c++){
                if(r==0 || c==0 || matrix[r][c] == '0' )
                    dp[c] = matrix[r][c] -'0'; 
                else{
                    dp[c] = Math.min(dp[c-1],Math.min(prev_dp[c],prev_dp[c-1]) )+1; 
                }
                max4 = Math.max(max4, dp[c]);
                
            } 
            System.arraycopy(dp,0,prev_dp,0,dp.length);
            Arrays.fill(dp,0);
        }

        return max4*max4;
    }

    public int max4_2(char[][] matrix){
        int max =0 ;
        int dp[][] = new int[2][matrix[0].length];
        for(int r =matrix.length -1;r>=0; r--){ 
            for(int c=matrix[0].length-1 ;c>=0;c--){  
                if(r==matrix.length -1 || c == matrix[0].length-1 || matrix[r][c] == '0' ){
                    dp[r%2][c] = matrix[r][c] - '0';  

                }              
                else{
                    dp[r%2][c] = Math.min(dp[r%2][c+1],Math.min(dp[(r+1)%2][c],dp[(r+1)%2][c+1]) )+1;
                }
            
                    max = Math.max(max,dp[r%2][c]);

                }
           
                
               
        }
        
        return max*max; 

        

    }


        
    
    



}
