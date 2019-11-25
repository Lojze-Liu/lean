package leetcode.数字.完全平方数;

import org.junit.Test;

/**
 * @author lojze liu
 * @since 2019/11/13 7:32 下午
 */
public class PerfectSquare {

    @Test
    public void test() {
        System.out.println(isPerfectSquare(2147483647));
    }

    public boolean isPerfectSquare(int num) {
        int low = 0;
        int high = 46340;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            int temp = mid * mid;
            if (num == temp) {
                return true;
            } else if (num < temp) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

}
