package io.leetcode.tasks;

public class MergeTwoLLs {

    public static class ListNode {

        public int val;
        public ListNode next;

        public ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode curr = res;
        ListNode lst1 = list1;
        ListNode lst2 = list2;

        while (lst1 != null || lst2 != null) {
            if (lst1 != null && lst2 == null) {
                curr = lst1;
                lst1 = lst1.next;
            }

            if (lst2 != null && lst1 == null) {
                curr = lst2;
                lst2 = lst2.next;
            }

            if (lst1.val <= lst2.val) {
                curr = lst1;
                lst1 = lst1.next;
            } else {
                curr = lst2;
                lst2 = lst2.next;
            }

            curr = curr.next;
        }

        return res;
    }
}
