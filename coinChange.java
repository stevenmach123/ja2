
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class coinChange {
    List<Integer> results = new ArrayList<>();
  
    public int change(int[] coins, int amount){
         if(amount ==0) return 0;
       // Arrays.sort(coins);
        for(int i=0;i<amount;i++){
             results.add(Integer.MAX_VALUE); 
        }
        for(int target=1;target <= amount;target++){
            
            help(coins,target,0,target,0); 
            int val = results.get(target-1);
            int x = val == Integer.MAX_VALUE?-1:val;
            results.set(target-1,x);
            
        }
        
       
        return results.get(amount-1);
    
    }
    
    public void help(int[] coins,int target,int i,int sum, int re){
       if(i >= coins.length) return;
        if(sum ==0){
            //int temp = Math.min(re, results.get(results.size()-1));
            //results.set(target-1,re);     
            results.set(target-1,1);    
            return; 
        }
        if(sum < 0) return;
        
       int total=-1;
        help(coins,target,i+1,sum,re);
        if(sum-coins[i]-1 >=0 ){
            if( results.get(sum- coins[i]-1) != -1){
                total  = results.get(sum- coins[i]-1) +1 ;
                //System.out.println(total);
                results.set(target-1, Math.min(results.get(target-1), total));
                return ;
            }
            else {
                       
                return;
            }
            
        }
        

        help(coins,target,i,sum -coins[i],re+1);
 
    }

    List<Integer> results2 = new ArrayList<>();
    
     public int change2(int[] coins, int amount){ 
        if(amount ==0) return 0;
        Arrays.sort(coins);
        for(int i=0;i<amount;i++){
             results2.add(Integer.MAX_VALUE); 
        }
        for(int target=1;target <= amount;target++){
            for(int i =0; i< coins.length && coins[i] <= target;i++){ 
                    
                if(target== coins[i]){
                    
                    results2.set(target-1, 1);
                }
                else if(results2.get(target-coins[i]-1) !=-1){
                    int val = Math.min(results2.get(target-1),results2.get(target-coins[i]-1)+1 );
                    results2.set(target-1,val);
                    
                }        
                                
            }
            int val = results2.get(target-1);       
            results2.set(target-1,val == Integer.MAX_VALUE?-1:val);
            
        }
        return results2.get(amount-1);


     }
     








    
}
