import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个长度为 n 的字符串数组 names 。你将会在文件系统中创建 n 个文件夹：在第 i 分钟，新建名为 names[i] 的文件夹。
 *
 * 由于两个文件 不能 共享相同的文件名，因此如果新建文件夹使用的文件名已经被占用，系统会以 (k) 的形式为新文件夹的文件名添加后缀，其中 k 是能保证文件名唯一的 最小正整数 。
 *
 * 返回长度为 n 的字符串数组，其中 ans[i] 是创建第 i 个文件夹时系统分配给该文件夹的实际名称。
 *
 *  
 *示例 1：
 *
 * 输入：names = ["pes","fifa","gta","pes(2019)"]
 * 输出：["pes","fifa","gta","pes(2019)"]
 * 解释：文件系统将会这样创建文件名：
 * "pes" --> 之前未分配，仍为 "pes"
 * "fifa" --> 之前未分配，仍为 "fifa"
 * "gta" --> 之前未分配，仍为 "gta"
 * "pes(2019)" --> 之前未分配，仍为 "pes(2019)"
 * 示例 2：
 *
 * 输入：names = ["gta","gta(1)","gta","avalon"]
 * 输出：["gta","gta(1)","gta(2)","avalon"]
 * 解释：文件系统将会这样创建文件名：
 * "gta" --> 之前未分配，仍为 "gta"
 * "gta(1)" --> 之前未分配，仍为 "gta(1)"
 * "gta" --> 文件名被占用，系统为该名称添加后缀 (k)，由于 "gta(1)" 也被占用，所以 k = 2 。实际创建的文件名为 "gta(2)" 。
 * "avalon" --> 之前未分配，仍为 "avalon"
 * 示例 3：
 *
 * 输入：names = ["onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"]
 * 输出：["onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece(4)"]
 * 解释：当创建最后一个文件夹时，最小的正有效 k 为 4 ，文件名变为 "onepiece(4)"。
 * 示例 4：
 *
 * 输入：names = ["wano","wano","wano","wano"]
 * 输出：["wano","wano(1)","wano(2)","wano(3)"]
 * 解释：每次创建文件夹 "wano" 时，只需增加后缀中 k 的值即可。
 * 示例 5：
 *
 * 输入：names = ["kaido","kaido(1)","kaido","kaido(1)"]
 * 输出：["kaido","kaido(1)","kaido(2)","kaido(1)(1)"]
 * 解释：注意，如果含后缀文件名被占用，那么系统也会按规则在名称后添加新的后缀 (k) 。
 *  
 *
 * ["kaido","kaido(1)","kaido","kaido(1)","kaido(2)"]
 * ["kaido","kaido(1)","kaido(2)","kaido(1)(1)","kaido(2)(1)"]
 *
 * 提示：
 *
 * 1 <= names.length <= 5 * 10^4
 * 1 <= names[i].length <= 20
 * names[i] 由小写英文字母、数字和/或圆括号组成。
 *
 */
public class LeetCode1487 {

    // 三重循环 超时
    public String[] getFolderNames(String[] names) {
        for (int i = 0; i < names.length - 1; i++) {
            int k = 1;
            for (int j = i + 1; j < names.length; j++) {
                if (names[j].equals(names[i])) {
                    for (int l = 0; l < j; l++) {
                        if ((names[j] + "(" + k + ")").equals(names[l])) {
                            k++;
                            l = -1;
                        }
                    }
                    names[j] += "(" + k + ")";
                }

            }
        }
        for (int k = 0; k < names.length; k++) {
            System.out.print(names[k] + ",");
        }

        return names;
    }

    /**
     * 官方思路：
     * 使用哈希表index记录已创建的文件夹的下一后缀序号，遍历names数组，记当前遍历的文件名为name：
     *
     * 如果name 不在哈希表中，那么说明文件系统不存在名为name的文件夹，我们直接创建该文件夹，并且记录对应文件夹的下一后缀序号为1。
     *
     * 如果name 在哈希表中，那么说明文件系统已经存在名为 name 的文件夹，我们在哈希表找到name 的下一后缀序号k，
     * 逐一尝试直到添加后缀k 的新文件名不存在于哈希表中，然后创建该文件夹。需要注意的是，创建该文件夹后，有两个文件名的下一后缀序号需要修改，
     * 首先文件名 name 的下一后缀序号为 k+1，其次，文件名 name 添加后缀 k 的新文件名的下一后缀序号为 1。
     *
     *
     * 个人理解：
     * 1.先循环将文件名放进map，如果map没有，则直接放入名字，记下标为0
     * 2.如果map里有，则取出当前文件名的下标，并且+1，指明当前的后缀是多少
     * 3.拿文件名拼接后缀去查找，如果map中没有，则将新文件名放进当前位置
     * 4.如果map中有，则需要拿拼接结果去循环查找当前文件名之前的文件名，每找到一次就要+1，并且再从头开始查找，直至找不到为止
     * 5.当找不到拼接名之后，将新的文件名放置到当前位置，
     *
     * 注意：在放置文件至当前位置之前，需要先更新好标记，不仅要更新原先的标记，并且要将新的文件名也放进map中
     *
     *
     *
     *
     * @param names
     * @return
     */
    public String[] getFolderNames2(String[] names) {

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            if (!map.containsKey(names[i])) {
                map.put(names[i], 0);
            } else {
                int k = map.get(names[i]) + 1;
                if (map.containsKey(names[i] + "(" + k + ")")) {
                    int j = 0;
                    while (j < i) {
                        if ((names[i] + "(" + k + ")").equals(names[j])) {
                            k++;
                            j = -1;
                        }
                        j++;
                    }
                }
                map.put(names[i], k);
                map.put(names[i] + "(" + k + ")", 0);
                names[i] = names[i] + "(" + k + ")";
            }
        }


        for (int k = 0; k < names.length; k++) {
            System.out.print(names[k] + ",");
        }
        return names;
    }

    public static void main(String[] args) {
        LeetCode1487 leetCode1487 = new LeetCode1487();
//            String[] a = {"pes","fifa","gta","pes(2019)"};
//        String[] a = {"gta","gta(1)","gta","avalon"};
//        String[] a = {"onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"};
//        String[] a = {"wano","wano","wano","wano"};
//        String[] a = {"kaido","kaido(1)","kaido","kaido(1)"};
//        String[] a = {"b(1)", "b", "b"};
//        String[] a = {"c(2)", "c", "c", "c(3)(1)", "c"};
        String[] a = {"kaido","kaido(1)","kaido","kaido(1)","kaido(2)"};
        leetCode1487.getFolderNames2(a);
    }

}
