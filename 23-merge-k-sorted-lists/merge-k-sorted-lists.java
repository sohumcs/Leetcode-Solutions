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
import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        int step = 1;
        while (step < lists.length) {
            for (int i = 0; i < lists.length - step; i += step * 2) {
                lists[i] = merge2Lists(lists[i], lists[i + step]);
            }
            step *= 2;
        }
        return lists[0]; // Return the merged list head
    }

    private ListNode merge2Lists(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        // Traverse over the lists until both or one of them becomes null
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                prev.next = head1; // Add l1 node to the list
                head1 = head1.next;
            } else {
                prev.next = head2; // Add l2 node to the list
                head2 = head2.next;
            }
            prev = prev.next; // Move the prev pointer forward
        }

        // If either list still has nodes left, append them
        if (head1 != null) prev.next = head1;
        else prev.next = head2;

        return dummy.next; // Return the merged list
    }
}