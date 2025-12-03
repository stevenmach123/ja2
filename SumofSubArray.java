import java.util.LinkedList;
import java.util.List;

public class SumofSubArray {
    List<Integer> array(int[] arr,int target){
        List<Integer> e = new LinkedList<>();
        if(arr.length == 0) 
            return new LinkedList<Integer>();
        
        int slow =0;
        int fast = 1;

        int sum =arr[slow]; 
        e.add(arr[slow]); 
        if(fast == arr.length ){
            if(sum == target ) return e;
            else return new LinkedList<Integer>();
        }
            
        e.add(arr[fast]); 
        sum += arr[fast];
        while(fast< arr.length ){
            System.out.println(slow+" "+fast);
            if(slow ==fast ){
                if(sum == target )
                    return e;
                fast++;
                if(fast <arr.length){
                    e.add(arr[fast]);
                    sum += arr[fast]; 
                }

                continue;
            }
            if(sum > target){      
                slow++;
                sum -= e.remove(0);
                
            }
            else if(sum < target ){
                fast++; 
                if(fast <arr.length){
                    e.add(arr[fast]);
                    sum += arr[fast];
                }
                
            }else return e;
            
           
    
        }
        return new LinkedList<Integer>(); 
        
        
    }
}
