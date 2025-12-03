import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSumII {
    List<List<Integer>> res = new ArrayList<>(); 
    public List<List<Integer>> combinationSum2_1(int[] candidates, int target) {
        Arrays.sort(candidates);
        help(candidates,target,new ArrayList<Integer>(),0,0,0); 
    
        return res;
    }

    void help(int[] cand,int target,List<Integer> curComb,int idx,int sum,int pidx){
        int n =cand.length; 
        
        if(idx >= n )return;
        if(idx > pidx  && cand[idx-1] == cand[idx]){
             help(cand,target,curComb,idx+1,sum,idx );  return;
            // help(cand,target,curComb,idx+1,sum,pidx); is ok  
        }
            
        
        if(sum + cand[idx] == target ){
            curComb.add(cand[idx]);
            res.add(new ArrayList<>(curComb));
            curComb.remove(curComb.size()-1);
            return;
        }
        else if(sum+cand[idx]< target){
            

            curComb.add(cand[idx]);
            
            help(cand,target,curComb,idx+1,sum+cand[idx],idx+1 );
            curComb.remove(curComb.size()-1);
            
            help(cand,target,curComb,idx+1,sum,idx); 
        }
        else{
            
            help(cand,target,curComb,idx+1,sum,idx ); 
        } 
        
        
    }

    public List<List<Integer>> combinationSum2_2(int[] candidates, int target) {
        Arrays.sort(candidates); 
        help1(candidates,target,new ArrayList<>(),candidates.length-1,candidates.length-1,0);
        return res;

    }
     boolean  help1(int[] cand,int target,List<Integer> curComb,int idx,int pidx,int sum){
         if(sum == target ){
            
            res.add(new ArrayList<>(curComb));
            return true;
        }
        /*
         if(sum > target ){
            return true;
         }
        */
        if(idx < 0   ) return true;

        
        boolean cut = help1(cand,target,curComb,idx-1,pidx,sum);
         if(sum+cand[idx] > target || !cut  ){
            return true;
        }
        if(  pidx > idx && cand[idx]== cand[idx+1]){
            return true;
        }  
      
        curComb.add(cand[idx]);
        help1(cand,target,curComb,idx-1,idx-1,sum+cand[idx]);
        curComb.remove(curComb.size()-1); 
        return true;
            
    
        
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); 
        help2(candidates,target,new ArrayList<>(),0,0);
        return res;
        
    }

    boolean help2(int[] cand, int target,List<Integer> curComb,int idx,int sum){
        int cur ;
        if(sum ==target){
            res.add(new ArrayList<>(curComb));
            return true; 
        }
        if(sum > target ) return true;
        for(cur=idx;cur<cand.length;cur++){
            if(cur > idx && cand[cur] ==cand[cur-1] ) continue;
            curComb.add(cand[cur]);
            help2(cand,target,curComb,cur,sum+cand[cur]);
            curComb.remove(curComb.size()-1); 
        
        }
        return true; 
        
    }







}
