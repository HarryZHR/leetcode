import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class LeetCode018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    for (int m = k + 1; m < nums.length; m++) {
                        int sum = nums[i] + nums[j] + nums[k] + nums[m];
                        if (sum == target) {
                            List<Integer> rows = new ArrayList<>();
                            rows.add(nums[i]);
                            rows.add(nums[j]);
                            rows.add(nums[k]);
                            rows.add(nums[m]);
                            if (!results.contains(rows)) {
                                results.add(rows);
                            }
                        }
                    }
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        LeetCode018 test = new LeetCode018();
        int[] nums = {1, 0, -1, 0, -2, 2};
//        System.out.println(test.fourSum(nums, 0));




    }


}
