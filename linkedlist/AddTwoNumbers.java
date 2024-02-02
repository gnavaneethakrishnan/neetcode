package neetcode.linkedlist;

public class AddTwoNumbers {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;

        ListNode dummy = new ListNode(0);
        ListNode result = dummy;


        while (l1 != null && l2 != null) {

            int sum = 0 + carry;

            if (l1 != null) {
                sum = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum = sum / 10;
            carry = sum % 10;
            result.next = new ListNode(sum);
            result = result.next;
        }

        if(carry == 1) result.next = new ListNode(carry);
        return dummy.next;
    }




}
