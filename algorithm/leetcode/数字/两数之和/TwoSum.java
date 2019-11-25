package leetcode.数字.两数之和;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 *给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author lojze liu
 * @since 2019
 */
public class TwoSum {

    @Test
    public void test() {
        int[] arr = new int[]{2, 7, 11, 15};
        int[] res = twoSum(arr, 9);
        System.out.println(res);
    }

    private int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int temp = target - num;
            if (map.containsKey(temp)) {
                return new int[]{i, map.get(temp)};
            }
            map.put(num, i);
        }
        return null;
    }

}
