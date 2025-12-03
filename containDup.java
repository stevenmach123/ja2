
import java.util.Arrays;

class containDup{
    public boolean containsDuplicate(int[] nums){
        for(int i= 0; i<nums.length;i++){
            for(int r=nums.length-1;r>i;r--){
                if(nums[r] < nums[r-1]){
                    int num = nums[r];
                    nums[r] =nums[r-1]; 
                    nums[r-1] = num;

                }
            }
        }
        
     

       for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                return true;
            }
        
        
       }
        
        
        return false;
    }

    public boolean containsDuplicate2(int[] nums){ 
         Arrays.sort(nums);
         for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                return true;
            }
        
        
       }
       return false;
    }


}