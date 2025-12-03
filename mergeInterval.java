import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class mergeInterval {
    
  
    public int[][] merge(int[][] intervals) {
        List<int[]> result =new LinkedList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
    
        int start=intervals[0][0], end=intervals[0][1];    
        for(int[] inter :intervals){
            if( inter[0] <=  end)
                end = Math.max(end,inter[1]);
            else{
                result.add(new int[]{start,end});
                start = inter[0];
                end= inter[1];
            }
            
        }
        result.add(new int[]{start,end});
        
        return result.stream().toArray(int[][]::new); 
        
    }
}
