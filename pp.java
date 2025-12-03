import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class pp {
    public int[][] merge(int[][] intervals) {
        var list = new LinkedList<Integer[]>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0] );

        list.add(new Integer[]{intervals[0][0],intervals[0][1]});
        for(int i =1;i< intervals.length;i++ ){
            var cur = list.peek();
            
            if(intervals[i][0]  >=   cur[1] ){
                System.out.println("-" + Arrays.toString(cur) );
                int start = Integer.max(intervals[i][0], cur[0]);
                int end = Integer.max(intervals[i][1], cur[1]);
                list.set(list.size()-1, new Integer[]{start,end});         
            }
            else
                list.add(new Integer[]{intervals[i][0],intervals[i][1]});
                
        }
       
        return list.stream().map(v->new int[]{v[0],v[1]}).toArray(int[][]::new);
        
    }
    
}


