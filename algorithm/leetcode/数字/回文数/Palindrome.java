package leetcode.数字.回文数;

import org.junit.Test;

/**
 * @author lojze liu
 * @since 2019/12/1 11:05 下午
 */
public class Palindrome {

    @Test
    public void test() {
        boolean palindrome = isPalindrome(1210021);
        System.out.println(palindrome);
    }

    public boolean isPalindrome(int x) {
        //边界判断
        if (x < 0) return false;
        int div = 1;
        //
        while (x / div >= 10) div *= 10;
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }
}
