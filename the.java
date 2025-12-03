import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class the{
    
    Object test(){
        int x =1;
       
        if(x>1){
            return (Object)true;
        }
        else{
            return (Object)3;
        }

    }
    void stream1(){
        String x[] = {"12","3"};

        Integer[] m1 = Arrays.stream(x).map(c -> Integer.valueOf(c)).filter(c->{
            if(c <= 3){
                System.out.println(c);
                return true;
            }else return false;
        } ).toArray(Integer[]::new);
        Arrays.toString(m1);

    }
    void stream2(){
        List<Integer> c  = new LinkedList();
        Queue<Integer> c2 = new LinkedList();
        Deque<Integer> c3 = new LinkedList();
        

    }
    
}