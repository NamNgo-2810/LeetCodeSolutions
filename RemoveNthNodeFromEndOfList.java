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
class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        int count = 0;
        ListNode curr = head;
        ListNode res = new ListNode(0);
        res.next = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        size -= n;
        curr = res;
        while (size > 0) {
            size--;
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return res.next;
    }
}
