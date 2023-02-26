import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 *
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 *
 */
public class LeetCode020 {
    public boolean isValid(String s) {

        if (s == null || s.length() == 0) {
             return false;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            }
            if (stack.size() == 0 && (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}' )) {
                return false;
            }
            if (s.charAt(i) == ')' && stack.size() > 0 && stack.pop() != '(') {
                return false;
            }
            if (s.charAt(i) == ']' && stack.size() > 0 && stack.pop() != '[') {
                return false;
            }
            if (s.charAt(i) == '}' && stack.size() > 0 && stack.pop() != '{') {
                return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        LeetCode020 leetCode020 = new LeetCode020();
        System.out.println(leetCode020.isValid("))"));
    }
}
