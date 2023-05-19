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
    public int pairSum(ListNode head) {
        
        ListNode temp = head;
        int len = 0;
        while(temp != null)
        {
            temp = temp.next;
            len++;
        }

        int arr[]= new int[len+1];

        temp = head;
        int max=0;
        int k=len/2-1;
        for(int i=0;i<len;i++)
        {
            if(i<len/2)
            {
                arr[i] = temp.val;
            }
            else if(i >= len/2){
                arr[i]= arr[k] + temp.val;
                System.out.println(arr[i]);
                k--;
                max = Math.max(arr[i], max);
            }

            temp = temp.next;
        }

        return max;
    }
}
