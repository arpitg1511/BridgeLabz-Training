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
    public ListNode swapPairs(ListNode head) {
        ListNode ahead = head != null && head.next != null ? head.next : head;
        ListNode curr = head;
        ListNode pre = null;
        while(curr != null) {
            if(curr.next != null) {
                if(pre != null) pre.next = curr.next;

            pre = curr;
            ListNode temp = curr.next.next;
            curr.next.next = curr;
            curr.next = temp;
            curr = temp;
            }

            else curr = null;
        }

        return ahead;
    }
}