

import java.util.ArrayList;
import java.util.List;
public class uniqueTree {
 

    int unique1(int num){
        if(num <=1) return 1;
        int ans =0;
        for(int i=1;i<=num;i++){
            ans += unique1(i-1) * unique1(num-i);
        }
        return ans;
    }

    int unique2(int num, List<Integer> ar){
        
        if(ar.get(num) != -1){
            return ar.get(num);
        }
        int ans= 0;
        for(int i=1;i<=num;i++){
            ans += unique2(i-1,ar) * unique2(num-i,ar);
            ar.set(num,ans);
        }
        return ar.get(num);
    }

    int unique3(int num,List<Integer> ar){
    
        /*  for(int i=2;i<= num;i++ ){
          
            for(int j=0;j<i;j++){
                int val = ar.get(i)+ ar.get(j)*ar.get(i-j-1);
                ar.set(i, val);
            }
         
        }*/

        for(int i=1;i< num;i++ ){
            for(int j=1;j<=i+1;j++){ 
                int val = ar.get(i+1)+ ar.get(j-1)*ar.get(i-j+1);
                ar.set(i+1, val);
            }
        }
        
    
        return ar.get(num);


    }
    




    public int numTrees(int num){
        
        return unique1(num);
    }

    public int numTrees2(int num){
        List<Integer> ar = new ArrayList<>();
        
        for(int i =0;i<num+1;i++){
             ar.add(-1);
        }
        ar.set(0,1);
        ar.set(1,1);
        
        return unique2(num,ar);        
    }
    public Integer numTrees3(int num){
        List<Integer> ar = new ArrayList<>();
        
        for(int i =0;i<num+1;i++){
             ar.add(0);
        }

        ar.set(0,1);
        ar.set(1,1);
        
        
        return unique3(num,ar);
    }









    int help(int[] dp,int n){

    if(dp[n] ==0){
        for(int i=0;i<=n;i++){
                dp[n] += help(dp,n-i) +help(dp,i);
        }
    }
    return dp[n];
    }

    public int numTree4(int n){
        int[] dp = new int[n];
        dp[0] =1;
        return help(dp,n-1);
    }






}

