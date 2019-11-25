package leetcode.数字.两数相加;

import offer.base.ListNode;
import org.junit.Test;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author lojze liu
 * @since 2019/11/25 11:35 下午
 */
public class AddTwoNumbers {

    @Test
    public void test() {
        ListNode listNode = addTwoNumbers(buildL1(), buildL1());
        ListNode.print(listNode);
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //结果新节点，pre只是用作于存储到头节点的位置，防止在下面的时候丢失
        ListNode pre = new ListNode(0);
        //进位
        int carry = 0;
        ListNode cur = pre;
        //遍历两个链表
        while (l1 != null || l2 != null) {

            //有可能为null，为null进行补0
            int value1 = l1 == null ? 0 : l1.val;
            int value2 = l2 == null ? 0 : l2.val;

            //考虑进位的加法
            int temp = value1 + value2 + carry;
            //算出本次的进位
            carry = temp / 10;
            //只能存储一位数字，所以直接取余数
            int result = temp % 10;

            //构建结果链表
            cur.next = new ListNode(result);

            //循环
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            cur = cur.next;
        }
        //如果进位还有1，证明需要往前补1
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        //头结点排上用场了，cur在变，无法使用，使用pre.next就是结果的头节点啦
        return pre.next;
    }

    private ListNode buildL1() {
        return new ListNode(5);
    }

}
