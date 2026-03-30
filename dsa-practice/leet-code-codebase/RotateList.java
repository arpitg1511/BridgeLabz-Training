class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Find length of the list
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        // Find the actual rotation needed
        k = k % len;
        if (k == 0) return head; // No rotation needed

        // Connect tail to head (forming a circular list)
        tail.next = head;

        // Find new tail (len - k - 1) and new head (len - k)
        ListNode newTail = head;
        for (int i = 0; i < len - k - 1; i++) {
            newTail = newTail.next;
        }

        // New head is next of newTail
        ListNode newHead = newTail.next;
        newTail.next = null; // Break the circular link

        return newHead;
    }
}
