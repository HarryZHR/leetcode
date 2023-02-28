/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。
 *
 *示例 1:
 * 输入: s = "III"
 * 输出: 3
 *
 * 示例 2:
 * 输入: s = "IV"
 * 输出: 4
 *
 * 示例 3:
 * 输入: s = "IX"
 * 输出: 9
 *
 * 示例 4:
 * 输入: s = "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 *
 * 示例 5:
 * 输入: s = "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 */
public class LeetCode013 {

    /**
     * 最直观的办法，一堆if else
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'M') {
                res += 1000;
            } else if (s.charAt(i) == 'D') {
                res += 500;
            } else if (s.charAt(i) == 'C') {
                if ((i + 1) < s.length()) {
                    if (s.charAt(i + 1) == 'D') {
                        res += 400;
                        i++;
                    } else if (s.charAt(i + 1) == 'M') {
                        res += 900;
                        i++;
                    } else {
                        res += 100;
                    }
                } else {
                    res += 100;
                }
            } else if (s.charAt(i) == 'L') {
                res += 50;
            } else if (s.charAt(i) == 'X') {
                if ((i + 1) < s.length()) {
                    if (s.charAt(i + 1) == 'L') {
                        res += 40;
                        i++;
                    } else if (s.charAt(i + 1) == 'C') {
                        res += 90;
                        i++;
                    } else {
                        res += 10;
                    }
                } else {
                    res += 10;
                }

            } else if (s.charAt(i) == 'V') {
                res += 5;
            } else if (s.charAt(i) == 'I') {
                if ((i + 1) < s.length()) {
                    if (s.charAt(i + 1) == 'X') {
                        res += 9;
                        i++;
                    } else if (s.charAt(i + 1) == 'V') {
                        res += 4;
                        i++;
                    } else {
                        res += 1;
                    }
                } else {
                    res += 1;
                }
            }
        }
        return res;
    }

    /**
     * 先替换字符，把特殊情况的双字符，改成单字符，再直接加
     * @param s
     * @return
     */
    public int romanToInt2(String s) {
        int num = 0;
        s = s.replace("IV", "a");
        s = s.replace("IX", "b");
        s = s.replace("XL", "e");
        s = s.replace("XC", "f");
        s = s.replace("CD", "g");
        s = s.replace("CM", "h");
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            switch (a) {
                case 'a':
                    num += 4;
                    break;
                case 'b':
                    num += 9;
                    break;
                case 'e':
                    num += 40;
                    break;
                case 'f':
                    num += 90;
                    break;
                case 'g':
                    num += 400;
                    break;
                case 'h':
                    num += 900;
                    break;
                case 'I':
                    num += 1;
                    break;
                case 'V':
                    num += 5;
                    break;
                case 'X':
                    num += 10;
                    break;
                case 'L':
                    num += 50;
                    break;
                case 'C':
                    num += 100;
                    break;
                case 'D':
                    num += 500;
                    break;
                case 'M':
                    num += 1000;
                    break;
            }

        }
        return num;
    }

    public static void main(String[] args) {
        LeetCode013 leetCode013 = new LeetCode013();
        System.out.println(leetCode013.romanToInt2("MCMXCIV"));
    }
}
