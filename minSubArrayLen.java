public class minSubArrayLen {
    public int min(int target, int[] nums) {
        int n =nums.length;
        int fast =0;int slow=0;
     
        int arr_len = Integer.MAX_VALUE;
        int tar = 0;
     
         while(slow < n || fast < n){
             //System.out.println(slow+" "+fast+" "+tar);
             if(tar < target){
                 if(fast >= n)
                     break;
                 tar += nums[fast]; 
                 fast++;      
             }
             else{
                 arr_len = Math.min(arr_len,fast-slow);
                 if(slow == fast || tar==target){
                     if(fast >=n )
                         break;
                     tar += nums[fast];
                     fast++;
                     
                 }else{
                     tar -= nums[slow];
                     slow++;
                 }
                 
 
             } 
                 
         }
         
 
         if(arr_len ==Integer.MAX_VALUE)
             return 0;
             
         return arr_len;
    }

}


/* people solution 

 class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int solution = Integer.MAX_VALUE;
        int sum = 0;

        int left = 0;
        for (int right=0; right < nums.length; right++) {
            sum += nums[right];

            // check if the sum >= target
            while (sum >= target) {
                sum -= nums[left];
                solution = Math.min(solution, right - left + 1);  // new min length
                left++;
            }
        }

        if (solution == Integer.MAX_VALUE) return 0;

        return solution;
    }
}
 */