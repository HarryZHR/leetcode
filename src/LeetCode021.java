import java.util.List;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * <p>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 * <p>
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 */
public class LeetCode021 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 先初始化一个链表，由于必须给定一个链表值，所以先赋予0
        ListNode listNode = new ListNode(0);
        // 再初始化一个结果集链表，将上面初始化的链表赋给这个结果集，主要操作的还是listNode，resNode只是做一个容器放一下内容
        ListNode resNode = listNode;
        // 当两个list都不为空是，比较当前两个list的值
        while (list1 != null && list2 != null) {
            // 将小的那个值赋给listNode的next
            if (list1.val < list2.val) {
                listNode.next = list1;
                // 将含有小值的list向后弹一格
                list1 = list1.next;
            } else {
                listNode.next = list2;
                list2 = list2.next;
            }
            // 将listNode的当前值向后弹一格，否则会一直在当前格子里放值
            listNode = listNode.next;
        }
        // 没放完的那个直接追加到listNode后面
        if (list1 != null) {
            listNode.next = list1;
        }
        if (list2 != null) {
            listNode.next = list2;
        }
        // 最后给的时候 要注意去掉初始化时给的0
        return resNode.next;
    }

    public static void main(String[] args) {
        LeetCode021 leetCode021 = new LeetCode021();
        ListNode nodeSta = new ListNode(0);
        ListNode nextNode;
        nextNode = nodeSta;

        //创建链表
        for (int i = 1; i < 5; i++) {
            ListNode node = new ListNode(i);
            nextNode.next = node;
            nextNode = nextNode.next;
        } //当for循环完成之后 nextNode指向最后一个节点，
        ListNode nodeSta2 = new ListNode(0);
        ListNode nextNode2;
        nextNode2 = nodeSta2;

        //创建链表
        for (int i = 1; i < 5; i++) {
            ListNode node2 = new ListNode(i);
            nextNode2.next = node2;
            nextNode2 = nextNode2.next;
        } //当for循环完成之后 nextNode指向最后一个节点，
//        System.out.println(nodeSta);
        System.out.println(leetCode021.mergeTwoLists(nodeSta, nodeSta2));
    }
}
