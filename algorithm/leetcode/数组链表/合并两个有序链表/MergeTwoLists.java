package leetcode.数组链表.合并两个有序链表;

import offer.base.ListNode;
import org.junit.Test;

import java.util.List;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author lojze liu
 * @since 2019/11/27 12:31 下午
 */
public class MergeTwoLists {

    @Test
    public void test() {
        // 1 2 4
        // 1 3 4
        ListNode listNode = mergeTwoLists(buildL1(), buildL2());

        ListNode.print(listNode);
    }

    private ListNode buildL1() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        return l1;
    }

    private ListNode buildL2() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        return l1;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            } else if (l2 == null) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                cur.next = new ListNode(Math.min(l1.val, l2.val));
                if (l1.val >= l2.val) {
                    l2 = l2.next;
                } else {
                    l1 = l1.next;
                }
            }
            cur = cur.next;
        }
        return pre.next;
    }

}
