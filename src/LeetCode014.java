/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 */

public class LeetCode014 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        int minLength = 201;
        for (String str : strs) {
            if (minLength > str.length()) {
                minLength = str.length();
            }
        }
        StringBuilder res = new StringBuilder();
        for (int j = 0; j < minLength; j++) {
            char letter = 'A';
            boolean flag = true;
            for (int i = 1; i < strs.length; i++) {

                letter = strs[0].charAt(j);
                if (strs[0].charAt(j) != strs[i].charAt(j)) {
                    flag = false;
                }

            }
            if (flag) {
                res.append(letter);
            } else {
                break;
            }
        }
        return res.toString().replace("A", "");
    }

    public static void main(String[] args) {
        LeetCode014 leetCode014 = new LeetCode014();
        String[] strs = {"aaa"};
        System.out.println(leetCode014.longestCommonPrefix(strs));
    }
}
