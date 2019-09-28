package offer.树相关.树的子结构;

import com.google.common.collect.Sets;
import offer.base.TreeNode;
import offer.树相关.树的基本操作.OperateTree;
import org.junit.Test;

import java.util.HashSet;
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

    /**
     * 判断r2 是否是r1的子树
     */
    private boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val == t.val) {
            return isEqual(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    /**
     * 两树是否相等
     */
    private boolean isEqual(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        }
        if (r1 == null || r2 == null) {
            return false;
        }
        if (r1.val == r2.val) {
            return isEqual(r1.left, r2.left) && isEqual(r1.right, r2.right);
        }
        return false;
    }

    public static void main(String[] args) {
        HashSet<Integer> i1 = Sets.newHashSet(1, 2, 3);
        HashSet<Integer> i2 = Sets.newHashSet(1, 2, 3,4);
        HashSet<Integer> i3 = Sets.newHashSet(1, 2);

        System.out.println(Sets.difference(i1,i2));
        System.out.println(Sets.difference(i1,i3));
    }

}
