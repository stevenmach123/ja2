import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class help1 {
    static ListNode list(int[] i){
        ListNode head = new ListNode();
        ListNode curr = head;
        for(int e: i ){
            curr.next = new ListNode(e);
            curr = curr.next;
        
        }
        return head.next;
    }

    static ArrayList<Integer> traverseList(ListNode l){
        ListNode curr = l;
         ArrayList<Integer> a = new ArrayList<>();
        while(curr !=null){
            a.add(curr.val);
            curr = curr.next;
        }
        return a;
    }
    static void convertLL(ListNode lists[],LinkedList l[]){
        for(int i=0; i<lists.length; i++){
        
            l[i]= new LinkedList<>();
            ListNode cur= lists[i];
            while(cur !=null){
                l[i].add(cur.val);
                cur = cur.next;
            }
        }
    }

    static ListNode convertLN(LinkedList<Integer> l){
        ListNode head = new ListNode();
        ListNode curr = head;
        for(Integer i: l){
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        return head.next;
    }
    static ListNode copyLN(ListNode head){
            ListNode l = new ListNode();
            ListNode h= l;

          
            while(head!=null){    
                l.next = new ListNode(head.val);
                l= l.next;
                head= head.next;
            }
            return h.next;
            
    }

    static Integer amount(ListNode cur){
        int x = 0;
        while(cur !=null){
            cur =cur.next;
            x++;
        }
        return x;
    }
    

            //////

    static <T> void  convert_obj(T[] v){
        for(int i=0 ;v.length;i++){

        }
    }
    static String[] chars_string(char[][] src){
        String x[] = new String[src.length];
        int i=0;
        for(char[] s :src){
            x[i]= String.copyValueOf(s);
            i++;
        }
        return x;
    }


    static List<List<Object>> li2dg(List x){
        List<List<Object> > t =  new  LinkedList<List<Object>>();
        
        return t;
    }
    static List<List<Object>>  li2d(Object[][] matrix){
        List<List<Object>> t = new  LinkedList<List<Object>>();
        for(int i=0;i<matrix.length;i++){
            List<Object>  a= Arrays.stream(matrix[i]).collect(Collectors.toList()); 
            t.add(a);
        }
        return t;

    }
    static List<Object> li1d(Object[] arr){
        List<Object> t = new  LinkedList<Object>(Arrays.asList(arr));
        return t;
    }



     static void dprint( Integer[] e){
            for(int r=0; r<e.length ;r++){
            
                    System.out.print(e[r]);
                    System.out.print(' ');
                
            }
        

    }
    static void lprint(LinkedList[] e){
        for(int i =0;i< e.length;i++){
            System.out.print(e[i]);
            System.out.print(' ');
        }
        System.out.println();
    }

     
   

    
}
