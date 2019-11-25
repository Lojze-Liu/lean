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
    private void test() {
        int[] b1 = build();
        Arrays.sort(b1);
        print(b1);


        int[] b2 = build();
        quickSort(b2);
        print(b2);
    }

    private void quickSort(int[] target) {

    }

    private void quickSort(int[] target, int start, int end) {


    }

    private int[] build() {
        return new int[]{3, 1, 2, 4, 6, 9, 10, 5};
    }

    private void print(int[] aid) {
        for (int i : aid) {
            System.out.println(i);
        }
    }
}
