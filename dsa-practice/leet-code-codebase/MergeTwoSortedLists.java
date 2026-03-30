/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode d = new ListNode();
        ListNode temp = d;
        ListNode ans = list1;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                d.next = list1;
                d = d.next;
                list1 = list1.next;
            }
            else {
                d.next = list2;
                d = d.next;
                list2 = list2.next;
            }
        }

        if(list1 == null) d.next = list2;

        if(list2 == null) d.next = list1;

        return temp.next;
    }
}