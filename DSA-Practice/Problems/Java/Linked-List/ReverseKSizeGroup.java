public class ReverseKSizeGroup {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null) {
            return head;
        }

        ListNode pre = null;
        ListNode curr = head;
        ListNode next = null;
        int count = 1;

        ListNode temp = head;
        while (temp != null && count <= k) {
            temp = temp.next;
            count++;
        }

        if (count <= k) {
            return head;
        }

        count = 1;

        while (curr != null && count <= k) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
            count++;
        }

        head.next = reverseKGroup(curr, k);

        return pre;

    }

}
