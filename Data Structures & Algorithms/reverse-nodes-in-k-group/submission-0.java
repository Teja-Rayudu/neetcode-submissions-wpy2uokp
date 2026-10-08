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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1 || head == null || head.next == null) return head;
        int len = 0;
        ListNode curr = head;

        while(len < k){
            if(curr == null) return head;
            curr = curr.next;
            len++;
        }

        len = 0;
        ListNode prev = null, next = null;
        curr = head;

        while(len != k){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            len++;
        }

        head.next = reverseKGroup(next, k);
        return prev;
    }
}
