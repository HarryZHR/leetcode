import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode022 {
    public List<String> generateParenthesis(int n) {
        List<String> parenthesisList = new ArrayList<>();
        String parenthesis = new String();
        generate(parenthesisList, parenthesis, n, n);
        return parenthesisList;
    }

    private void generate(List<String> parenthesisList, String parenthesis, int left, int right) {
        if (left == 0 && right == 0) {
            parenthesisList.add(parenthesis);
            return;
        }
        if (left > 0) {
            generate(parenthesisList, parenthesis + "(", left - 1, right);
        }
        if (right > left) {
            generate(parenthesisList, parenthesis + ")", left, right - 1);
        }
    }

    public void generate1(List<String> list, String str, int left, int right) {
        if (left == 0 && right == 0) {
            list.add(str);
            return;
        }
        if (left > 0) {
            generate1(list, str + '(', left - 1, right);
        }
        if (right > left) {
            generate1(list, str + ')', left, right - 1);
        }
    }

    public static void main(String[] args) {
        LeetCode022 test = new LeetCode022();
        List<String> strings = test.generateParenthesis(4);
        System.out.println(strings);
    }
}
