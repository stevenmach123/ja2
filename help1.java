
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

public class help1 {
    static <T> ListNode list(T[] i){
        ListNode head = new ListNode();
        ListNode curr = head;
        
        for(T e: i ){
            int f = (int)e;
            curr.next = new ListNode(f);
            curr = curr.next;
        
        }
        return head.next;
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

    static List traverseList(ListNode l){
        ListNode curr = l;
         List a = new ArrayList<>();
        while(curr !=null){
            a.add(curr.val);
            curr = curr.next;
        }
        return a;
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
    static List<List<Object>>  li2d(int[][] matrix){
        List<List<Object>> t = new  LinkedList<List<Object>>();
        for(int i=0;i<matrix.length;i++){
            List<Object>  a= Arrays.stream(matrix[i]).boxed().collect(Collectors.toList()); 
            t.add(a);
        }
        return t;

    }

    
}
