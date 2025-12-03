
public class gasStation {
    public int index(int[] gas, int[] cost){
        
        int total= 0; 
        int start =0 ;
        int surplus = 0 ;
        for(int i=0;i< gas.length;i++){
        
            total += gas[i] -cost[i];  
           
            if(i>0 && gas[i-1] -cost[i-1] < 0 && gas[i] -cost[i] >=0 ){
                    if(surplus < 0){ 
                        start = i; 
                        surplus =  gas[i] - cost[i]; 
                    }           
            }else {
                 surplus  += gas[i] -cost[i];
            }
           //System.out.println(surplus);

           

        }
        if(total < 0) return -1; 
        else return start; 
        
    }

   
    


}