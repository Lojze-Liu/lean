package offer.树相关.树的子结构;

import offer.base.TreeNode;
import offer.树相关.树的基本操作.OperateTree;
import org.junit.Test;

import java.util.LinkedList;
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
        TreeNode treeNode1 = OperateTree.buildTree();
        TreeNode treeNode2 = OperateTree.buildTreeV2();
        TreeNode treeNode3 = OperateTree.buildTreeV3();

        System.out.println(isSubtree(treeNode1, treeNode2));
        System.out.println(isSubtree(treeNode1, treeNode3));
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null || t == null) return false;
        if(isSameTree(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if(s == null) return t == null;
        if(t == null) return false;
        if(s.val != t.val) return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

}
