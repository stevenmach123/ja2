
import java.util.Arrays;
import java.util.Comparator;

public class MinimumArrows {
    public int arrows(int[][] points){
        Arrays.sort(points,new Comparator<int[]>() {
            @Override
            public int compare(int[] a,int[] b ){
                return Integer.compare(a[1], b[1]);  
            }
        });
       
        int count = 1;
        int pass = points[0][1];
        for(int i=0;i<points.length;i++){
            if(pass < points[i][0] ){
                count++; 
                pass = points[i][1];  
            }
            

        }
        return count;  

    }

    public int arrows2(int[][] points){
        Arrays.sort(points,(a,b)-> Integer.compare(a[1],b[1]));
        int count = 0;
        int pass = 0;
        for(int i=0;i<points.length;i++){
            if(count==0 || pass < points[i][0] ){
                count++; 
                pass = points[i][1];  
            }
            

        }
        return count;  


    }

    public int arrows3(int[][] points){
        Arrays.sort(points,(a,b)-> Integer.compare(a[0],b[0]));
        int count =1;
        int end = Integer.MAX_VALUE;
        for(int i=0;i<points.length;i++){ 
            if( points[i][0] > end  ) {
                count++;end = points[i][1];
            }
            else end = Math.min(end,points[i][1]);


        }
        return count;
    }







}
