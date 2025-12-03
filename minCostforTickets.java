import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class minCostforTickets {

    int[] dp; 
    List<Integer> mday; 
    public int cost(int[] days, int[] costs){
        int n= days.length;
        dp = new int[days[n-1]+1];
        
        mday = new  ArrayList<>( Arrays.stream(days).boxed().collect(Collectors.toList()) ); 
        Arrays.fill(dp,-1);

        return help(costs,days[n-1]);
          
    
    }
    int help(int[] costs,int d){
        if( d <=0 ) return 0;
        int new_d = d;
        while(!mday.contains(new_d) && new_d >0){
            new_d--;
        }
        if(new_d ==0) return 0;
        //System.out.println("--");
         if(dp[new_d] ==-1){       
            dp[new_d] = Math.min(help(costs,new_d-1) + costs[0],
                            Math.min(help(costs,new_d-7) + costs[1],help(costs,new_d-30) + costs[2]));
        }
        
        return dp[new_d]; 
    }


    public int cost2(int[] days, int[] costs) {
        int n= days.length;
        dp = new int[days[n-1]+1];
        Arrays.fill(dp,-1);

        return help1(days,costs,n-1,days[n-1]); 
    }
    int help1(int[] days,int[] costs,int idx,int d){
        //System.out.println(idx+" "+d);
        if(d <=0 || idx <0 ) return 0;

        if(days[idx] >d) 
            return help1(days,costs,idx-1,d);
        else if(days[idx] <d)
            return help1(days,costs,idx,days[idx]); 
        else{
                if(dp[d] ==-1){       
                    dp[d] = Math.min(help1(days,costs,idx-1,d-1) + costs[0],
                                Math.min(help1(days,costs,idx-1,d-7) + costs[1],help1(days,costs,idx-1,d-30) + costs[2]));
                }
           
            }

        return dp[d]; 
    }

    
    //web : explanation from someone who took 2 hours to solve  (step4 : memoization-top-down)
    public int cost3(int[] days, int[] costs) {
        int n = days.length; 
        dp = new int[n+1];

        for(int i=1; i<=n;i++){
            dp[i] = Math.min(dp[help2(days,i-1,days[i-1]-1)]+ costs[0],Math.min(dp[help2(days,i-1,days[i-1]-7)]+ costs[1], dp[help2(days,i-1,days[i-1]-30)]+ costs[2] ));
        
        }
      /*  System.out.println(Arrays.stream(dp).boxed().collect(Collectors.toList())   ); */
        return dp[n];
        

    }
    int help2(int days[],int si,int day){
        if(day <=0 ) 
            return 0;
        
        int i;
        for(i =si;i>=0 && days[i]>day;i--);
       
        
        return i+1;
    }







    public int cost4(int[] days, int[] costs) {
        int n = days[days.length-1];
        int[] total_days = new int[n+1];
        List<Integer> mydays = Arrays.stream(days).boxed().collect(Collectors.toList());
        for(int d=1;d <= n;d++){
            if(mydays.contains(d)){
               if(d-7 < 0)
                    total_days[d] =total_days[d-1] + Math.min(costs[0],Math.min(costs[1],costs[2])) ;
               else if(d-30 <0)
                    total_days[d]= Math.min(total_days[d-1]+ Math.min(costs[0],costs[2]),total_days[d-7]+ costs[1]);
               else
                    total_days[d]= Math.min(Math.min(total_days[d-1]+ costs[0],total_days[d-7]+ costs[1]),total_days[d-30]+costs[2]);
            }
            else
                total_days[d] = total_days[d-1];
                
        }
        return total_days[n];       
    }
    



    }


  

