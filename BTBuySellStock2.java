
public class BTBuySellStock2 {
    public int total(int[] prices){
        int total =0;
        int height =0;
        
        while(height < prices.length-1 ){
            if(prices[height] < prices[height+1]){
                total += prices[height+1]- prices[height];    
                    
            }
           
            height++;

        }
    
        return total;
    }

    public int maxProfit(int[] prices) {
        int hold = 0;
        int profit = 0;
        int cur =1;
        while(cur <= prices.length){
            if(cur < prices.length && prices[cur] < prices[cur-1]) {   
                profit += prices[cur-1] -prices[hold]; 
                hold =cur;
            }
            else if(cur ==prices.length && hold != prices.length-1){
                profit += prices[cur-1] -prices[hold];
                hold =prices.length ;
            }     
            cur++;
        }
        return profit;
    }
    public int total3(int[] prices){ 
        int low=0,height =0; 
        int total =0;  
        while(height < prices.length-1 ){
            
            if(prices[height] >= prices[height+1] ){
                total += prices[height] - prices[low]; 
                low = height+1; 
            }
            else if(height == prices.length-2 ){
                total += prices[height+1] - prices[low];
            }
           

            height++;

        }
        return total;
    }
    
    public int total4(int[] prices){
       
        int low=0,height =0; 
        int total =0; 
        int price=0;    
        while(height < prices.length-1 ){ 
           
            if(prices[height] < prices[height+1]){
                price = prices[height+1]-prices[low]; 
                if(height == prices.length-2)
                    total += price;
            }
            else{
               total +=price;
               low = height+1;  
               price =0;
            }
            height++;
            

        }
        return total;
        
    }
    public int total5(int[] prices){
        int buy=0,sell=0;
        int cur= 1;  
        int total = 0;
        int n = prices.length; 
        while(cur < n){
            for( buy =prices[cur-1];cur<n && buy > prices[cur];cur++){
                buy = prices[cur]; 
            }  
            for(sell=prices[cur];cur <n && sell > prices[cur-1];cur++){
                sell = prices[cur];
            }
             total += buy -sell;
        
            
        }
        return total;




    }














   




}
