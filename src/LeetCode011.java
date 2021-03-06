/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 画 n 条垂直线，使得垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 注意：你不能倾斜容器，n 至少是2。
 */
public class LeetCode011 {
    private int maxArea(int[] height) {
        int maxWater = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int water = (height[i] > height[j] ? height[j] : height[i]) * (j - i);
            if (maxWater < water) {
                maxWater = water;
            }
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        LeetCode011 l = new LeetCode011();
        int[] height = {1, 3, 5, 7, 4, 6};
        /* int[] height = new int[15000];
        for(int i = 0; i< 15000; i++){
            height[i] = 15000 - i;
        }*/
        System.out.println(l.maxArea(height));
    }
}
