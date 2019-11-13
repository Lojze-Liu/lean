package offer.查找.二分查找;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 二分查找（折半查找）
 *
 * @author lojze liu
 * @since 2019/11/13 9:37 上午
 */
public class BinarySearch {

    @Test
    public void testBinarySearch() {
        Assert.assertEquals(1, binarySearch(build(), 1));
        Assert.assertEquals(4, binarySearch(build(), 5));
        Assert.assertEquals(6, binarySearch(build(), 8));
        Assert.assertEquals(2, binarySearch(build(), 3));
        Assert.assertEquals(3, binarySearch(build(), 4));
        Assert.assertEquals(0, binarySearch(build(), 0));
        Assert.assertEquals(5, binarySearch(build(), 7));
        Assert.assertEquals(-1, binarySearch(build(), 9));
    }

    private int binarySearch(int[] aidArray, int target) {
        Arrays.sort(aidArray);
        int l = 0;
        int r = aidArray.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (aidArray[mid] == target) {
                return mid;
            }
            if (aidArray[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    private int[] build() {
        return new int[]{1, 5, 8, 3, 4, 0, 7};
    }
}
