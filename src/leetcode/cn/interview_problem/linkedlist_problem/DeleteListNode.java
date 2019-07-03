package leetcode.cn.interview_problem.linkedlist_problem;

/**
 * Created by Diane on 2019-07-04.
 * Goal: 删除链表中的给定节点
 */
public class DeleteListNode {
    public void deleteNode(ListNode node) {

            ListNode nextNode = node.next;
            node.val = nextNode.val;
            node.next = nextNode.next;

    }
}
