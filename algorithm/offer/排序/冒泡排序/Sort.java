package offer.排序.冒泡排序;

import org.junit.Test;

/**
 * @author lojze liu
 * @since 2019/11/30 10:03 下午
 */
public class Sort {

    @Test
    public void test() {
        int[] array = new int[]{5, 8, 2, 3, 9, 2, 1, 7};

        sort(array);

        for (int i : array) {
            System.out.print(i);
        }
    }

    private void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            //对于每一轮的初始值，假设已经排序
            boolean isSort = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    // 交换了 未排序
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }
        }
    }
}
