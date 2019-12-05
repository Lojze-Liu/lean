package leetcode.数字.罗马数字;

import org.junit.Test;

/**
 *
 * @author lojze liu
 * @since 2019/12/1 10:27 下午
 */
public class IntToRoman {

    @Test
    public void test(){
        System.out.println(intToRoman(1994));
    }

    public String intToRoman(int num) {
        // 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中
        // 并且按照阿拉伯数字的大小降序排列，这是贪心选择思想
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while (index < 13) {
            while (num >= nums[index]) {
                stringBuilder.append(romans[index]);
                num -= nums[index];
            }
            index++;
        }


        return stringBuilder.toString();
    }

}
