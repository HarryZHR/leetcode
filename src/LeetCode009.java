/**
 *
    Determine whether an integer is a palindrome.
    An integer is a palindrome when it reads the same backward as forward.

    判断一个整数是否是回文数，当一个整数正着念和倒着念是一样时，就是回文数
 */

public class LeetCode009 {
    private boolean isPalindrome(int x) {
        return x >= 0 && x == Long.valueOf(new StringBuilder(String.valueOf(x)).reverse().toString());
    }

    public static void main(String[] args) {
        LeetCode009 l = new LeetCode009();
        System.out.println(l.isPalindrome(-12));
    }
}