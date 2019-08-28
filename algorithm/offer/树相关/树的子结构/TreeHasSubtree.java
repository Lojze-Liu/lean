package offer.树相关.树的子结构;

import offer.base.TreeNode;
import offer.树相关.树的基本操作.OperateTree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 树的子结构
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * @author lojze liu
 * @since 2019/8/27 12:29 上午
 */
public class TreeHasSubtree {

    @Test
    public void test() {

        OperateTree.
    }

    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return false;
        }
        int target = root2.val;
        TreeNode startRoot = findStartRoot(root1, target);
        if (startRoot == null) {
            return false;
        }
        return isEqual(startRoot , root2);
    }
    /**
     * 判断两树是否相等
     */
    private boolean isEqual(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        if(root1.val == root2.val){
            return isEqual(root1.left,root2.left) && isEqual(root1.right,root2.right);
        }
        return false;
    }

    private TreeNode findStartRoot(TreeNode root1, int target) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            //找到节点
            if (poll.val == target) {
                return poll;
            }
            if (root1.left != null) {
                queue.offer(poll.left);
            }
            if (root1.right != null) {
                queue.offer(poll.right);
            }
        }
        return null;
    }



}
