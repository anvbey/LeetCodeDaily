/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        
        
        int len1 =0,len2=0;
        
        ListNode temp1= headA;
        ListNode temp2 = headB;
        if(temp1 == null || temp2 == null)
            return null;
        
        while(temp1!= null)
        {
            len1++;
            temp1= temp1.next;
        }
        
        
        while(temp2 != null)
        {
            len2++;
            temp2= temp2.next;
        }
        
        temp1= headA;
        temp2 = headB;
        
        if(len1 > len2)
        {
            for(int i=0;i<len1 - len2;i++)
            {
                temp1= temp1.next;
            }
        }
        else
        {
            for(int i=0;i<len2 - len1;i++)
            {
                temp2= temp2.next;
            }
        }
        
        int flag=0;
        while(temp1!= null || temp2!= null)
        {
            if(temp1 == temp2)
            {
                flag=1;
                break;
            }
            temp1= temp1.next;
            temp2=  temp2.next;
        }
        
        if(flag== 1)
        return temp1;
        else
            return null;
    }
}
