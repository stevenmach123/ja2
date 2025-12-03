import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.AbstractMap.SimpleEntry;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("* Building short");
        buildingshort e = new buildingshort();
        boolean[][] t1 = new boolean[][]{{true,false,false},{false,false,false},{true,true,false},{false,false,true},{false,true,true}};
        boolean[][] t2 = new boolean[][]{{false,true,false},{true,false,false},{true,true,false},{false,true,false},{false,true,true}};

        System.out.println(e.distance(t1,new boolean[]{true,true,true})); 
        System.out.println("* Subarrays Sum Equals Target");
        SumofSubArray  sumSubArray = new SumofSubArray();
        int[] sumArr1 = new int[]{10,3,5,8,6,12,20,15,31};
        int[] sumArr2 =new int[]{3,4,7,2,6};
        //System.out.println(sumSubArray.array(sumArr1,31));
        //System.out.println(sumSubArray.array(sumArr2,8));
        //System.out.println(sumSubArray.array(sumArr2,2));
        //System.out.println(sumSubArray.array(sumArr2,6));
        System.out.println("* Anagram"); 
        
      
        char[] vy = new char[]{'a','b'};
        System.out.println(String.valueOf(vy)); //only work for char[]
       
        Character ex ='b';
        int x=  'a'-ex;
        System.out.println(x);
        

        ArrayList<String>  ar = new ArrayList<>(Arrays.asList("a","a"));
        Set<String> sr = new HashSet<>(ar);
        System.out.println(sr);

        char[] vx = new char[2];   
        char a6= 2; //number convert to distinct char
        System.out.println((int)vx[0]);
        System.out.println(a6); 
        System.out.println("* Minimum cost for tickets"); 
        minCostforTickets ticket = new minCostforTickets();
        System.out.println(ticket.cost2(new int[]{1,2,4,9},new int[]{2,5,12}));
        System.out.println(ticket.cost2(new int[]{2,4,5,9,12},new int[]{2,5,12}));
        
        System.out.println("* CombinationSumII");
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> el = new ArrayList<>(Arrays.asList(1,2));
        res.add(el);
        el.set(0, 10);
        System.out.println(el);

    
        System.out.println("* courseSchedule");
        courseSchedule course = new courseSchedule();
        Set<Integer> s = new HashSet<>(Arrays.asList(1)); 
        Iterator<Integer>  si = s.iterator();
        System.out.println(si.hasNext());

        boolean[] sd = new boolean[2];
        System.out.println("* AVL tree");
        AVLtree avl = new AVLtree();
        avl.TEST();
        
        System.out.println("* numofEnclaves");
        numofEnclaves g = new numofEnclaves();
        g.num(new int[][]{{1,1}}); 
        

        
      
       
       
       
    }
}
