package leetcode.LinkedList;

public class leetcode_202 {
    static void main() {
        int n = 19;
        System.out.println(isHappy(n));
    }

    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = sqrt(slow);
            fast = sqrt(sqrt(fast));
        } while (slow != fast);
        return slow == 1;
    }

    static int sqrt(int n) {
        int sqrt = 0;
        for (int i = n; i > 0; i = i / 10) {
            sqrt = sqrt + (int) Math.pow(i % 10, 2);
        }
        return sqrt;
    }
}
