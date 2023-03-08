import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.

 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Example

     Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     Output: 7 -> 0 -> 8
     Explanation: 342 + 465 = 807.

    给你两个非空的链表代表两个非负的整数，这些数字是反向存储的，而且每个节点都只有一个数字，将两个数字相加形成一个新的链表。

    你可以假定相加的两个数字不包括0开头，除了0本身


 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 输出：[8,9,9,9,0,0,0,1]
 */
public class LeetCode002 {


    /**
     * 直接挨个相加 如果要进一 则将flag改成1，否则改成0，每次相加时都加上flag，
     * 结果超过9时只保留个位，进一
     * 如果一直到最后都还有进一 需要在尾巴上再加个1
     * @param l1
     * @param l2
     * @return
     */
    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;
        ListNode l3 = new ListNode(0);
        ListNode l4 = l3;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int sum = a + b + flag;
            if (sum > 9) {
                l3.val = sum - 10;
                flag = 1;
            } else {
                l3.val = sum;
                flag = 0;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            if (flag == 1) {
                l3.next = new ListNode(1);
            } else {
                if (l1 != null || l2 != null) {
                    l3.next = new ListNode(0);
                }
            }
            l3 = l3.next;
        }
        return l4;
    }

     public static void main(String[] args) {
         LeetCode002 l = new LeetCode002();
//         ListNode l1 = new ListNode(2);
//         l1.next = new ListNode(4);
//         l1.next.next = new ListNode(3);
//         ListNode l2 = new ListNode(5);
//         l2.next = new ListNode(6);
//         l2.next.next = new ListNode(4);
//         ListNode l1 = new ListNode(9);
//         l1.next = new ListNode(9);
//         l1.next.next = new ListNode(9);
//         l1.next.next.next = new ListNode(9);
//         l1.next.next.next.next = new ListNode(9);
//         l1.next.next.next.next.next = new ListNode(9);
//         l1.next.next.next.next.next.next = new ListNode(9);
//         ListNode l2 = new ListNode(9);
//         l2.next = new ListNode(9);
//         l2.next.next = new ListNode(9);
//         l2.next.next.next = new ListNode(9);
//         ListNode l1 = new ListNode(0);
//         ListNode l2 = new ListNode(0);
         ListNode l1 = new ListNode(1);
         l1.next = new ListNode(0);
         l1.next.next = new ListNode(4);
         l1.next.next.next = new ListNode(3);
         ListNode l2 = new ListNode(5);
         l2.next = new ListNode(6);
         l2.next.next = new ListNode(4);

         l.addTwoNumbers(l1,l2);
     }
}
