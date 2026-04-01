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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n == 0) return null;
        if(n == 1) return lists[0];

        ListNode curr = lists[0];

        for(int i = 1; i < n; i++){
            curr = merge(lists[i], curr);
        }

        return curr;
    }

    public ListNode merge(ListNode a, ListNode b){
        if(a == null) return b;
        if(b == null) return a;

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while(a != null && b != null){
            if(a.val <= b.val){
                curr.next = a;
                a = a.next;
            }
            else{
                curr.next = b;
                b = b.next;
            }

            curr = curr.next;
        }

        curr.next = (a != null)? a : b;
        return dummy.next;
    }
}
