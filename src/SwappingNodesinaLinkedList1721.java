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
    public ListNode swapNodes(ListNode head, int k) {
        
        if(head == null)
            return head;
        ListNode kStart= head;
        int flag=k;
        int len=1;
        ListNode temp =head;
        while(temp != null)
        {
            temp = temp.next;
            if(flag > 1)
                kStart = kStart.next;
            flag--;
            len++;
        }

        ListNode kEnd = head;
        int i=1;
        while(i < (len - k )){
            kEnd = kEnd.next;
            i++;
        }
        int t= kStart.val;
        int t1 = kEnd.val;
        kStart.val = t1;
        kEnd.val = t;
        // System.out.println(kStart.val + " " + kEnd.val);

        return head;
    }
}
