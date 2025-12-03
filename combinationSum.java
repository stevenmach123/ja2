
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class combinationSum {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine2(int[] candidates, int target) {
        Arrays.sort(candidates);
        help2(candidates,target,new LinkedList<>(),0,0);
        return result;
    }
    void help2(int[] cand,int target,List<Integer> comb,int ind,int sum){   
        if(sum ==target){
            List re = new LinkedList<>(comb);
            result.add(re); 
            return;
        }
        if(sum >target)
            return ;
        
        for(int i =ind;i<cand.length;i++){
            comb.add(cand[i]);sum += cand[i];
            help2(cand,target,comb,i,sum);
            comb.remove(cand[i]);
            sum -=cand[i];
            
        }
    }
    








    


}
