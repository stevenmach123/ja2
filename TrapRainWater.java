
public class TrapRainWater {
    public int trap(int[] height) {
        int store[][] = new int[height.length][2];
        int max_left =Integer.MIN_VALUE;
        for(int i=1;i<height.length;i++){
            if(height[i-1] > max_left)
                max_left = height[i-1];
            store[i][0] = max_left;
        }

        int max_right =Integer.MIN_VALUE;
        for(int i=height.length-2;i>=0;i++){
            if(height[i+1] > max_right)
                max_right = height[i+1];
            store[i][1] = max_right;
            
        }
        int total =0;
        for(int i=1;i<height.length-1;i++){
            int space =Math.min(store[i][0],store[i][1]);
            if(space - height[i] >0){
                total  +=space - height[i];
            }
        }
        return total;
        


        
    }   
    
    public int trap2(int[] height) { 
        int left =0;
        int right=height.length-1;
        int total =0; int pl=0; int pr=0; 
        while(left <right ){
            if(height[left]<= height[right]){
                pl= Math.max(pl,height[left]);
                total += pl- height[left];
                left++;
            }else{
                pr= Math.max(pr,height[right]);
                total +=pr-height[right];
                right--;

            }

        }

        return total;
    }
}
