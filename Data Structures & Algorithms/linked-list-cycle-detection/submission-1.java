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
//using fast and slow pointer
class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fastptr = head;
        ListNode slowPtr = head;
        while (fastptr != null && slowPtr != null) {
            fastptr = fastptr.next.next;
            slowPtr = slowPtr.next;
            if(fastptr == slowPtr) {
                return true;
            }
        }
        return false;
    }
}
