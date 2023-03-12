import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个放有字母和数字的数组，找到最长的子数组，且包含的字母和数字的个数相同。
 * <p>
 * 返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。
 * <p>
 * 示例 1:
 * 输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]
 * 输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
 * <p>
 * 示例 2:
 * 输入: ["A","A"]
 * 输出: []
 * 提示：
 * <p>
 * array.length <= 100000
 */
public class LeetCodeFace1705 {

    /**
     * 超时解法  数组长度超过100000
     *
     * @param array
     * @return
     */
    public String[] findLongestSubarray(String[] array) {
        int start = 0;
        int end = 0;
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            int letterCount = 0;
            int numCount = 0;
            for (int j = i; j < array.length; j++) {
                if ((array[j].charAt(0) >= 'A' && array[j].charAt(0) <= 'Z') || (array[j].charAt(0) >= 'a' && array[j].charAt(0) <= 'z')) {
                    letterCount++;
                } else {
                    numCount++;
                }
                if (letterCount == numCount) {
                    if (j - i > max) {
                        max = Math.max(j - i, max);
                        start = i;
                        end = j;
                    }
                }
            }
        }
        if (max > 0) {
            String[] arr = new String[end - start + 1];
            int index = 0;
            for (int i = start; i <= end; i++) {
                arr[index++] = array[i];
            }
            return arr;
        } else {
            return new String[0];
        }
    }


    /**
     * 利用了一个前缀和相减之差等于位数之和的方法， 注意这个方法是左闭右开的，所以数组的索引后一个需要减一，并且第一位前缀和始终是0，所以最后还会比原数组多一位
     * 示例  a = [ 1, -1, -1, 1, 1]   前缀和  s = [0, 1, 0, -1, 0, 1]
     * 可得s[2] - s[0] = 0  所以 原数组a[0]至a[1] 和为0
     *
     * 将原字符串数组通过以上方法转化成 字母为1，数字为-1的数组，再计算出前缀和
     * 次数循环前缀和，将前缀和为key，索引为value放入map中，如果第二次遇到同一个key，说明两者之间和为0，记录下最长的即可。
     * @param array
     * @return
     */
    public String[] findLongestSubarray2(String[] array) {
        int n = array.length;
        int[] s = new int[n + 1];
        s[0] = 0;
        for (int i = 0; i < n; i++) {
            int num = Character.isLetter(array[i].charAt(0)) ? 1 : -1;
            s[i + 1] = s[i] + num;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < n + 1; i++) {
            if (!map.containsKey(s[i])) {
                map.put(s[i], i);
            } else {
                int oldIndex = map.get(s[i]);
                if ((end - start) < (i - oldIndex)) {
                    end = i;
                    start = oldIndex;
                }
            }
        }
        String[] arr = new String[end - start];
        int count = 0;
        for (int i = start; i < end; i++) {
            arr[count++] = array[i];
            System.out.print(array[i] + ",");
        }
        return arr;
    }

    public static void main(String[] args) {
        LeetCodeFace1705 leetCodeFace1705 = new LeetCodeFace1705();
//        String[] a = {"A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"};
        String[] a = {"A","1"};
//        String[] a = {"42", "10", "O", "t", "y", "p", "g", "B", "96", "H", "5", "v", "P", "52", "25", "96", "b", "L", "Y", "z", "d", "52", "3", "v", "71", "J", "A", "0", "v", "51", "E", "k", "H", "96", "21", "W", "59", "I", "V", "s", "59", "w", "X", "33", "29", "H", "32", "51", "f", "i", "58", "56", "66", "90", "F", "10", "93", "53", "85", "28", "78", "d", "67", "81", "T", "K", "S", "l", "L", "Z", "j", "5", "R", "b", "44", "R", "h", "B", "30", "63", "z", "75", "60", "m", "61", "a", "5", "S", "Z", "D", "2", "A", "W", "k", "84", "44", "96", "96", "y", "M"};
        leetCodeFace1705.findLongestSubarray2(a);
    }
}
