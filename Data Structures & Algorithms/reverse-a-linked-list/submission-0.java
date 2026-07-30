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
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        Deque<Integer> vals = new ArrayDeque<>();

        ListNode curr = head;
        vals.push(curr.val);
        while(curr.next != null){
            curr = curr.next;
            vals.push(curr.val);
        }

        ListNode newHead = new ListNode(vals.pop(), null);
        ListNode prevNode = newHead;
        while(!vals.isEmpty()){
            ListNode currentNode = new ListNode(vals.pop(), null);
            prevNode.next = currentNode;
            prevNode = currentNode;
        }

        return newHead;
    }
}
