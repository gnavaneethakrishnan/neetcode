package neetcode.linkedlist;

public class RemoveNthNode {
    
    public ListNode removeNthNodeFromEnd1(ListNode head, int n) {

        if(head.next == null) {
            head = null;
            return head;
        }

            int length = 1;

            ListNode current = head;

            while(current != null) {
                current = current.next;
                length++;
            }

            int nodeToRemove = length - n;

            ListNode temp = head;
            ListNode pre = temp;

            for (int i = 0; i < nodeToRemove; i++) {
                 pre = temp;
                temp = temp.next;
            }

            pre.next = temp.next;
            temp.next = null;


        return head;
    }

    //efficient solution traversing the linkedlist once
    public ListNode removeNthNodeFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        //start from dummy, not head
        ListNode slow = dummy;
        ListNode fast = dummy;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        //make the fast pointer stand in the last node
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }


}
