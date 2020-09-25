class AddTwoNumbers {
    // Problem 2: Add Two Numbers
    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int c) {
        int val = l1.val + l2.val + c;
        c = val / 10;
        ListNode ret = new ListNode(val);

        if (l1.next != null || l2.next != null || c != 0) {
            if (l1.next == null) l1.next = new ListNode(0);
            if (l2.next == null) l2.next = new ListNode(0);
            ret.next = addTwoNumbers(l1.next, l2.next, c);
        }
        return ret;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }
}
