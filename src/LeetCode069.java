/**
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 *
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 *
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：x = 4
 * 输出：2
 * 示例 2：
 *
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 *  
 *
 * 提示：
 *
 * 0 <= x <= 231 - 1
 *
 */
public class LeetCode069 {

    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        int min = 0;
        for (int i = 1; i <= x / 2; i++) {
            if (i * i <= x && i * i > 0) {
                min = i;
            } else {
                return min;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        LeetCode069 leetCode069 = new LeetCode069();
//        int x = 1;
        int x = 2;
//        int x = 2147483647;
        System.out.println(leetCode069.mySqrt(x));
//        System.out.println(Integer.MAX_VALUE);
    }

}
