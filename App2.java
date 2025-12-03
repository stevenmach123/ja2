import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
class Pair{
    int e;
 }

public class App2 {
    public static void main(String[] args) throws Exception {
        
     
        
        the the1  =new the();
        the1.stream1();
        char[][] src = {{'a','b'},{'c','d'}};
        char[][] des = new char[src.length][];
        System.arraycopy(src, 0, des, 0, src.length);
        //way1:
        List<Integer> m1 =  Arrays.asList(src).stream().map(x->x.length).collect(Collectors.toList());
        
        //NOTE:  List<int[]/Object> s1 = Arrays.asList(new int[]{1,2}) also int[]

        
    
        System.out.println("---");
        
        List<int[]> s1 = Arrays.asList(new int[]{1,2}, new int[]{3,4});
        List<int[]> d1 = new ArrayList<>();
        for(int[] i :s1){
            int[] dess = new int[i.length];
            System.arraycopy(i, 0, dess, 0, i.length);   
            d1.add(dess);
        }     
        d1.get(0)[0]= 100; 
        System.out.println(s1.get(0)[0]);
        System.out.println(d1.get(0)[0]);


        Pair[][] c1 = new Pair[3][2];
        c1[1][1] = new Pair(); // null


        Integer[][] c2 = new Integer[2][2]; //null, same with String

        
        Integer[] a = new Integer[]{1,2,3,4,5,6}; // same
        Integer[] b = new Integer[7];
        int[] bi = new int[]{1,2,3,4,5,6};
        int[] ai = new int[7];
        Arrays.fill(ai,1);
        
        System.arraycopy(bi, 1,ai, 2, 3);
        System.out.println(Arrays.stream(bi).boxed().collect(Collectors.toList()));
        
       

       ListNode l41 = help1.list(new int[]{1,4,5});
       ListNode l42 = help1.list(new int[]{1,3,4});
       ListNode l43 = help1.list(new int[]{2,6});
       ListNode lar[] = new ListNode[]{l41,l42,l43};
       LinkedList l[] = new LinkedList[lar.length];


       ArrayList rl = new ArrayList<>();
       help1.convertLL(lar, l); 
       for(LinkedList o:l){    
           rl.add(o);
       }

        rl = new ArrayList<>();
        help1.convertLL(lar, l); 
        for(LinkedList o:l){    
            rl.add(Arrays.asList(o.toArray()));
        }




    Integer[] aa = new Integer[5];
    LinkedList l32 = new LinkedList<>(Arrays.asList(new Integer[]{1,4,5,7}));
    aa[0]=10; aa[1]=20; aa[2]=30;aa[3]=40;aa[4]=100;
    l32.toArray(aa);
    
    System.out.println("--- 49. anagram ");
    anagram ama = new anagram();
    //System.out.println(ama.g(new String[]{"eat","tea","tan","ate","nat","bat"}));
    

    






    }
}

 
    

