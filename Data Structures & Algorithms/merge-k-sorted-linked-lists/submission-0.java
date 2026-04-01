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

        for(int i = 1; i < n; i++){
            lists[i] = merge(lists[i], lists[i - 1]);
        }

        return lists[n - 1];
    }

    public ListNode merge(ListNode a, ListNode b){
        if(a == null) return b;
        if(b == null) return a;

        if(a.val < b.val){
            a.next = merge(a.next, b);
            return a;
        }
        else{
            b.next = merge(b.next, a);
            return b;
        }
    }
}
