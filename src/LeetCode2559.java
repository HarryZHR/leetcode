import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个下标从 0 开始的字符串数组 words 以及一个二维整数数组 queries 。
 *
 * 每个查询 queries[i] = [li, ri] 会要求我们统计在 words 中下标在 li 到 ri 范围内（包含 这两个值）并且以元音开头和结尾的字符串的数目。
 *
 * 返回一个整数数组，其中数组的第 i 个元素对应第 i 个查询的答案。
 *
 * 注意：元音字母是 'a'、'e'、'i'、'o' 和 'u' 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：words = ["aba","bcb","ece","aa","e"], queries = [[0,2],[1,4],[1,1]]
 * 输出：[2,3,0]
 * 解释：以元音开头和结尾的字符串是 "aba"、"ece"、"aa" 和 "e" 。
 * 查询 [0,2] 结果为 2（字符串 "aba" 和 "ece"）。
 * 查询 [1,4] 结果为 3（字符串 "ece"、"aa"、"e"）。
 * 查询 [1,1] 结果为 0 。
 * 返回结果 [2,3,0] 。
 * 示例 2：
 *
 * 输入：words = ["a","e","i"], queries = [[0,2],[0,1],[2,2]]
 * 输出：[3,2,1]
 * 解释：每个字符串都满足这一条件，所以返回 [3,2,1] 。
 *  
 *
 * 提示：
 *
 * 1 <= words.length <= 10^5
 * 1 <= words[i].length <= 40
 * words[i] 仅由小写英文字母组成
 * sum(words[i].length) <= 3 * 10^5
 * 1 <= queries.length <= 10^5
 * 0 <= queries[j][0] <= queries[j][1] < words.length
 *
 */
public class LeetCode2559 {

    /**
     * 常规做法 超时
     * @param words
     * @param queries
     * @return
     */
    public int[] vowelStrings(String[] words, int[][] queries) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if ((words[i].charAt(0) == 'a' || words[i].charAt(0) == 'e' || words[i].charAt(0) == 'i' || words[i].charAt(0) == 'o' || words[i].charAt(0) == 'u')
                    && ((words[i].charAt(words[i].length() - 1) == 'a' || words[i].charAt(words[i].length() - 1) == 'e' || words[i].charAt(words[i].length() - 1) == 'i' || words[i].charAt(words[i].length() - 1) == 'o' || words[i].charAt(words[i].length() - 1) == 'u'))) {
                list.add(i);
            }
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int a = 0;
            for (Integer integer : list) {
                if (integer >= queries[i][0] && integer <= queries[i][1]) {
                    a++;
                    res[i] = a;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode2559 leetCode2559 = new LeetCode2559();
//        String[] words =  {"aba","bcb","ece","aa","e"};
//        int[][] queries = {{0,2},{1,4}, {1,1}};
        String[] words =  {"a","e","i"};
        int[][] queries = {{0,2},{0,1}, {2,2}};
        System.out.println(leetCode2559.vowelStrings(words, queries));
    }
}

