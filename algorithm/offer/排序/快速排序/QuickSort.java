package offer.排序.快速排序;

import org.junit.Test;

import java.util.Arrays;

/**
 * 经典排序算法之 - 快速排序
 *
 * @author lojze liu
 * @since 2019/11/26 12:13 上午
 */
public class QuickSort {

    @Test
    public void test() {
        int[] b1 = build();
        Arrays.sort(b1);
        print(b1);


        int[] b2 = build();
        quickSort(b2, 0, b2.length - 1);
        print(b2);
    }


    private void quickSort(int[] target, int start, int end) {
        if (start < end) {
            int i = one(target, start, end);    //划分数组并获取比较元素的位置
            quickSort(target, start, i - 1);     //对比较元素左边进行排序
            quickSort(target, i + 1, end);     //对比较元素右边进行排序
        }
    }

    private int one(int[] target, int start, int end) {
        int pivot = target[start];
        int low = start;
        int high = end;
        while (low < high) {
            while (low < high && target[high] >= pivot) {
                high--;
            }
            while (low < high && target[low] <= pivot) {
                low++;
            }
            if (low == high) {
                target[start] = target[low];
                target[low] = pivot;
            } else {
                int temp = target[low];
                target[low] = target[high];
                target[high] = temp;
            }
        }
        return low;
    }

    private int[] build() {
        return new int[]{3, 1, 2, 4, 6, 9, 10, 0, 5};
    }

    private void print(int[] aid) {
        for (int i : aid) {
            System.out.print(i);
        }
        System.out.println();
    }
}
