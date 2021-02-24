/**
 *Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3.
 Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 给出一个字符串，找到他没有重复的最长子串的长度

 */
public class LeetCode003 {
    private int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for(int k = 0; k < s.length(); k++){
            int start = 0;
            for(int i = 0; i < s.length(); i++){
                int length = 1;
                for(int j = start; j < i; j++){
                    if(s.charAt(i) == s.charAt(j)){
                        start = i;
                        break;
                    }else {
                        length++;
                    }
                }
                if(maxLength < length){
                    maxLength = length;
                }
            }
        }
        return maxLength;

    }

    public static void main(String[] args) {
        LeetCode003 l = new LeetCode003();
        System.out.println(l.lengthOfLongestSubstring("vfva"));
//        l.lengthOfLongestSubstring("pwwkew");
    }
}
