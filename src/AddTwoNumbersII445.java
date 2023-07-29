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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = rev(l1);
        ListNode t2 = rev(l2);

        int carry =0;
        int sum = 0;
        ListNode t = new ListNode(0);

        while(t1 != null || t2 != null || carry != 0)
        {
            if(t1 != null)
            {
                carry += t1.val;
                t1 = t1.next; 
            }

            if(t2 != null)
            {
                carry += t2.val;
                t2 = t2.next;
            }

            ListNode temp = new ListNode(carry % 10);
            carry /= 10;
            temp.next = t.next;
            t.next = temp;
        }

        return t.next;
    }

    public ListNode rev(ListNode temp)
    {
        ListNode prev = null;
        ListNode curr = temp;
        ListNode next = null;

        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next; 
        }

        return prev;
    }
}
