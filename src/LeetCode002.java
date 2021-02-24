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
 */
public class LeetCode002 {

     private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         List<Integer> intList1 = new ArrayList<>();
         List<Integer> intList2 = new ArrayList<>();
         intList1.add(l1.val);
         intList2.add(l2.val);
         while (l1.next != null){
             l1 = l1.next;
             intList1.add(l1.val);
         }
         while (l2.next != null){
             l2 = l2.next;
             intList2.add(l2.val);
         }
         Collections.reverse(intList1);
         Collections.reverse(intList2);
         List<Integer> results = new ArrayList<>();
         if(intList1.size() >= intList2.size()){
             for( int i = 0; i < intList1.size(); i++) {
                 if(intList2.get(i) != null){
                     int result = intList1.get(i) + intList2.get(i);
                     if(result < 10){
                         results.set(i,result + results.get(i));
                     }else {
                         results.set(i + 1, 1);
                         results.set(i,result - 10 + results.get(i));
                     }
                 }
             }
         }
         for (Integer i : results){
             System.out.println(i);
         }
         return null;
     }

     public static void main(String[] args) {
         LeetCode002 l = new LeetCode002();
         ListNode l1 = new ListNode(2);
         l1.next = new ListNode(4);
         l1.next.next = new ListNode(3);
         ListNode l2 = new ListNode(5);
         l2.next = new ListNode(6);
         l2.next.next = new ListNode(4);
         l.addTwoNumbers(l1,l2);
     }
}
