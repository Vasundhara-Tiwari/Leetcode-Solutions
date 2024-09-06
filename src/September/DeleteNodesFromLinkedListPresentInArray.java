package September;

import java.util.HashSet;

public class DeleteNodesFromLinkedListPresentInArray {

//   Definition for singly-linked list.

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        while(set.contains(head.val)){
            head=head.next;
        }
        ListNode slow = head;
        ListNode fast = slow.next;
        while(fast!=null){
            if(set.contains(fast.val)){
                slow.next = fast.next;
                fast=fast.next;
            }
            else{
                slow=fast;
                fast=fast.next;
            }
        }
        return head;
    }
}
