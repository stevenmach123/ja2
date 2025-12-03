
import java.util.LinkedList;

public class help_merge {
   
    static int compare(int a,int b){
        return a-b;
    }
    static LinkedList merge(LinkedList<Integer> l1,LinkedList<Integer> l2){
        LinkedList<Integer> merge= new LinkedList<>();
        while(!l1.isEmpty() && !l2.isEmpty() ){
            if(  compare(l1.getFirst(),l2.getFirst()) <0 ){
                int a = l1.pollFirst();
                merge.add(a);
                
            }
            else{
                int a = l2.pollFirst();
                merge.add(a);
            
            }
                    
        }

        while(!l1.isEmpty()){
           merge.add(l1.pollFirst());
           
        }
        while(!l2.isEmpty()){
            merge.add(l2.pollFirst());
        }
        return merge;
        
    }

    static  Integer[] merge2(Integer[] r1,Integer[] r2){
        int x= 0;int y= 0;int z=0;
        Integer[] merge = new Integer[r1.length+r2.length];
        while( x<r1.length && y< r2.length){
          
            if(compare(r1[x],r2[y]) < 0){
                merge[z]= r1[x]; x++;
            }
            else{
                
                merge[z]= r2[y]; y++;
            }
            z++;
        }
        if(x< r1.length)
             System.arraycopy(r1,x,merge,z,r1.length-x);
        else if(y<r2.length)
            System.arraycopy(r2,y,merge,z,r2.length- y);

        return merge;
    }
}
