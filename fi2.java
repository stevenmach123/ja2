import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;


public class fi2 {
     public static void main (String[] args){


        convertSLtoBST cl_bst = new convertSLtoBST();
        ListNode n1=  help1.list(new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15});
        ListNode n2=  help1.list(new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14});
        ListNode n3=  help1.list(new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12});

        ListNode n4=  help1.list(new Integer[]{1,2,3,4});
        ListNode n41=  help1.list(new Integer[]{1,2,3,4,5});
        ListNode n5=  help1.list(new Integer[]{1,2});


        ListNode n6=  help1.list(new Integer[]{1,2,3,4,5,6});
        ListNode n6_2=  help1.list(new Integer[]{1,2,3,4,5,6,7});
        ListNode n6_3=  help1.list(new Integer[]{1,2,3,4,5,6,7,8});
        ListNode n6_4=  help1.list(new Integer[]{1,2,3,4,5,6,7,8,9,10});
    
       /*  System.out.println("bst1");
        System.out.println(help2.TreeManifest(cl_bst.bst1(n1)));
        System.out.println(help2.TreeManifest(cl_bst.bst1(n2)));
        System.out.println(help2.TreeManifest(cl_bst.bst1(n3)));
        System.out.println(help2.TreeManifest(cl_bst.bst1(n4)));
        System.out.println(help2.TreeManifest(cl_bst.bst1(n5)));
        System.out.println("bst2");
        System.out.println(help2.TreeManifest(cl_bst.bst2(n1)));
        System.out.println(help2.TreeManifest(cl_bst.bst2(n2)));
        System.out.println(help2.TreeManifest(cl_bst.bst2(n3)));
        System.out.println(help2.TreeManifest(cl_bst.bst2(n4)));
        System.out.println(help2.TreeManifest(cl_bst.bst2(n5)));
        System.out.println("bst3");
        System.out.println(help2.TreeManifest(cl_bst.bst3(n1)));
        System.out.println(help2.TreeManifest(cl_bst.bst3(n2)));
        System.out.println(help2.TreeManifest(cl_bst.bst3(n3)));
        System.out.println(help2.TreeManifest(cl_bst.bst3(n4)));
        System.out.println(help2.TreeManifest(cl_bst.bst3(n41)));
        System.out.println(help2.TreeManifest(cl_bst.bst3(n5)));

        System.out.println("bst1_1");
        System.out.println(help2.TreeManifest(cl_bst.bst1_2(n1)));
        System.out.println(help2.TreeManifest(cl_bst.bst1_2(n2)));
        System.out.println(help2.TreeManifest(cl_bst.bst1_2(n3)));
        System.out.println(help2.TreeManifest(cl_bst.bst1_2(n4)));
        System.out.println(help2.TreeManifest(cl_bst.bst1_2(n41)));
        System.out.println(help2.TreeManifest(cl_bst.bst1_2(n5)));
       // System.out.println(help2.TreeManifest(cl_bst.bst2(n1)));
       System.out.println("bst2_2");
       System.out.println(help2.TreeManifest(cl_bst.bst2_2(n1)));
       System.out.println(help2.TreeManifest(cl_bst.bst2_2(n2)));
       System.out.println(help2.TreeManifest(cl_bst.bst2_2(n3)));
       System.out.println(help2.TreeManifest(cl_bst.bst2_2(n4)));
       System.out.println(help2.TreeManifest(cl_bst.bst2_2(n41)));
       System.out.println(help2.TreeManifest(cl_bst.bst2_2(n5)));

       System.out.println("bst4");
      
       System.out.println(help2.TreeManifest(cl_bst.bst4(n4)));
       System.out.println(help2.TreeManifest(cl_bst.bst4(n41)));
       System.out.println(help2.TreeManifest(cl_bst.bst4(n6)));
       System.out.println(help2.TreeManifest(cl_bst.bst4(n6_2)));
       System.out.println(help2.TreeManifest(cl_bst.bst4(n6_3)));
       System.out.println(help2.TreeManifest(cl_bst.bst4(n6_4)));
        */


              
        maximalSquare square = new maximalSquare();
        
        char a[][] = new char[][]{{'1','1'},{'1','1'}};
        System.out.println(square.max2(a));
        int t= '1';
        System.out.println(t);
        t= '0';
        System.out.println(t);
     
        System.out.println("----");
        Klargest large  = new Klargest();
        //System.out.println(large.find(new int[]{3,2,1,5,6,4},4));
        
       // System.out.println(large.find3_2(new int[]{1,2,4,3,7,6,4,1,2,8,3,4},9));
    
        
      /*HashMap<String,Integer>  am = new HashMap<>();
      am.put("a", 1);
      am.put("a",2);
      am.put("c",10);
      am.replace("b",3);
      am.replace("a",3);
      am.replace("c",17,3);
      System.out.println(am); */
       taskScheduler schedule = new taskScheduler();
       System.out.println(schedule.interval2(new char[]{'B','B','C','C','A','A','A','D'}, 1));

        /* 
        List<Integer> ak = new LinkedList<>();
        Integer au[] = new Integer[10]; 
        ak.add(1);  ak.add(2);
        Object[] ae = ak.toArray();
        ae[0] = 100; 

       
        */
    
        System.out.println("----"); 
        rotate image = new rotate();
        int[][] pu = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] ps = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};


        System.out.println(help1.li2d(image.turn1(image.hard_copy(ps))) );
        System.out.println(help1.li2d(image.turn2(image.hard_copy(pu))) );
        System.out.println(help1.li2d(image.turn5_1(image.hard_copy(ps))) );
        System.out.println(help1.li2d(image.turn5_2(image.hard_copy(ps))) );
        System.out.println("---"); 
        int[] coins = new int[]{3,2,1};
        Arrays.sort(coins);
        List<Integer> ak = Arrays.stream(coins).boxed().collect(Collectors.toList());
        
        System.out.println(ak);
       
        System.out.println("twoSum");
        twoSum two = new twoSum();
        System.out.println( Arrays.stream(two.sum(new int[]{2,7,11,15},26)).boxed().collect(Collectors.toList())       );
        System.out.println( Arrays.stream(two.sum(new int[]{2,2,2,4},4)).boxed().collect(Collectors.toList())       );
        System.out.println("permutations"); 
        List<Integer> l1  = new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2}));
            
        List<Integer> l2 = new ArrayList<>(l1); 
        l1.set(0,100);
        System.out.println(l1);
        System.out.println(l2);
        l2.add(l2.size(),3); 
        System.out.println(l2);


        System.out.println("gas station ");
        gasStation gas = new gasStation();
        int[] at = new int[]{1,2};  
        int change[] = Arrays.copyOf(at,at.length);
       
        System.out.println( new ArrayList(Arrays.asList(Arrays.stream( change ).boxed().toArray( Integer[]::new ))));
        


        
        System.out.println("Path sum");
        Map.Entry<Integer,Integer> e =   new AbstractMap.SimpleEntry<Integer, Integer>(1,10);
        e.setValue(12);
        Map.Entry<Integer,Integer> e2 =   new AbstractMap.SimpleEntry<Integer, Integer>(2,10);
        Map.Entry<Integer,Integer> e3 =   new AbstractMap.SimpleEntry<Integer, Integer>(3,30);
        Deque<Map.Entry<Integer,Integer>> de = new LinkedList<Map.Entry<Integer,Integer>>(){{
            add(e);add(e2);add(e3);
        }};
        


        Iterator<Map.Entry<Integer,Integer>> va ;
        for(va=de.iterator();va.hasNext();){
            System.out.println(va.next());
        }




    
        List<Integer> p = new ArrayList<>(Arrays.asList(1,2,3)); 
        Integer[] ar0 = new  Integer[3];
        p.toArray(ar0);
        
        List<Integer> ll1  = new LinkedList<>(Arrays.asList(10,20,30));
        List<Integer> ll2  = new LinkedList<>((LinkedList) ll1);
       // List<Integer> x =(LinkedList<Integer>) Arrays.asList(1,2);
        //x.remove(0);
        ll2.remove(0);
        
        System.out.println(ll1.size()+" "+ll2.size());
        System.out.println("DisplayTableofRestaurant");
       
        
        Map<Integer,Integer> tmap = new TreeMap<>();
        tmap.put(3, 10);
        tmap.put(4,30);
        tmap.put(5,20);
        tmap.put(6,15);
        
        Map<Integer,Integer> tmap2  = new TreeMap<>(new y(tmap));
        tmap2.putAll(tmap); 
        System.out.println(tmap2);
        List<String> eq =new LinkedList<>();
        System.out.println("Number of Islands");
        numberOfIsland isl = new numberOfIsland(); 
        isl.numIslands(new char[][]{{'1','0','1','1','1'},{'1','0','1','0','1'},{'1','1','1','0','1'}});

        LinkedList<Integer[]> list = new LinkedList<>();
        list.add(new Integer[]{1, 2, 3});
        list.add(new Integer[]{4, 5, 6});


        Integer[][] result = list.stream().toArray(Integer[][]::new);
        System.out.println(result.toString() );
    }
   
    static class y implements Comparator<Integer>{
        private Map<Integer,Integer> map;
        public y(Map<Integer,Integer> map){
            this.map =map;
        }
        @Override 
        public int compare(Integer s1,Integer s2){
            return  s1.compareTo(s2) !=0 ? map.get(s1).compareTo(map.get(s2)):0;
        }
        
    }


    class Pair{
        String a;
        Pair(String a){
            this.a = a;
        }
        Pair(){}
    }






   
}