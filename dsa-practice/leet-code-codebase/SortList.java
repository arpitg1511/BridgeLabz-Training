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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode mid = middle(head);
        ListNode l2 = mid.next;
        mid.next = null;
        
        ListNode s1 = sortList(head);
        ListNode s2 = sortList(l2);
        return merge(s1, s2);
    }

    public static ListNode middle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static ListNode merge(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode ans = new ListNode(0);
        ListNode curr = ans;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
                curr = curr.next;
            }

            else {
                curr.next = l2;
                l2 = l2.next;
                curr = curr.next;
            }
        }

        while(l2 != null) {
            curr.next = l2;
            l2 = l2.next;
            curr = curr.next;
        }

        while(l1 != null) {
            curr.next = l1;
            l1 = l1.next;
            curr = curr.next;
        }

        return ans.next;
    }
}