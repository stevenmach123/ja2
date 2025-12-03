
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;
class fi{
    
    public static void main (String[] args){
       
        System.out.println("maze--");
        
        maze maze = new maze();
        char[][] e= {{'+','+','.','+'},{'.','.','.','+'}};
        char[][]e2 = {{'+','+','+'},{'.','.','.'},{'+','+','+'}};
        int[] entrance = {1,2};
        int[] entrance2 = {1,0};
        //System.out.println("maze: "+maze.maze2(e, entrance));
        //System.out.println("maze: "+maze.maze2(e2,entrance2 ));
        //g.set(1,20);

        
        ListNode l1 = add2Number.list(new int[]{0});
        ListNode l2 = add2Number.list(new int[]{0});
         l1=  add2Number.list(new int[]{9,0,0});
         l2 =add2Number.list(new int[]{0,1,0,0,2,0,0});
        add2Number add2Number = new add2Number();
        ListNode l11 = add2Number.add1(l1,l2);
        //System.out.println(traverseList(l1));
    
                
        containDup dup = new containDup();
        //dup.containsDuplicate(new int[]{3,1,-2,4,-200,-7,1,-10});
        //dup.containsDuplicate(new int[]{3,1,2,4,200,7,1,10});

       
        wordSearch search = new wordSearch();


        char[][] board1 = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}} ;
        char[][] board2 = {{'A','A','A','A'},{'A','A','A','A'},{'A','A','A','A'},{'A','A','A','A'}};
        //System.out.println(search.searchWord(board1,"ABCCED"));
        //System.out.println(search.searchWord(board1,"SEE"));
        //System.out.println(search.searchWord(board1,"EZC"));

       //System.out.println(search.searchWord(board2,"AAAAAAAAAAAB"));
       //String word = "hi";
       //word =  new StringBuilder(word).reverse().toString(); 
        //System.out.println(word);



        Integer[] n = {1,2,3,4}; 
        swapNode swap = new swapNode();
        ListNode l3 =help1.list(n);
        System.out.println(l3.val);
       //ListNode L3n = swap.swapPairs2(l3);
    
        System.out.println("--- merge k");
        //System.out.println(swapNode.traverseList(L3n));


        mergeKSort mergek = new mergeKSort();
        ListNode l41 = help1.list(new Integer[]{1,4,5});
        ListNode l42 = help1.list(new Integer[]{1,3,4});
        ListNode l43 = help1.list(new Integer[]{2,6});
        ListNode lar[] = new ListNode[]{l41,l42,l43};

        System.out.println(mergek.merge1(lar));
    

        System.out.println(mergek.state(new LinkedList<Integer>(Arrays.asList(new Integer[]{6,5,3,4,1,2,7,1,4})))   );
        System.out.println(mergek.state(new LinkedList<Integer>(Arrays.asList(new Integer[]{6,5,3,4,1,2,7,1,4,13})))   ); 
        System.out.println(mergek.state(new LinkedList<Integer>(Arrays.asList(new Integer[]{6,5,3,4,1,2})))   ); 


      
        LinkedList<Integer> lo[] = new LinkedList[]{ 
            new LinkedList(Arrays.asList(new Integer[]{9,1,5,3,2})),
            new LinkedList(Arrays.asList(new Integer[]{5,1,3,2,4})),
            new LinkedList(Arrays.asList(new Integer[]{7,6,1}))
        };
        //System.out.println(mergek.merge2(mergek.prep_merge(lo)));

        System.out.println("---");

     
      
        

        removeNthFromEnd end = new removeNthFromEnd();
        ListNode l51 =help1.list(new Integer[]{1,2,3,4,5});
        //System.out.println(help1.traverseList(end.nremove(l51, 1)));
        //System.out.println(help1.traverseList(end.nremove2(l51, 4)));
       // System.out.println(help1.traverseList(end.nremove3(l51, 1)));
        System.out.println("---");


        
        

        sortColors colors= new sortColors();
        int[] ar = {4,4,3,0,1,2,2,4,3,0};
         ar = new int[]{4,0,3,1,4,4,2,0,4,0};
        int[] ar2 = {4,4,5,2,5,1,6,6,6,0,1,3,4};
          ar2 = new int[]{4,1,2,3,6,6,4,4,5,5,0};
          ar2 = new int[]{0,1,2,3,3,3,4,5,4,6,5,4};
          ar2 = new int[]{0,1,2,3,6,5,4,6,4,5,6};
          ar2 = new int[]{4,4,5,5,6,6,0,1,2,3,6};
        int[] ar3 = {3,2,3,2,0,3,2,1};
        
        //Integer[] aq1 = Arrays.stream(colors.sort1(ar, 5)).boxed().toArray(Integer[]::new);
        Integer[] aq2 = Arrays.stream(colors.sort1(ar2, 7)).boxed().toArray(Integer[]::new);
        //Integer[] aq3 = Arrays.stream(colors.sort1(ar3, 4)).boxed().toArray(Integer[]::new);
        System.out.println("---");


        uniqueTree uni = new uniqueTree();
        System.out.println(uni.numTrees(5));
        //System.out.println(uni.numTrees2(6));
        System.out.println(uni.numTrees3(5));
        System.out.println("46.permutation");
        permutation per  = new permutation();
        System.out.println(per.permute2(new int[]{1,2,3}));    
        System.out.println("215. k-largest");
        Klargest kl  =new Klargest();
        kl.find_pq(new int[]{1,2},4 );
        
       System.out.println("130. Surrounded region");
       SurroundedRegion sur = new SurroundedRegion();
       sur.solve(new char[][]{{'O'}}); 
        System.out.println("494 target sum");
        Map<Pair,Integer> m = new HashMap<>();
    
       
       
    }

     static void d2print( char[][] e){
            for(int r=0; r<e.length ;r++){
                for(int c=0;c<e[r].length;c++){
                    System.out.print(e[r][c]);
                    System.out.print(' ');
                }
            }

    }
    static void dprint( Integer[] e){
            for(int r=0; r<e.length ;r++){
            
                    System.out.print(e[r]);
                    System.out.print(' ');
                
            }
            System.out.println();

    }
    static void lprint(LinkedList[] e){
        for(int i =0;i< e.length;i++){
            System.out.print(e[i]);
            System.out.print(' ');
        }
        System.out.println();
    }

   

}