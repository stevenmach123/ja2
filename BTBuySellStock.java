
public class BTBuySellStock {
    public int max1(int[] prices) {
        int small_buy =Integer.MAX_VALUE; 
        int diff = 0;
        for(int share: prices){
            if(small_buy> share)
                small_buy =share; 
            int differ = share -small_buy;
            if(differ >diff )
                diff = differ;    
            
        }
        return diff;

    }
    public int max2(int[] prices){
        int max =0,height =1,low=0 ; 
        while(height <prices.length){
            
            if(prices[height] <=   prices[height-1]  ){
                max=Math.max(max,prices[height-1]-prices[low]);
                if(prices[height] < prices[low])
                    low =height; 
            }
            else if(height == prices.length-1 ){
                max=Math.max(max,prices[height]-prices[low]);
            }
            
            height++;
        }
        return max; 
        
    }
    public int max3(int[] prices){
        int max=0,height=1,low=0;
        while(height <prices.length){
            max = Math.max(max,prices[height]-prices[low]);
            if(prices[height] < prices[low]){
                low =height; 
            }
            height++;
        }
        return max;

    
    }


}
