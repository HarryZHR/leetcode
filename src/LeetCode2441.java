import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个 不包含 任何零的整数数组 nums ，找出自身与对应的负数都在数组中存在的最大正整数 k 。
 *
 * 返回正整数 k ，如果不存在这样的整数，返回 -1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-1,2,-3,3]
 * 输出：3
 * 解释：3 是数组中唯一一个满足题目要求的 k 。
 * 示例 2：
 *
 * 输入：nums = [-1,10,6,7,-7,1]
 * 输出：7
 * 解释：数组中存在 1 和 7 对应的负数，7 的值更大。
 * 示例 3：
 *
 * 输入：nums = [-10,8,6,7,-2,-3]
 * 输出：-1
 * 解释：不存在满足题目要求的 k ，返回 -1 。
 *
 */
public class LeetCode2441 {
    public int findMaxK(int[] nums) {
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                int a = nums[i] * (-1);
                for (int j = 0; j < nums.length; j++) {
                    if (a == nums[j]) {
                        max = Math.max(max, nums[i]);
                        break;
                    }
                }
            }

        }
        return max;
    }


    public int findMaxK2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && set.contains((-1) * nums[i])) {
                max = Math.max(max, nums[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode2441 leetCode2441 = new LeetCode2441();
        int[] a = {-1,2,-3,3};
        int[] b = {-1,10,6,7,-7,1};
        int[] c = {-10,8,6,7,-2,-3};

        int[] d = {-1,10,6,7,-7,1};
        System.out.println(leetCode2441.findMaxK2(d));
    }


}
