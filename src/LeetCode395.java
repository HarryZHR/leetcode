import java.util.Arrays;

/**
 *给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 *
 * 示例
 * 输入：s = "aaabb", k = 3
 * 输出：3
 * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 *
 * 输入：s = "ababbc", k = 2
 * 输出：5
 * 解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 *
 * 输入：s = "ababacb", k = 3
 * 输出：0
 * 解释：没有重复超过3的子串。
 *
 *
 * 未完成
 */
public class LeetCode395 {
    public int longestSubstring(String s, int k) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int length = 0;
            int[] arr = new int[26];
            for (int j = i; j < s.length(); j++) {
                int arrIndex = s.charAt(j) - 'a';
                arr[arrIndex] ++;
                int min = 10000;
                for (int value : arr) {
                    if (value > 0) {
                        min = Math.min(value, min);
                    }
                }
                if (min >= k) {
                    length = j - i + 1;
                }
            }
            max = Math.max(max, length);

        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode395 l = new LeetCode395();
//        String a = "ababacb";
//        int k = 3;
//        String a = "aaabb";
//        int k = 3;
        String a = "ababbc";
        int k = 2;
        System.out.println(l.longestSubstring(a, k));
    }
}
