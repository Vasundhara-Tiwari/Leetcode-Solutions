package July;


public class SortList {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode mid = middleNode(head);
        ListNode midnext = mid.next;
        mid.next = null;
        ListNode A = sortList(head);
        ListNode B = sortList(midnext);
        return mergeTwoLists(A, B);
    }
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curr1 = list1;
        ListNode curr2 = list2;
        ListNode current = new ListNode();
        ListNode temp = current;
        while(curr1 != null && curr2 != null){
            if(curr1.val < curr2.val){
                current.next = curr1;
                current = current.next;
                curr1 = curr1.next;
            } else {
                current.next = curr2;
                current = current.next;
                curr2 = curr2.next;
            }
        }
        if(curr1 != null){
            current.next = curr1;
        }
        if(curr2 != null){
            current.next = curr2;
        }
        return temp.next;
    }
}
