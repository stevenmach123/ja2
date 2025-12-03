
import java.util.Hashtable;

public class twoSum {
    public int[] sum(int[] nums, int target) { 
        Hashtable<Integer,Integer> a = new Hashtable<Integer,Integer>();
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            a.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            if( a.get(target-nums[i]) !=null && a.get(target-nums[i]) !=i ){
                result[0] = i;
                result[1] = a.get(target-nums[i]);
                return result; 
            }
        }


        return result; 
        
    }
}
