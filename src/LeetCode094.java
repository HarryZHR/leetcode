import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *  
 *
 */
public class LeetCode094 {
    List<Integer> integers = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {

        if (root != null) {
            inorderTraversal(root.left);
            integers.add(root.val);
            inorderTraversal(root.right);
        }
        return integers;
    }




    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        LeetCode094 leetCode094 = new LeetCode094();
        System.out.println(leetCode094.inorderTraversal(treeNode1));
    }
}
