import java.util.List;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
public class SubsetII {
    List<List<Integer>> result = new LinkedList<>();
    Set<List<Integer>>[]  x;
     public List<List<Integer>> subsetsWithDup(int[] nums) {
        x= new HashSet[nums.length];      
       
        Arrays.sort(nums);
        help(nums,0,new LinkedList<>());

        Set<List<Integer>> c = new HashSet<>();
        c.add(Arrays.asList(1,2));
        if(c.contains(new LinkedList<Integer>(){{add(1,2);}}))
            return result;
        
        return result;
    }
    void help(int[]nums,int idx, List<Integer> l){
        if(idx >=nums.length ){
            result.add(l);
            return;
        }
        if(x[idx].contains(l))
            return;
        x[idx].add(l);
        List l2 = new LinkedList<>(l);
        l.add(nums[idx]);
        help(nums,idx+1,l2);
    

    }
}
