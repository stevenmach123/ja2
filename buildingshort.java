import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class buildingshort {
    public int distance(boolean[][] buildings,boolean[] features ){
        Deque<Integer> stack = new LinkedList<Integer>();
        int ni = buildings.length;
        int nf = features.length; 
        int dp[][] = new int[nf][ni]; 
        for(int[] p : dp){
            Arrays.fill(p,Integer.MAX_VALUE);
        }
        for(int f=0;f <nf ;f++){
            stack.clear();
            for(int i=0;i<ni;i++){
                stack.push(i);
                if(i>0){
                    if(dp[f][i-1] != Integer.MAX_VALUE ){
                        dp[f][i] = Math.min(dp[f][i] ,dp[f][i-1]+1); 
                    }

                }
                if(buildings[i][f]){
                    dp[f][i] = Math.min(0,dp[f][i]) ;
                    stack.pop();
                    //System.out.println(f+" "+i);
                    
                    while(!stack.isEmpty()){
                        int cur = stack.pop();
                        //System.out.println(cur);    
                        
                        dp[f][cur] = Math.min(dp[f][cur],dp[f][cur+1]+1);   
                    }
                              
                }
                
            }
        }
        for(int[] pp:dp){
            System.out.print(Arrays.stream(pp).boxed().collect(Collectors.toList()));
        } 
        int minDist = Integer.MAX_VALUE; 
        int index =-1;
       
        for(int i=0;i< ni;i++){
            int total =0;
            for(int f =0;f<nf;f++){
                total = Math.max(total,dp[f][i]);

            }
            if(minDist > total){
                 minDist =total ;index = i;
            } 

        }
        return index;
        
        
    }
}

/* 

    -1 
     inf          
    false  true false false true 

     act       
    true true true 
    
    List<> integer, 

    // inf 0 1 2   


      true   false  true   false  false
     false  false   true  false   true
       false  false   false  true   true


     false true true false false
     true false true true true
     false false false false true
 
 */