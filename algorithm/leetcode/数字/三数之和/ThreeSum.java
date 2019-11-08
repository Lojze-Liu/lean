package leetcode.数字.三数之和;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lojze liu
 * @since 2019/9/19 8:35 上午
 */
public class ThreeSum {

    @Test
    public void Test() {
        int[] a = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
        System.out.println(threeSum(a));
    }

    private List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if (length < 3) {
            return result;
        }
        //1、排序
        Arrays.sort(nums);
        //2、循环
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                //排序后的数据，当数字 > 0 , num[i] + L + R 一定> 0
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 去重
                continue;
            }
            int L = i + 1;
            int R = length - 1;
            while (L < R) {
                int sum = nums[L] + nums[R] + nums[i];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[L], nums[R], nums[i]));
                    while (L < R && nums[L] == nums[L + 1]) L++; // 去重
                    while (L < R && nums[R] == nums[R - 1]) R--; // 去重
                    L++;
                    R--;

                } else if (sum > 0) {
                    R--;
                } else {
                    L++;
                }
            }
        }
        return result;
    }
}
