package remove_nth_node_from_end_of_list;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int totalLength = 0;
        while (curr != null) {
            totalLength++;
            curr = curr.next;
        }


        curr = head;
        ListNode prev = null;
        int cnt = 0;
        while (curr != null) {
            if (totalLength - n == cnt) {
                if (prev != null)
                    prev.next = curr.next;
                else
                    head = head.next;
                break;
            }
            cnt++;
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}

class ListNode {
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