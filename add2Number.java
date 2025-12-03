public class add2Number {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int reminder = 0;
        int sum =0;
        ListNode head  = new ListNode();

        ListNode t = head ;
        while(l1  != null || l2 !=null || reminder != 0 ){      
            ListNode temp = new ListNode();
           
            sum =reminder;
            if(l1 != null){
                sum +=l1.val ;
                l1 = l1.next;
            }      
            if(l2 !=null){
                sum += l2.val;
                l2 = l2.next;
            }
            reminder = sum /10;
            temp.val = sum % 10; 
            t.next  = temp ;
            t= t.next;
        }

        return head.next;
    }
}
