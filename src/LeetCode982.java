import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，返回其中 按位与三元组 的数目。
 *
 * 按位与三元组 是由下标 (i, j, k) 组成的三元组，并满足下述全部条件：
 *
 * 0 <= i < nums.length
 * 0 <= j < nums.length
 * 0 <= k < nums.length
 * nums[i] & nums[j] & nums[k] == 0 ，其中 & 表示按位与运算符。
 *  
 * 示例 1：
 *
 * 输入：nums = [2,1,3]
 * 输出：12
 * 解释：可以选出如下 i, j, k 三元组：
 * (i=0, j=0, k=1) : 2 & 2 & 1
 * (i=0, j=1, k=0) : 2 & 1 & 2
 * (i=0, j=1, k=1) : 2 & 1 & 1
 * (i=0, j=1, k=2) : 2 & 1 & 3
 * (i=0, j=2, k=1) : 2 & 3 & 1
 * (i=1, j=0, k=0) : 1 & 2 & 2
 * (i=1, j=0, k=1) : 1 & 2 & 1
 * (i=1, j=0, k=2) : 1 & 2 & 3
 * (i=1, j=1, k=0) : 1 & 1 & 2
 * (i=1, j=2, k=0) : 1 & 3 & 2
 * (i=2, j=0, k=1) : 3 & 2 & 1
 * (i=2, j=1, k=0) : 3 & 1 & 2
 * 示例 2：
 *
 * 输入：nums = [0,0,0]
 * 输出：27
 *
 *
 */
public class LeetCode982 {


    /**
     * 超时写法 三重循环排列组合 找出结果为0的次数
     * @param nums
     * @return
     */
    public int countTriplets(int[] nums) {
        int count = 0;
        for (int num : nums) {
            for (int i : nums) {
                for (int j : nums) {
                    if ((num & i & j) == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * 仍然超时 虽然优化了
     * @param nums
     * @return
     */
    public int countTriplets2(int[] nums) {
        int count = 0;
        List<Integer> arr = new ArrayList<>();
        for (int num : nums) {
            for (int i : nums) {
                arr.add(num & i);
            }
        }
        for (int num : nums) {
            for (Integer integers : arr) {
                if ((num & integers) == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     *
     * 先两重循环 将结果存储至一个数组中，注意此时的计算结果是数组的index，而每多一次这样的结果，数组值+1用来计数
     * 再两重循环，内循环为上面的数组，每次和index计算之后为0的情况 加上当前数组的值就是一共得出0的次数
     * @param nums
     * @return
     */
    public int countTriplets3(int[] nums) {
        int count = 0;
        int[] arr = new int[1 << 16];
        for (int num : nums) {
            for (int i : nums) {
                arr[num & i]++;
            }
        }
        for (int num : nums) {
            for (int j = 0; j < arr.length; j++) {
                if ((num & j) == 0) {
                    count += arr[j];
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode982 leetCode982 = new LeetCode982();
//        int[] a = {2,1,3};
        int[] a = {0,0,0};
        System.out.println(leetCode982.countTriplets3(a));
    }
}
