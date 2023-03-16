
/**
 * 给你一个长度为 n 的数组 nums ，该数组由从 1 到 n 的 不同 整数组成。另给你一个正整数 k 。
 *
 * 统计并返回 nums 中的 中位数 等于 k 的非空子数组的数目。
 *
 * 注意：
 *
 * 数组的中位数是按 递增 顺序排列后位于 中间 的那个元素，如果数组长度为偶数，则中位数是位于中间靠 左 的那个元素。
 * 例如，[2,3,1,4] 的中位数是 2 ，[8,4,3,5,1] 的中位数是 4 。
 * 子数组是数组中的一个连续部分。
 *   
 *
 * 示例 1：
 *
 * 输入：nums = [3,2,1,4,5], k = 4
 * 输出：3
 * 解释：中位数等于 4 的子数组有：[4]、[4,5] 和 [1,4,5] 。
 * 示例 2：
 *
 * 输入：nums = [2,3,1], k = 3
 * 输出：1
 * 解释：[3] 是唯一一个中位数等于 3 的子数组。
 *   
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i], k <= n
 * nums 中的整数互不相同
 *
 */
public class LeetCode2488 {
    /**
     * 超时  10的5次方 不能双循环
     * @param nums
     * @param k
     * @return
     */
    public int countSubarrays(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            int right = 0;
            boolean flag = false;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < k) {
                    left++;
                } else if (nums[j] > k){
                    right++;
                } else {
                    flag = true;
                }
                if (right == left || (right - left == 1)) {
                    if (flag) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode2488 leetCode2488 = new LeetCode2488();
//        int[] arr = {2, 3, 1};
//        int k = 3;
        int[] arr = {3,2,1,4,5};
        int k = 4;
//        int[] arr = {3,2,1,6,4,5};
//        int k = 4;
        System.out.println(leetCode2488.countSubarrays(arr, k));
    }

    
}
