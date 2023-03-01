import java.util.Arrays;

/**
 * 给你一个大小为 n x n 的整数矩阵 grid 。
 *
 * 生成一个大小为 (n - 2) x (n - 2) 的整数矩阵  maxLocal ，并满足：
 *
 * maxLocal[i][j] 等于 grid 中以 i + 1 行和 j + 1 列为中心的 3 x 3 矩阵中的 最大值 。
 * 换句话说，我们希望找出 grid 中每个 3 x 3 矩阵中的最大值。
 *
 * 返回生成的矩阵。
 *
 *
 * 示例 1：
 * 输入：grid = [[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]
 * 输出：[[9,9],[8,6]]
 * 解释：原矩阵和生成的矩阵如上图所示。
 * 注意，生成的矩阵中，每个值都对应 grid 中一个相接的 3 x 3 矩阵的最大值。
 *
 * 
 * 示例 2：
 * 输入：grid = [[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]]
 * 输出：[[2,2,2],[2,2,2],[2,2,2]]
 * 解释：注意，2 包含在 grid 中每个 3 x 3 的矩阵中。
 *
 *
 */
public class LeetCode2373 {

    /**
     * 方法一： 为了追求少用循环的思想，将每次九宫格里的内容都放进一个数组中，在getMax的方法里利用一维数组求出最大值
     * 这种方法只用到了三重循环，但是将二维数组转换成一维，浪费了太多空间和内存
     */
    public int[][] largestLocal(int[][] grid) {
        int length = grid.length;
        int[][] resArr = new int[length - 2][length - 2];
        for (int i = 0; i < grid.length - 2; i++) {
            int[] arr = new int[9];
            for (int j = 0; j < grid.length - 2; j++) {
                arr[0] = grid[i][j];
                arr[1] = grid[i + 1][j];
                arr[2] = grid[i + 2][j];
                arr[3] = grid[i][j + 1];
                arr[4] = grid[i + 1][j + 1];
                arr[5] = grid[i + 2][j + 1];
                arr[6] = grid[i][j + 2];
                arr[7] = grid[i + 1][j + 2];
                arr[8] = grid[i + 2][j + 2];
                resArr[i][j] = getMaxInArray(arr);
            }
        }
        return resArr;
    }

    private int getMaxInArray(int[] array) {
        int max = 0;
        for (int i : array) {
            if (max < i) {
                max = i;
            }
        }
        return max;
    }

    /**
     * 方法二： 将本次循环的九宫格直接传入到getMax方法去获取最大值
     * 这种方法虽然用到了四重循环，但是在getMax里可以直接比较得出最大值，避免了不必要的内存开销
     */
    public int[][] largestLocal2(int[][] grid) {
        int length = grid.length;
        int[][] resArr = new int[length - 2][length - 2];
        for (int i = 0; i < resArr.length; i++) {
            for (int j = 0; j < resArr.length; j++) {
                resArr[i][j] = getMax(grid, i, j);
            }
        }
        return resArr;
    }

    private int getMax(int[][] arr, int i, int j) {
        int max = 0;
        for (int k = i; k < i + 3; k++) {
            for (int l = j; l < j + 3; l++) {
                if (max < arr[k][l]) {
                    max = arr[k][l];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode2373 leetCode2373 = new LeetCode2373();
//        int[][] a = {{9,9,8,1}, {5,6,2,6}, {8,2,6,4}, {6,2,2,2}};
//        int[][] a = {{1,1,1,1,1},{1,1,1,1,1},{1,1,2,1,1},{1,1,1,1,1},{1,1,1,1,1}};
        int[][] a = {{1,1,1},{1,1,1},{1,1,2}};
        System.out.println(Arrays.deepToString(leetCode2373.largestLocal(a)));
    }
}
