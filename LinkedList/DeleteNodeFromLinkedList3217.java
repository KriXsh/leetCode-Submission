// leetcode

import java.util.HashSet;
import java.util.Set;

//Definition for singly-linked list.
public class DeleteNodeFromLinkedList3217 {
    int val;
    DeleteNodeFromLinkedList3217 next;

    DeleteNodeFromLinkedList3217() {
    }

    DeleteNodeFromLinkedList3217(int val) {
        this.val = val;
    }

    DeleteNodeFromLinkedList3217(int val, DeleteNodeFromLinkedList3217 next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public DeleteNodeFromLinkedList3217 modifiedList(int[] nums, DeleteNodeFromLinkedList3217 head) {
        // Step 1: Create a set for fast lookup of values to be removed
        Set<Integer> valuesToRemove = new HashSet<>();
        for (int num : nums) {
            valuesToRemove.add(num);
        }
        DeleteNodeFromLinkedList3217 prev = null, node = head;
        while (node != null) {
            if (valuesToRemove.contains(node.val)) {
                // remove
                if (prev != null) {
                    prev.next = node.next;
                } else {
                    head = node.next;
                }
            } else {
                prev = node;

            }
            node = node.next;
        }
        return head;
    }
}