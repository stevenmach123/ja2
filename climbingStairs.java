
import java.util.Arrays;

public class climbingStairs {
    public int climbStairs2(int n) {
        int[] way = new int[n+1];
        Arrays.fill(way,-1);
        way[0] =1; 
        way[1] =1; 
        for(int i =1;i<n;i++){
            way[i+1] = way[i] + way[i-1]; 
             
        }
        return way[n];

    }
     public int climbStairs3(int n) {
        if(n==1) return 1;
          int[] way = new int[n];
        Arrays.fill(way,-1);
        way[0] =1; 
        way[1] =2; 
        for(int i =2;i<n;i++){
            way[i] = way[i-1] + way[i-2]; 
             
        }
        return way[n-1];
    }

    
    public int climbStairs4(int n) { 
        int[] way = new int[n]; 
        Arrays.fill(way,-1); 
        return help(way,n);

    }
    int help(int[] way,int k){
        if(k==0) return 1;
        if(k< 0) return 0; 
        if(way[k-1] != -1){
            return way[k-1];
        }
    
        way[k-1] = help(way,k-1) + help(way,k-2); 
        return way[k-1];
    }


     public int climbStairs(int n) { 
        int[] way = new int[n+1]; 
        Arrays.fill(way,-1); 
        return help2(way,n);

    }
    int help2(int[] way,int k){
        if(k==0) return 1;
        if(k< 0) return 0; 
        if(way[k] != -1){
            return way[k];
        }
    
        way[k] = help2(way,k-1) + help2(way,k-2); 
        return way[k];
    }

    public int climbStairs5(int n) {  
        int[] way = new int[n]; 
        Arrays.fill(way,-1); 
        return help4(way,n); 
         
     }
     int help4(int[] way,int k){  
         if(k==0) return 1;
         if(k==1) return 1; 

        if(way[k-1] != -1){
            return way[k-1];
        }
        way[k-1] = help4(way,k-1) + help4(way,k-2);  
        return way[k-1];
         
     } 



    public int climbStairs6(int n) { 
        int[] way = new int[n];  
        Arrays.fill(way,-1); 
        return help3(way,n-1);
    }
    int help3(int[] way,int k){ 
        if(k ==0) return 1; 
        if(k==1) return 2;
        if(way[k] < 0)   
            way[k] = help3(way,k-1) + help3(way,k-2);  

        return way[k]; 

    }


    int helpy(int[] way,int k){
        if(k <0  )
            return 0;
        if(k ==0) 
            return 1;
        int val = way[k-1];
        if(val ==-1)
            way[k-1] =  helpy(way,k-1) + helpy(way,k-2) ;
        return val;
    }
    public int climbStairs1(int n) { 
        int[] way = new int[n];
        Arrays.fill(way,-1) ;
        helpy(way,n);
        return way[n-1];
    }




}
