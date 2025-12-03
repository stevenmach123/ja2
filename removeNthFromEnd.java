
class removeNthFromEnd{
    ListNode tail1(ListNode cur){
        while(cur.next !=null){
            cur= cur.next;
        }
        return cur;
    }
    ListNode nail1(ListNode cur,ListNode tail){
        while(cur.next !=tail){
            cur = cur.next;
        }
        return cur;
    }
    static Integer amount(ListNode cur){
        int x = 0;
        while(cur !=null){
            cur =cur.next;
            x++;
        }
        return x;
    }



    public ListNode nremove1(ListNode h, int n){
            ListNode head= help1.copyLN(h);
            int amount = amount(head);

            if(head.next ==null )
                return null;
        
            if(n> amount )
                return head;

            int x= 0;
            ListNode tail = tail1(head);
        
            while( x< n){
                
                if(tail == head){
                    
                    break;
                }
                ListNode nail = nail1(head,tail);
                tail = nail;
            
                x++;
            
            }
            
            if(x== n){
                tail.next = tail.next.next;
                return head;
            }
            else{
                return head.next;
            }
        


    }


    public ListNode nremove2(ListNode h, int n){
        ListNode head= help1.copyLN(h);
        int amount = amount(head);
        if(head.next ==null )
            return null;
    
        if(n> amount )
            return head;

        int x= 0;
        ListNode tail = tail1(head);
        ListNode nail = nail1(head,tail);
        x++;
        while(x<n){
            tail = nail; 
            if(tail == head)
                break;
            nail = nail1(head,tail);
            x++;
        }
        /* 
        if(x== n){
            nail.next = tail.next;
            return head;
        }
        else{
            return head.next;
        } */
        if(tail !=head){
            nail.next = tail.next; return head;
        }else{
            return head.next;
        }

    }

   

    ListNode tail2(ListNode h){
        while(h.next !=null){
            h =h.next;
        }
        return h;
    }
    ListNode nail2(ListNode h,ListNode t){
        while( h.next != t  ){
            h =h.next;
        }
        return h;
    }
    
    public ListNode nremove(ListNode head, int n) {
        ListNode t = tail2(head);
       int count =0; 
       ListNode nail  = null;
       while(count < n){
         if(nail != null ){
            t = nail;
         }
         if(t != head){ 
            nail = nail2(head,t) ;
         } 
         
         count++;
       }
       if( t==nail || nail ==null){
            head =head.next;
       }
       else
          nail.next = t.next;
    
       return head;
    }














}