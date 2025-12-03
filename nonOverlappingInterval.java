
import java.util.Arrays;

public class nonOverlappingInterval {
    public int eraseOverlapIntervals(int[][] intervals) { 
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        
        int count=0;
        int pass = intervals[0][1];
        boolean initial = true;  
        for(int[] p:intervals){
            if(initial){
                initial= false; continue;
            }
            if(pass <= p[0]){
                pass= p[1]; continue;
            }
            count++;
        }
        return count;
        
    }
    public int eraseOverlapIntervals2(int[][] intervals) {  
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int count = 0; 
        int pass =  Integer.MIN_VALUE;
        for(int[] p:intervals ){
            if(pass  <= p[0]){
                pass = p[1];continue; 
            }

            pass= Math.min(pass,p[1]); 
            count++;
        }
        return count;
    }

    
}
