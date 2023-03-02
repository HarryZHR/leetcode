/**
 * 二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。如果该数字无法精确地用32位以内的二进制表示，则打印“ERROR”。
 *
 * 示例1:
 *
 *  输入：0.625
 *  输出："0.101"
 * 示例2:
 *
 *  输入：0.1
 *  输出："ERROR"
 *  提示：0.1无法被二进制准确表示
 *
 *
 * 提示：
 *
 * 32位包括输出中的 "0." 这两位。
 * 题目保证输入用例的小数位数最多只有 6 位
 *
 *
 */
public class LeetCodeFace0502 {

    /**
     * 只要知道小数的二进制是怎么计算出来的 这道题就很简单
     * 0.625 也就是 5/8 拆解就是： 1/8 + 4/8 也就是： 2 次方 -3 + 2 次方 -1  得出0.101
     * 当0.625 *2 得出 1.25  个位模2等于1 说明当前位为1
     *       再*2 得出 2.5 个位模2等于0 说明当前位为0
     *       再*2 得出 5  个位模2等于1 说明当前位位1
     *       此时没有小数部分，计算结束
     *       如果一直到30位还有小数，说明无法在32位内表示该数 返回error
     * @param num
     * @return
     */
    public String printBin(double num) {
        StringBuilder res = new StringBuilder("0.");
        for (int i = 0; i < 30; i++) {
            num *= 2;
            int left = (int) num;
            if (left % 2 == 0) {
                res.append("0");
            } else {
                res.append("1");
            }
            if (num - left == 0) {
                return res.toString();
            }
        }
        return "ERROR";
    }


    /**
     * 正数转换二进制
     * @param num
     * @return
     */
    public String printBin2(int num) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            int mod = num % 2;
            if (mod == 0) {
                res.insert(0, "0");
            } else {
                res.insert(0, "1");
            }
            num = num / 2;
            if (num == 0) {
                return res.toString();
            }
        }
        return "ERROR";
    }


    public static void main(String[] args) {
        LeetCodeFace0502 leetCodeFace0502 = new LeetCodeFace0502();
        System.out.println(leetCodeFace0502.printBin2(32));
    }
}
