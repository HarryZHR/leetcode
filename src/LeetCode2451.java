import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个字符串数组 words ，每一个字符串长度都相同，令所有字符串的长度都为 n 。
 *
 * 每个字符串 words[i] 可以被转化为一个长度为 n - 1 的 差值整数数组 difference[i] ，其中对于 0 <= j <= n - 2 有 difference[i][j] = words[i][j+1] - words[i][j] 。注意两个字母的差值定义为它们在字母表中 位置 之差，也就是说 'a' 的位置是 0 ，'b' 的位置是 1 ，'z' 的位置是 25 。
 *
 * 比方说，字符串 "acb" 的差值整数数组是 [2 - 0, 1 - 2] = [2, -1] 。
 * words 中所有字符串 除了一个字符串以外 ，其他字符串的差值整数数组都相同。你需要找到那个不同的字符串。
 *
 * 请你返回 words中 差值整数数组 不同的字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：words = ["adc","wzy","abc"]
 * 输出："abc"
 * 解释：
 * - "adc" 的差值整数数组是 [3 - 0, 2 - 3] = [3, -1] 。
 * - "wzy" 的差值整数数组是 [25 - 22, 24 - 25]= [3, -1] 。
 * - "abc" 的差值整数数组是 [1 - 0, 2 - 1] = [1, 1] 。
 * 不同的数组是 [1, 1]，所以返回对应的字符串，"abc"。
 * 示例 2：
 *
 * 输入：words = ["aaa","bob","ccc","ddd"]
 * 输出："bob"
 * 解释：除了 "bob" 的差值整数数组是 [13, -13] 以外，其他字符串的差值整数数组都是 [0, 0] 。
 *
 */
public class LeetCode2451 {

    public String oddString(String[] words) {
        int temp = 50;
        int smallLength = words[0].length();
        for (int i = 0; i < smallLength - 1; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            Map<Integer, Integer> map2 = new HashMap<>();
            for (int j = 0; j < words.length; j++) {
                int num = words[j].charAt(i + 1) - words[j].charAt(i);
                if (map.get(num) != null) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                    map2.put(num, j);
                }
            }
            if (map.keySet().size() > 1) {
                for(Integer key : map.keySet()) {
                    if (map.get(key) == 1) {
                        temp = map2.get(key);
                    }
                }
            }
        }
        return words[temp];
    }


    public static void main(String[] args) {
        LeetCode2451 leetCode2451 = new LeetCode2451();

//        String[] words = {"aaa","bob","ccc","ddd"};
//        String[] words = {"adc","wzy","abc"};
        String[] words = {"wwe","yyg","ssa","ttb","ddd","ssa","xxf","ssa","ttb","xxf","xxf","zzh","wwe","yyg","xxf"};
        System.out.println(leetCode2451.oddString(words));
    }
}
