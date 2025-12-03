
import java.util.HashMap;
import java.util.Map;
public class targetSum {
   
    // https://leetcode.com/problems/target-sum/solutions/455024/dp-is-easy-5-steps-to-think-through-dp-questions/
    // https://leetcode.com/problems/target-sum/solutions/97334/java-15-ms-c-3-ms-o-ns-iterative-dp-solution-using-subset-sum-with-explanation/
     //way1
    public int findTargetSumWays(int[] nums, int target) {
        int sum =0;
        for(int num:nums){
            sum +=num;
        }
        if(  Math.abs(target) > sum ||(sum+target)%2 >0 ){
            return 0; 
        }
        else {
            return n_subset(nums,(sum+target)/2);
        }
    }
    int n_subset(int[] nums, int tar){
    
        int[] dp= new int[tar+1];
        dp[0] =1;
        for(int num:nums){
            for(int i=tar;i>=num ;i--)
                dp[i] += dp[i-num];
        }
        return dp[tar];
           
    }
    //way2 
    Map<Integer,Map<Integer,Integer>> m ;
    public int findTargetSumWays2(int[] nums, int target) {
        m = new HashMap<>();  
        return dps(nums,target,nums.length-1,0);
    }
    int dps(int[] nums ,int target,int idx, int cum){
        if(idx  < 0){
            if(cum ==target)
                return 1;
            else return 0; 
        }
        else{
            if(m.containsKey(idx) && m.get(idx).containsKey(cum)){
                return m.get(idx).get(cum);
            }
        
            int pos_way = dps(nums,target,idx-1,cum+nums[idx]);
            int ne_way = dps(nums,target,idx-1,cum-nums[idx]);
            m.putIfAbsent(idx,new HashMap<>()) ; 
            m.get(idx).put(cum, pos_way+ ne_way);
            return m.get(idx).get(cum);
        }
        
    }
}
