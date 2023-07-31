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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ans = head;
        ListNode helper = head;
        int k = n;

        while(k > 0 )
        {
            helper = helper.next;
            k--;
        }
        // ListNode prev = null;
        if(helper == null)
            return head.next;
        while(helper.next != null)
        {
            helper = helper.next;
            // prev = ans;
            ans = ans.next;
        }
        
        ans.next = ans.next.next;

        return head;
    }
}
