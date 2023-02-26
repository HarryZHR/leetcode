/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 *
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 *
 *
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 */
public class LeetCode070 {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] array = new int[n];
        array[0] = 1;
        array[1] = 2;
        for (int i = 2; i < n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n - 1];
    }

    /**
     * 根据斐波那契数列的逻辑 进行叠加计算
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        int a = 1;
        int b = 1;
        while (n > 1) {
            b = a + b;
            a = b - a;
            n--;
        }
        return b;
    }

    public static void main(String[] args) {
        LeetCode070 leetCode070 = new LeetCode070();
        System.out.println(leetCode070.climbStairs2(46));
    }
}
