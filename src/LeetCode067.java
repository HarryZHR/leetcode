public class LeetCode067 {

    public String addBinary(String a, String b) {
        a = reserveStr(a);
        b = reserveStr(b);
        int aLength = a.length();
        int bLength = b.length();
        int count = Math.max(aLength, bLength);
        StringBuilder res = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < count; i++) {
            int sum;
            int aCurrent = a.length() > i ? Integer.parseInt(a.charAt(i) + "") : 0;
            int bCurrent = b.length() > i ? Integer.parseInt(b.charAt(i) + "") : 0;
            if (flag) {
                 sum = aCurrent + bCurrent + 1;
            } else {
                sum = aCurrent + bCurrent;
            }
            if (sum == 2) {
                flag = true;
                res.append("0");
            } else if (sum == 3) {
                flag = true;
                res.append("1");
            } else {
                flag = false;
                res.append(sum);
            }
        }
        if (flag) {
            res.append("1");
        }

        return res.reverse().toString();
    }

    private String reserveStr(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public static void main(String[] args) {
        LeetCode067 leetCode067 = new LeetCode067();
//        String a = "11";
//        String b = "1";
//        String a = "1010";
//        String b = "1011";
        String a = "1111";
        String b = "1111";
        System.out.println(leetCode067.addBinary(a, b));
    }
}
