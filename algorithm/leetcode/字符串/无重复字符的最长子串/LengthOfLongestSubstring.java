package leetcode.字符串.无重复字符的最长子串;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @author lojze liu
 * @since 2019/11/27 12:02 上午
 */
public class LengthOfLongestSubstring {

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    private int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int len = s.length();
        int i = 0, j = 0, result = 0;
        while (i < len && j < len) {
            //若不含，向右边滑动
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                //更新result
                result = Math.max(result, set.size());
            } else {
                set.remove(s.charAt(i++));
            }

        }
        return result;
    }

}
