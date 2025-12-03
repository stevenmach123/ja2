import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        var result = new LinkedList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if( i > 0 && nums[i]== nums[i-1])
                continue;
            int lp =i+1;
            int rp = nums.length-1;
            while(lp < rp){
                if(nums[i] + nums[lp] + nums[rp]  < 0   ){
                    lp++;
                }else if(nums[i] + nums[lp] + nums[rp]  > 0 ){
                    rp++;
                }
                else 
                    result.add(Arrays.asList(nums[i],nums[lp],nums[rp]));
                    
            }
            
        }
        return result;

    } 
}
