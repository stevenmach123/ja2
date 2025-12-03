package contestBi126;

import java.util.Arrays;
import java.util.PriorityQueue;
  // Arrays.stream(char[]) not allowed        
public class problem {
    //3079
    public int sumOfEncryptedInt(int[] nums) { 
        
        String[] vs = Arrays.stream(nums).boxed().map(x->Integer.toString(x)).toArray(String[]::new);
        
        int sum =0;
        for(int i=0;i <vs.length;i++){
            int max = 0;
            for(char l: vs[i].toCharArray()){
                max =Math.max(Integer.parseInt(String.valueOf(l)),max );
            }
            String d = "";
            for(char l: vs[i].toCharArray()){
                d += String.valueOf(max);
            }
            vs[i]= d;
        }
        for(int i=0;i <vs.length;i++){
            sum  +=Integer.valueOf(vs[i]);
        }
        return sum;
        
    
    }
    //3080
    //https://leetcode.com/problems/mark-elements-on-array-by-performing-queries/solutions/4884199/priority-queue-very-simple-and-easy-to-understand-solution/
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
       
        long[] result  =new long[queries.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1] !=0?a[1]-b[1]:a[0]-b[0]);
        int[] t ={0};
        long sum =0; 
        for(int i=0;i<nums.length;i++){     
                pq.add(new int[]{i,(int)nums[i]});
                sum += nums[i];
        }
       
        for(int que[]: queries){
            sum -= nums[que[0]];
            nums[que[0]] =0;
            while(que[1] >0 && !pq.isEmpty()){
                int[] ele  = pq.poll();
                if(nums[ele[0]] !=0){
                    sum -= ele[1];
                    nums[ele[0]] = 0;
                    que[1]--; 
                }
                  
            }
            
            result[t[0]] = sum;
            t[0]++;
        }
        
        return result;
    }
    //3082
   //https://leetcode.com/problems/find-the-sum-of-the-power-of-all-subsequences/solutions/4884206/java-python-3-clean-t-o-n-k-s-o-k-dp-code-using-2-counters-w-brief-explanation-and-analysis/
    //https://leetcode.com/problems/find-the-sum-of-the-power-of-all-subsequences/solutions/4884161/take-nottake-dp/
    //https://leetcode.com/problems/find-the-sum-of-the-power-of-all-subsequences/solutions/4884281/pick-skip-number-of-subset-sum-problem-c/
    public int sumOfPower(int[] nums, int k) {
        
    }

}
