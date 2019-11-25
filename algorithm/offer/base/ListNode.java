package offer.base;

/**
 * @author lojze liu
 * @since 2019/8/24 7:34 下午
 */
public class ListNode {
    /**
     * 值
     */
    public int val;

    /**
     * next 节点
     */
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
