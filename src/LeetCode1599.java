/**
 * 你正在经营一座摩天轮，该摩天轮共有 4 个座舱 ，每个座舱 最多可以容纳 4 位游客 。你可以 逆时针 轮转座舱，但每次轮转都需要支付一定的运行成本 runningCost 。摩天轮每次轮转都恰好转动 1 / 4 周。
 *
 * 给你一个长度为 n 的数组 customers ， customers[i] 是在第 i 次轮转（下标从 0 开始）之前到达的新游客的数量。这也意味着你必须在新游客到来前轮转 i 次。每位游客在登上离地面最近的座舱前都会支付登舱成本 boardingCost ，一旦该座舱再次抵达地面，他们就会离开座舱结束游玩。
 *
 * 你可以随时停下摩天轮，即便是 在服务所有游客之前 。如果你决定停止运营摩天轮，为了保证所有游客安全着陆，将免费进行所有后续轮转 。注意，如果有超过 4 位游客在等摩天轮，那么只有 4 位游客可以登上摩天轮，其余的需要等待 下一次轮转 。
 *
 * 返回最大化利润所需执行的 最小轮转次数 。 如果不存在利润为正的方案，则返回 -1 。
 *
 * 示例1:
 *
 * 输入：customers = [8,3], boardingCost = 5, runningCost = 6
 * 输出：3
 * 解释：座舱上标注的数字是该座舱的当前游客数。
 * 1. 8 位游客抵达，4 位登舱，4 位等待下一舱，摩天轮轮转。当前利润为 4 * $5 - 1 * $6 = $14 。
 * 2. 3 位游客抵达，4 位在等待的游客登舱，其他 3 位等待，摩天轮轮转。当前利润为 8 * $5 - 2 * $6 = $28 。
 * 3. 最后 3 位游客登舱，摩天轮轮转。当前利润为 11 * $5 - 3 * $6 = $37 。
 * 轮转 3 次得到最大利润，最大利润为 $37 。
 *
 * 示例 2：
 *
 * 输入：customers = [10,9,6], boardingCost = 6, runningCost = 4
 * 输出：7
 * 解释：
 * 1. 10 位游客抵达，4 位登舱，6 位等待下一舱，摩天轮轮转。当前利润为 4 * $6 - 1 * $4 = $20 。
 * 2. 9 位游客抵达，4 位登舱，11 位等待（2 位是先前就在等待的，9 位新加入等待的），摩天轮轮转。当前利润为 8 * $6 - 2 * $4 = $40 。
 * 3. 最后 6 位游客抵达，4 位登舱，13 位等待，摩天轮轮转。当前利润为 12 * $6 - 3 * $4 = $60 。
 * 4. 4 位登舱，9 位等待，摩天轮轮转。当前利润为 * $6 - 4 * $4 = $80 。
 * 5. 4 位登舱，5 位等待，摩天轮轮转。当前利润为 20 * $6 - 5 * $4 = $100 。
 * 6. 4 位登舱，1 位等待，摩天轮轮转。当前利润为 24 * $6 - 6 * $4 = $120 。
 * 7. 1 位登舱，摩天轮轮转。当前利润为 25 * $6 - 7 * $4 = $122 。
 * 轮转 7 次得到最大利润，最大利润为$122 。
 *
 * 示例 3：
 *
 * 输入：customers = [3,4,0,5,1], boardingCost = 1, runningCost = 92
 * 输出：-1
 * 解释：
 * 1. 3 位游客抵达，3 位登舱，0 位等待，摩天轮轮转。当前利润为 3 * $1 - 1 * $92 = -$89 。
 * 2. 4 位游客抵达，4 位登舱，0 位等待，摩天轮轮转。当前利润为 is 7 * $1 - 2 * $92 = -$177 。
 * 3. 0 位游客抵达，0 位登舱，0 位等待，摩天轮轮转。当前利润为 7 * $1 - 3 * $92 = -$269 。
 * 4. 5 位游客抵达，4 位登舱，1 位等待，摩天轮轮转。当前利润为 12 * $1 - 4 * $92 = -$356 。
 * 5. 1 位游客抵达，2 位登舱，0 位等待，摩天轮轮转。当前利润为 13 * $1 - 5 * $92 = -$447 。
 * 利润永不为正，所以返回 -1 。
 *
 * 提示:
 * n == customers.length
 * 1 <= n <= 10 5
 * 0 <= customers[i] <= 50
 * 1 <= boardingCost, runningCost <= 100
 */
public class LeetCode1599 {

    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int[] arr = new int[13 * 100000];
        int count = 0;
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] <= 4) {
                arr[count++] = customers[i];
            } else {
                if (i != (customers.length - 1)) {
                    customers[i + 1] += (customers[i] - 4);
                    arr[count++] = 4;
                } else {
                    while (customers[i] > 0) {
                        arr[count++] = Math.min(customers[i], 4);
                        customers[i] -= 4;
                    }
                }
            }
        }
        int max = 0;
        int all = 0;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            all += arr[i] * boardingCost - runningCost;
            if (max < all) {
                max = all;
                index = i + 1;
            }
        }
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + ",");
//        }
        return index;
    }

    public static void main(String[] args) {
        LeetCode1599 leetCode1599 = new LeetCode1599();
//        int[] arr = {8,3};
//        int a = 5;
//        int b = 6;

//        int[] arr = {10,9,6};
//        int a = 6;
//        int b = 4;
//        int[] arr = {3,4,0,5,1};
//        int a = 1;
//        int b = 92;
        int[] arr = {32,48,1,36,44,23,24,2,19,28,21,26,32,13,15,14,22,8,39,2,46,4,9,26,8,11,17,17,28,5,24,15,20,48,9,9,28,10,16,25,7,31,1,33,46,23,14,8,6,18,18,17,49,35,24,44,41,5,6,43,25,49,48,30,4,16,40,35,19,29,20,23,38,24,6,46,20,22,9,26,28,18,26,48,9,38,29,12,17,19,10,17,31,21,42,47,16,20,37,48,36,26,12,42,43,13,10,18,41,50,25,15,23,44,32,34,26,29,37,16,29,43,23,50,12,12,31,18,39,1,8,37,31,9,23,21,48,23,47,49,8,23,19,49,48,9,22,34,42,43,33,39,24,17,30,13,6,48,21,34,47,27,38,49,8,39,38,40,27,24,38,49,8,17,38,32,26,7,49,19,12,15,49,0,45,4,44,32,28,7,12,32,29,22,5,35,48,21,33,38,36,16,10,0,21,34,30,4,45,22,7,25,48};
        int a = 6;
        int b = 4;
        System.out.println(leetCode1599.minOperationsMaxProfit(arr, a, b));
    }
}
