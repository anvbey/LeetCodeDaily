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
        
        ListNode temp = head;
        while(temp != null && temp.next != null)
        {
            ListNode first = temp;
            ListNode second = temp.next;

            int ans = first.val;
            first.val = second.val;
            second.val = ans;

            temp = temp.next.next;
        }

        return head;
    }
}
