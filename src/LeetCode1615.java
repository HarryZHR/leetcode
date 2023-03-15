/**
 * n 座城市和一些连接这些城市的道路 roads 共同组成一个基础设施网络。每个 roads[i] = [ai, bi] 都表示在城市 ai 和 bi 之间有一条双向道路。
 * <p>
 * 两座不同城市构成的 城市对 的 网络秩 定义为：与这两座城市 直接 相连的道路总数。如果存在一条道路直接连接这两座城市，则这条道路只计算 一次 。
 * <p>
 * 整个基础设施网络的 最大网络秩 是所有不同城市对中的 最大网络秩 。
 * <p>
 * 给你整数 n 和数组 roads，返回整个基础设施网络的 最大网络秩 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 4, roads = [[0,1],[0,3],[1,2],[1,3]]
 * 输出：4
 * 解释：城市 0 和 1 的网络秩是 4，因为共有 4 条道路与城市 0 或 1 相连。位于 0 和 1 之间的道路只计算一次。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 5, roads = [[0,1],[0,3],[1,2],[1,3],[2,3],[2,4]]
 * 输出：5
 * 解释：共有 5 条道路与城市 1 或 2 相连。
 * 示例 3：
 * <p>
 * 输入：n = 8, roads = [[0,1],[1,2],[2,3],[2,4],[5,6],[5,7]]
 * 输出：5
 * 解释：2 和 5 的网络秩为 5，注意并非所有的城市都需要连接起来。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 100
 * 0 <= roads.length <= n * (n - 1) / 2
 * roads[i].length == 2
 * 0 <= ai, bi <= n-1
 * ai != bi
 * 每对城市之间 最多只有一条 道路相连
 */
public class LeetCode1615 {

    public int maximalNetworkRank(int n, int[][] roads) {
        int max = 0;
        int arrLength = n * (n - 1) / 2;
        int[][] arr = new int[arrLength][2];
        int arrIndex = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] a = {i, j};
                arr[arrIndex++] = a;
            }
        }
        for (int i = 0; i < arrIndex; i++) {
            int count = 0;
            for (int[] road : roads) {
                if ((arr[i][0] == road[0] && arr[i][1] == road[1]) || (arr[i][1] == road[0] && arr[i][0] == road[1])) {
                    count++;
                } else if (arr[i][0] == road[0] || arr[i][1] == road[0]) {
                    count++;
                } else if (arr[i][0] == road[1] || arr[i][1] == road[1]) {
                    count++;
                }
            }
            max = Math.max(count, max);
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode1615 leetCode1615 = new LeetCode1615();
//        int n = 5;
//        int[][] roads = {{0, 1}, {0, 3}, {1, 2}, {1, 3}, {2, 3}, {2, 4}};
//        int n = 8;
//        int[][] roads = {{0,1},{1,2},{2,3},{2,4},{5,6},{5,7}};
        int n = 4;
        int[][] roads = { {0,1 }, {0,3 }, {1,2 }, {1,3 }};
        System.out.println(leetCode1615.maximalNetworkRank(n, roads));
    }
}
