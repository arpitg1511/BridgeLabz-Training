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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;

        if(head.next == null) return head;

        ListNode ans = head;
        ListNode c = head.next;

        while(c != null) {
            if(c.val != head.val) {
                head.next = c;
                head = head.next;
            }
            c = c.next;
        }

        head.next = null;
        return ans;
    }
}