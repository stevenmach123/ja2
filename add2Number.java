
import java.util.ArrayList;

public class add2Number {

    static ArrayList<Integer> traverseList(ListNode l) {
        ListNode curr = l;
        ArrayList<Integer> a = new ArrayList<>();
        while (curr != null) {
            a.add(curr.val);
            curr = curr.next;
        }
        return a;
    }

    static ListNode list(int[] i) {
        ListNode head = new ListNode();
        ListNode curr = head;
        for (int e : i) {
            curr.next = new ListNode(e);
            curr = curr.next;

        }
        return head.next;
    }

    public ListNode add2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        int carry = 0;
        ListNode curr = head;
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = carry + val1 + val2;
            int last = sum % 10;
            carry = sum / 10;
            curr.next = new ListNode(last);
            curr = curr.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return head.next;

    }

    public ListNode add1(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();

        ListNode p1 = l1;
        ListNode p2 = l2;
        int mul = 1;
        int total1 = 0;
        int total2 = 0;
        int carry1 = 0;
        int carry2 = 0;

        int mul1 = 1;
        int mul2 = 1;

        while (p1 != null || p2 != null) {

            if (p1 != null) {
                mul1 = mul;
                total1 += p1.val == 0 ? 10 * mul : p1.val * mul;
                if (carry1 == 1)
                    total1 -= 1 * mul;

                if (p1.val == 0)
                    carry1 = 1;
                else
                    carry1 = 0;

            }
            if (p2 != null) {
                mul2 = mul;
                total2 += p2.val == 0 ? 10 * mul : p2.val * mul;
                if (carry2 == 1)
                    total2 -= 1 * mul;

                if (p2.val == 0)
                    carry2 = 1;
                else
                    carry2 = 0;

            }

            if (p1 != null) {
                p1 = p1.next;

            }
            if (p2 != null) {
                p2 = p2.next;
            }
            mul *= 10;

        }
        if (carry1 == 1) {
            total1 -= 10 * mul1;
        }
        if (carry2 == 1) {
            total2 -= 10 * mul2;

        }

        int sum = total1 + total2;
        Integer t1 = total1;
        Integer t2 = total2;

        System.out.println(t1.toString() + " " + t2.toString());
        int new_sum = sum;
        ListNode curr = head;
        if (sum == 0) {
            curr.next = new ListNode(0);
            curr = curr.next;
        }

        while (new_sum != 0) {

            int last = new_sum % 10;
            new_sum = new_sum - last;
            new_sum = new_sum / 10;
            curr.next = new ListNode(last);
            curr = curr.next;

            /*
             * curr.val = last;
             * curr.next = new ListNode();
             * curr = curr.next; last node with empty curr.val
             */
        }

        return head.next;

    }

}