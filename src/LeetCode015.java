import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
    给定一个由n个整数组成的数组，有没有这样三个元素a,b,c，类似于 a + b + c = 0?
    找出所有不同的组合中和为0的数组。
 Note:

 The solution set must not contain duplicate triplets.
 结果集合必须不能重复

 Example:

 Given array nums = [-1, 0, 1, 2, -1, -4],
   sorted  [-4, -1, -1, 0, 1, 2]
 A solution set is:
 [[-1, 0, 1],[-1, -1, 2]]

 */
public class LeetCode015 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> integerList = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            for (int j = i + 1,k = nums.length - 1;j < k;){
                if(nums[j] == nums[j - 1]){
                    break;
                }
                if(nums[i] + nums[j] + nums[k] == 0){
                    List<Integer> integers = new ArrayList<>();
                    integers.add(nums[i]);
                    integers.add(nums[j]);




                    integers.add(nums[k]);
                    if(!integerList.contains(integers)){
                        integerList.add(integers);
                    }
                }

            }
        }
        return integerList;
    }


    /*超时结果*/
    /*public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> integerList = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){
            for(int j = i + 1; j <nums.length - 1; j++){
                for(int k = j + 1; k < nums.length; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> integers = new ArrayList<>();
                        integers.add(nums[i]);
                        integers.add(nums[j]);
                        integers.add(nums[k]);
                        Collections.sort(integers);
                        if(!integerList.contains(integers)){
                            integerList.add(integers);
                        }
                    }
                }
            }
        }
        return integerList;
    }*/

    public static void main(String[] args) {
        LeetCode015 l = new LeetCode015();
        int[] integers = {-1, 0, 1, 2, -1, -4};
        System.out.println(l.threeSum(integers));
    }
}
