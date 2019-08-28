package offer.树相关.树的基本操作;

import offer.base.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的一些基本操作
 * <p>
 * 一些函数变成的static的，为了方便其他的类用
 *
 * @author lojze liu
 * @since 2019/8/24 10:04 下午
 */
public class OperateTree {

    @Test
    public void testMain() {
        /* tree:
                1
               /  \
              2    3
             /    /  \
            4    5    6
             \       /
              7     8

           前序:  12473568
           中序:  47215386
           后序:  74258631
         */
        TreeNode treeRoot = buildTree();

        System.out.println("前序递归:");
        prePrintInRecursive(treeRoot);
        System.out.println();
        System.out.println("前序非递归V1:");
        prePrintNotRecursive(treeRoot);
        System.out.println();
        System.out.println("前序非递归V2:");
        prePrintNotRecursiveV2(treeRoot);
        System.out.println();
        System.out.println("------");

        System.out.println("中序递归:");
        midPrintInRecursive(treeRoot);
        System.out.println();
        System.out.println("中序非递归:");
        midPrintNotRecursive(treeRoot);
        System.out.println();

        System.out.println("后序递归:");
        System.out.println("后序非递归:");
        endPrintInRecursive(treeRoot);
        System.out.println();

        System.out.println("层序遍历:");
        seqTraverse(treeRoot);
    }

    /**
     * 前序遍历-递归版
     * 根左右
     */
    public static void prePrintInRecursive(TreeNode root) {
        if (root != null) {
            System.out.print(root.val);
            prePrintInRecursive(root.left);
            prePrintInRecursive(root.right);
        }
    }

    /**
     * 前序遍历-循环法1
     */
    private void prePrintNotRecursive(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        //当stack不为空时循环
        while (!stack.empty()) {
            TreeNode pop = stack.pop();
            System.out.print(pop.val);
            //入栈右节点
            if (pop.right != null) {
                stack.push(pop.right);
            }
            //入栈左节点
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }

    /**
     * 前序遍历 非递归 循环法2
     * 1、当前节点输出，并入栈当前节点的左节点，直到为空
     * 2、出栈，该节点已经输出过，找到此节点的右节点为当前节点
     * 3、重复12
     *
     * @param root 根节点
     */
    private void prePrintNotRecursiveV2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                System.out.print(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
    }

    /*--------*/

    /**
     * 中序遍历-递归版
     */
    public static void midPrintInRecursive(TreeNode root) {
        if (root != null) {
            midPrintInRecursive(root.left);
            System.out.print(root.val);
            midPrintInRecursive(root.right);
        }
    }

    /**
     * 中序遍历-循环法1
     * <p>
     * 左根右
     * <p>
     * 1、入栈左孩子，直到为空
     * 2、出栈，输入，找到此节点的右节点为当前节点
     * 3、重复12
     */
    private void midPrintNotRecursive(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.print(cur.val);
            cur = cur.right;
        }
    }

    /**
     * 中序遍历-循环法2 -> 队列实现
     */
    private void midPrintNotRecursiveV2(TreeNode root) {
        //TODO
    }

    /*--------*/

    /**
     * 后续遍历-递归版
     */
    public static void endPrintInRecursive(TreeNode root) {
        if (root != null) {
            endPrintInRecursive(root.left);
            endPrintInRecursive(root.right);
            System.out.print(root.val);
        }
    }

    /**
     * 后序遍历-循环法
     */
    private void endPrintNotRecursive(TreeNode root) {
        //TODO





    }

    /**
     * 层序遍历
     */
    public void seqTraverse(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            //出队
            TreeNode poll = queue.poll();
            System.out.print(poll.val);
            if(poll.left != null){
                queue.offer(poll.left);
            }
            if(poll.right != null){
                queue.offer(poll.right);
            }
        }
    }

    public static TreeNode buildTree() {
         /* tree:
                1
               /  \
              2    3
             /    /  \
            4    5    6
             \       /
              7     8
         */
        TreeNode root = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(6);
        TreeNode r7 = new TreeNode(7);
        TreeNode r8 = new TreeNode(8);

        root.left = r2;
        root.right = r3;
        r2.left = r4;
        r4.right = r7;
        r3.left = r5;
        r3.right = r6;
        r6.left = r8;

        return root;
    }

    public static TreeNode buildTreeV2() {
        TreeNode r3 = new TreeNode(3);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(6);
        TreeNode r8 = new TreeNode(8);
        r3.left = r5;
        r3.right = r6;
        r6.left = r8;
        return r3;
    }

    public static TreeNode buildTreeV3() {
        TreeNode r3 = new TreeNode(3);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(6);
        TreeNode r7 = new TreeNode(7);
        r3.left = r5;
        r3.right = r6;
        r6.left = r7;
        return r3;
    }
}
