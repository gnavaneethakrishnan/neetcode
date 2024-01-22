package neetcode.linkedlist;

import bootcamp.main;

public class MergeSortedList {
    
    public ListNode mergeSortedList(ListNode list1, ListNode list2) {

        ListNode returnNode = new ListNode(Integer.MIN_VALUE);

        ListNode headNode = returnNode;

        while (list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                returnNode = list1;
                list1 = list1.next;
            } else {
                returnNode = list2;
                list2 = list2.next;
            }

            returnNode = returnNode.next;
        }
    
        if(list1 == null) {
                returnNode.next = list2;
            }
    
            if(list2 == null) {
                returnNode.next = list1;
            }
    
        return headNode.next;
    }

        
    }
