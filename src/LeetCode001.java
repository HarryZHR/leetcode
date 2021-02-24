/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:

 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 翻译：

 给出一个Integer的数组，返回数组中两个数字相加等于一个特殊目标值的索引。你需要确保每个输入案例都只有唯一解，而且数组中不能使用相同的元素。
 */
public class LeetCode001 {

    private int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        LeetCode001 leetCode001 = new LeetCode001();
        int[] arrs = leetCode001.twoSum(nums,target);
        if(arrs != null){
            for (int arr : arrs) {
                System.out.println(arr + "-");
            }
        }else{
            System.out.println("arrs is null");
        }
    }
}
