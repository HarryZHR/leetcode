/**
 * 给你一个字符串 s ，它仅包含字符 'a' 和 'b'。
 *
 * 你可以删除 s 中任意数目的字符，使得 s 平衡 。当不存在下标对 (i,j) 满足 i < j ，且 s[i] = 'b' 的同时 s[j]= 'a' ，此时认为 s 是 平衡 的。
 *
 * 请你返回使 s 平衡 的 最少 删除次数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "aababbab"
 * 输出：2
 * 解释：你可以选择以下任意一种方案：
 * 下标从 0 开始，删除第 2 和第 6 个字符（"aababbab" -> "aaabbb"），
 * 下标从 0 开始，删除第 3 和第 6 个字符（"aababbab" -> "aabbbb"）。
 * 示例 2：
 *
 * 输入：s = "bbaaaaabb"
 * 输出：2
 * 解释：唯一的最优解是删除最前面两个字符。
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 105
 * s[i] 要么是 'a' 要么是 'b'。
 *
 *
 * "abaababbbbaabaaabbbaaabbbaaaaaabbababababaaabbbbababababbabaaabababbabaabaaabbababbbbabbabbbb"
 * 39
 */
public class LeetCode1653 {

    /**
     * 两重循环 以一个位置为基准 删掉基准左侧的b 删掉基准右侧的a 记录删除次数
     * 超时！！！
     * @param s
     * @return
     */
    public int minimumDeletions(String s) {
        int min = 100000;
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == 'b') {
                    count ++;
                }
            }
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == 'a') {
                    count ++;
                }
            }
            if (min > count) {
                min = count;
            }
        }
        return min;
    }


    /**
     *  第一次循环先找出所有a的数量
     *  第二次逐个循环时，如果当前位置是a，拿总数-1 就是当前位置右侧的a的数量，也就是需要删除的数量
     *  如果当前位置是b，则拿总数+1，就是当前需要删掉的a的数量加上删掉本身b需要的数量
     *  这样第二次循环 每次得出的结果 都是每次需要操作的数量 取最小值即可
     * @param s
     * @return
     */
    public int minimumDeletions2(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                count ++;
            }
        }

        int res = count;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                count --;
            } else {
                count ++;
            }
            if (res > count) {
                res = count;
            }
        }
        return res;
    }

    public int minimumDeletions3(String S) {
        char[] s = S.toCharArray();
        int del = 0;
        for (char c : s) {
            if (c == 'a') {
                del ++;
            }
//            del += 'b' - c; // 统计 'a' 的个数
        }
        int ans = del;
        for (char c : s) {
            // 'a' -> -1    'b' -> 1
            if (c == 'a') {
                del --;
            } else {
                del ++;
            }
//            del += (c - 'a') * 2 - 1;
            ans = Math.min(ans, del);
        }
        return ans;
    }


    public static void main(String[] args) {
        LeetCode1653 leetCode1653 = new LeetCode1653();
        System.out.println(leetCode1653.minimumDeletions2("bbbbbbbaabbbbbaaabbbabbbbaabbbbbbaabbaaabaabbbaaaabaaababbbabbabbaaaabbbabbbbbaabbababbbaaaaaababaaababaabbabbbaaaabbbbbabbabaaaabbbaba"));
    }
}