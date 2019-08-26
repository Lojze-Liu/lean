package offer.树相关.重建二叉树;

import offer.base.TreeNode;
import offer.树相关.树的基本操作.OperateTree;
import org.junit.Test;

import java.util.Arrays;

/**
 * 重建二叉树
 *
 * @author lojze liu
 * @since 2019/8/24 9:33 下午
 */
public class ReConstructBinaryTree {
    @Test
    public void test() {
        int[] pre = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] mid = new int[]{4, 7, 2, 1, 5, 3, 8, 6};

        TreeNode targetRoot = OperateTree.buildTree();

        TreeNode newRoot = reConstructBinaryTree(pre, mid);

        System.out.println("target:");
        OperateTree.prePrintInRecursive(targetRoot);
        System.out.println();
        System.out.println("new:");
        OperateTree.prePrintInRecursive(newRoot);

    }

    /**
     * 重建二叉树
     */
    private TreeNode reConstructBinaryTree(int[] pre, int[] mid) {
        if (pre.length == 0 || pre.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        // 在中序中找到前序的根
        for (int i = 0; i < mid.length; i++) {
            if (mid[i] == pre[0]) {
                // 左子树
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(mid, 0, i));
                // 右子树
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(mid, i + 1, mid.length));
                break;
            }
        }
        return root;
    }

}
