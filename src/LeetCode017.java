import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 *  示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 *
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 * 提示：
 *
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 *
 */
public class LeetCode017 {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        list = Arrays.asList(getArray(digits.charAt(0)));
        digits = digits.substring(1);
        while (digits.length() > 0) {
            list = letter(digits.charAt(0), list);
            digits = digits.substring(1);
        }

        return list;
    }

    private List<String> letter(char first, List<String> list) {
        List<String> res = new ArrayList<>();
        for (String s : getArray(first)) {
            for (String value : list) {
                res.add(value + s);
            }
        }
        return res;
    }

    private String[] getArray(char input) {
        switch (input) {
            case '2':
                return new String[]{"a", "b", "c"};
            case '3':
                return new String[]{"d", "e", "f"};
            case '4':
                return new String[]{"g", "h", "i"};
            case '5':
                return new String[]{"j", "k", "l"};
            case '6':
                return new String[]{"m", "n", "o"};
            case '7':
                return new String[]{"p", "q", "r", "s"};
            case '8':
                return new String[]{"t", "u", "v"};
            case '9':
                return new String[]{"w", "x", "y", "z"};
            default:
                return new String[0];
        }
    }

    public static void main(String[] args) {
        LeetCode017 leetCode017 = new LeetCode017();
        String digits = "";
        System.out.println(leetCode017.letterCombinations(digits));
    }
}