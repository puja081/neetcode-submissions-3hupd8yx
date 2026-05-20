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
        ListNode res = new ListNode(0);
        ListNode curr = res;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        if(lists.length == 0){
            return null;
        }
        for(int i = 0 ; i < lists.length ; i++){
            if(lists != null) {
                pq.offer(lists[i]);
            }
        }
        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;
            node = node.next;
            if(node != null) {
                pq.offer(node);
            }
        }
        return res.next;
        

    }
}
