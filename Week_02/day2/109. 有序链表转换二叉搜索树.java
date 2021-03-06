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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    private TreeNode buildTree(ListNode head, ListNode end) {

        if(head == end){
            return null;
        }

        ListNode midNode = getMidNode(head, end);
        
        TreeNode treeNode = new TreeNode(midNode.val);
        treeNode.left = buildTree(head, midNode);
        treeNode.right = buildTree(midNode.next, end);

        return treeNode;
    }

    private ListNode getMidNode(ListNode head, ListNode end) {

        ListNode slow = head;
        ListNode fast = head;
        while (fast != end && fast.next != end) {

            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}