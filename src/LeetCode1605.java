/**
 * 给你两个非负整数数组 rowSum 和 colSum ，其中 rowSum[i] 是二维矩阵中第 i 行元素的和， colSum[j] 是第 j 列元素的和。换言之你不知道矩阵里的每个元素，但是你知道每一行和每一列的和。
 *
 * 请找到大小为 rowSum.length x colSum.length 的任意 非负整数 矩阵，且该矩阵满足 rowSum 和 colSum 的要求。
 *
 * 请你返回任意一个满足题目要求的二维矩阵，题目保证存在 至少一个 可行矩阵。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：rowSum = [3,8], colSum = [4,7]
 * 输出：[[3,0],
 *       [1,7]]
 * 解释：
 * 第 0 行：3 + 0 = 3 == rowSum[0]
 * 第 1 行：1 + 7 = 8 == rowSum[1]
 * 第 0 列：3 + 1 = 4 == colSum[0]
 * 第 1 列：0 + 7 = 7 == colSum[1]
 * 行和列的和都满足题目要求，且所有矩阵元素都是非负的。
 * 另一个可行的矩阵为：[[1,2],
 *                   [3,5]]
 * 示例 2：
 *
 * 输入：rowSum = [5,7,10], colSum = [8,6,8]
 * 输出：[[0,5,0],
 *       [6,1,0],
 *       [2,0,8]]
 * 示例 3：
 *
 * 输入：rowSum = [14,9], colSum = [6,9,8]
 * 输出：[[0,9,5],
 *       [6,0,3]]
 * 示例 4：
 *
 * 输入：rowSum = [1,0], colSum = [1]
 * 输出：[[1],
 *       [0]]
 * 示例 5：
 *
 * 输入：rowSum = [0], colSum = [0]
 * 输出：[[0]]
 *  
 *
 * 提示：
 *
 * 1 <= rowSum.length, colSum.length <= 500
 * 0 <= rowSum[i], colSum[i] <= 108
 * sum(rowSum) == sum(colSum)
 *
 */
public class LeetCode1605 {
    /**                     row
     *      |    |   |   |   5
     *      |    |   |   |   7
     *      |    |   |   |   10
     * col    8   6   8
     *
     * 一行行看，先比较改行row和col[0]的值
     * 比较row[i] col[j]
     *      如果row < col 则第一格填上col - row， 此时更新col为col - row，与此同时将该行后面几个格子都填0
     *      如果row > col 则第一格填上row - col， 此时更新col为0，更新row为row - col，然后拿此row和后方格子的col[j]相比
     *          如果col[j] > row 则该格子填上 col[j] - row，更新col[j] 为col[j] - row 后续都填0
     *          如果col[j] < row 则该格子填上 col[j]，更新col[j]为0，更新row为row - col[j]，继续比较 直至为row为0后续都填0
     *
     *
     * @param rowSum
     * @param colSum
     * @return
     */

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][] arr = new int[m][n];
        int i = 0;
        while (i < m) {
            int j = 0;
            if (rowSum[i] <= colSum[0]) {
                arr[i][j] = rowSum[i];
                if (i < m - 1) {
                    colSum[j] -= rowSum[i];
                }
                for (int k = j + 1; k < n; k++) {
                    arr[i][k] = 0;
                }
            } else {
                arr[i][j] = colSum[j];
                if (i < m - 1) {
                    colSum[j] = 0;
                }
                int spare = rowSum[i] - arr[i][j];
                for (int k = 1; k < n; k++) {
                    if (colSum[k] >= spare) {
                        arr[i][k] = spare;
                        colSum[k] = colSum[k] - spare;
                        spare = 0;
                    } else {
                        arr[i][k] = colSum[k];
                        spare -= colSum[k];
                        colSum[k] = 0;
                    }
                }

            }
            i++;
        }

        for (int j = 0; j < m; j++) {
            for (int k = 0; k < n; k++) {
                System.out.print(arr[j][k]+ ",\t");
            }
            System.out.println();
        }
        return arr;
    }

    public static void main(String[] args) {
        LeetCode1605 leetCode1605 = new LeetCode1605();
//        int[] rowSum = {3,8};
//        int[] colSum = {4,7};
//        int[] rowSum = {5,7,10};
//        int[] colSum = {8,6,8};
//        int[] rowSum = {5,7,10, 10, 10};
//        int[] colSum = {8,6,8, 10, 10};
//        int[] rowSum = {4,12,10,1,0};
//        int[] colSum = {1,0,3,16,7};
        int[] rowSum = {0};
        int[] colSum = {0};
//        int[] rowSum = {14, 9};
//        int[] colSum = {6,9,8};
//        int[] rowSum = {1,0};
//        int[] colSum = {1};
//        int[] rowSum = {22,5,28,15,5,21,44,8,68,47};
//        int[] colSum = {42,14,18,29,27,40,31,48,14};
        leetCode1605.restoreMatrix(rowSum, colSum);
    }
}
