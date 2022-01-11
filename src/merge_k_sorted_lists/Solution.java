package merge_k_sorted_lists;

import java.util.ArrayList;
import java.util.Collections;

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
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode ptr = lists[i];
            while (ptr != null) {
                array.add(ptr.val);
                ptr = ptr.next;
            }
        }
        Collections.sort(array);
        ListNode head = new ListNode();
        ListNode temp = head;
        for (int i = 0; i < array.size(); i++) {
            ListNode newnode = new ListNode(array.get(i));
            temp.next = newnode;
            temp = temp.next;
        }
        return head.next;
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