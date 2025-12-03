
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.stream.Collectors;

public class Klargest {

    public int[] toArrayInt(ArrayList<Integer> a){
        int container[]  =new int[a.size()];
        for(int i=0;i< a.size();i++){
            container[i]= (int)a.get(i);
            
        }
        return container;
        
    }
     void swap(int[] nums,int i,int j){
        int temp = nums[i]; 
        nums[i] = nums[j];
        nums[j]= temp;
    }


    public int find(int[] nums, int k){
        Random rand = new Random();
        int idx =rand.nextInt((nums.length))+1;
        int pivot = nums[idx-1];
        ArrayList<Integer> left = new ArrayList<>() ;   
        ArrayList<Integer> mid = new ArrayList<>() ;
        ArrayList<Integer> right = new ArrayList<>() ;
        int k_r = nums.length +1 - k; 
        for(int i =0;i<nums.length;i++ ){
            if(nums[i]< pivot) left.add(nums[i]);
        }  
        for(int i =0;i<nums.length;i++ ){
            if(nums[i]== pivot) mid.add(nums[i]);
            
        }  
        for(int i =0;i<nums.length;i++ ){
            if(nums[i] > pivot) right.add(nums[i]); 
        }  
        
        if(k_r <= left.size()){
           
            return find(toArrayInt(left),left.size() -k_r+1 );
        }
        else if( k_r <= left.size()+mid.size()){
             return mid.get(0);
        }
        else {
            return find(toArrayInt(right),k); 
        }
      



    }
   

    public int find2(int[] nums, int k){
       
        return selection(nums,1,nums.length,k);
     
    }
    int selection(int nums[],int low,int high,int k){
        
            int pivot = low-1;
            for(int j=low-1 ;j < high-1;j++){
                if( nums[j] <= nums[high-1]){
                    swap(nums,pivot++,j);
                }
                
            } 
            swap(nums,pivot,high-1);
            int pivot_low = pivot;   
            for(int j=low-1;j < pivot_low ;j++ ){
                if( nums[j] == nums[pivot]){
                    swap(nums,--pivot_low,j);
                }
            }

            /*  List<Integer> a =  Arrays.stream(nums).boxed().collect(Collectors.toList());
            System.out.println(nums[pivot]+" "+pivot);
            System.out.println(a); */
                
        
            int count = high -pivot;
            int count_low = high - pivot_low;
            if(count >k){
                return selection(nums,pivot+2,high,k );
            }
            else if(count_low >= k ){
                return nums[pivot];
            }
            else{
                return selection(nums,low,pivot_low+1-1,k-count_low);
            }
        

    }
    public int find2_2(int[] nums, int k){ 
        return selection2_2(nums,0,nums.length-1,nums.length-k+1); 
        
    }
    int selection2_2(int[] nums,int low,int high,int k){
        int pivot = low;
        for(int j=low ;j <= high;j++){
            if( nums[j] > nums[high]){
                swap(nums,pivot++,j);
            }
           
        
        } 
      
        swap(nums,pivot,high);

        int pivot_high = pivot;
        for(int j=high;j > pivot_high ;j-- ){
            if( nums[j] == nums[pivot]){
                swap(nums,++pivot_high,j);
            }
        }

        if(k > pivot_high+1 ){
            return selection2_2(nums,pivot_high+1,high,k);
        }
        else if( k >= pivot+1 ){
           return nums[pivot];
        }
        else{   
            return selection2_2(nums,low,pivot-1,k); 
        }

        
    }
   

    







    public int find3(int[] nums, int k){
        return selection2(nums,0,nums.length-1,k); 

    }
    int selection2(int nums[],int low,int high,int k){
        int pivot = low;
       
        for(int j=low ;j < high;j++){
            if( nums[j] >=  nums[high]){
                swap(nums,pivot++,j);
            }
            
        }
        swap(nums,pivot,high);
        int pivot_low = pivot;
       
        for(int j=low;j < pivot_low ;j++ ){
            if( nums[j] == nums[pivot]){
                swap(nums,--pivot_low,j);
            }
        } 
       
                
        
        if(k <pivot_low+1 ){
           // System.out.println("left");
            return selection2(nums,low,pivot_low-1,k);
        }
        else if(k <= pivot+1){
           // System.out.println("mid");
            return nums[pivot];
        }
        else{
            //System.out.println("right");
            return  selection2(nums,pivot+1,high,k); 
        }




    }

    public int find3_2(int[] nums, int k){
        return selection3(nums,0,nums.length-1,nums.length -k+1); 

    }

    public int selection3(int nums[],int low,int high,int k){
        int pivot = low;
        for(int j=low ;j <= high;j++){
            if( nums[j] > nums[high]){
                swap(nums,pivot++,j);
            }
           
        
        } 
        swap(nums,pivot,high);
        int pivot_high = pivot;
        for(int j=high;j > pivot_high ;j-- ){
            if( nums[j] == nums[pivot]){
                swap(nums,++pivot_high,j);
            }
        }
        List<Integer> a =  Arrays.stream(nums).boxed().collect(Collectors.toList());
        System.out.println(nums[pivot]+" "+pivot);
        System.out.println(a); 

        int count = high - pivot +1;
        int count_high = high- pivot_high +1; 
        if(k > count ){
            return selection3(nums,low,pivot-1,k-count);
        }
        else if(k >= count_high ){
            return nums[pivot]; 
            
            
        }
        else{
             return selection3(nums,pivot_high+1,high,k);
        }
        



    }

    public int find_pq(int[] nums, int k) {
        PriorityQueue<Integer> x  = new PriorityQueue<>();
        Deque<Integer> qw = new LinkedList<>();
        LinkedList w = new LinkedList<>();
        List ww = new LinkedList<>();
        
        for(int n :nums){
            if(x.size() ==k && x.peek() < n ){
               x.poll();
                x.offer(n);
            }
            else if(x.size() < k)
                x.offer(n);
            System.out.println(x);
        }
        return (int) x.peek();
        
    }




        

}
