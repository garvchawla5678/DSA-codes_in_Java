package leetcode.Stack;

import java.util.Arrays;
import java.util.Stack;

public class leetcode_853 {
    static void main() {
        int[] speed = { 2, 4, 1, 1, 3 };
        int[] position = { 10, 8, 0, 5, 3 };
        int target = 12;
        System.out.println(carFleet(target, position, speed));
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Stack<Double> st = new Stack<>();
        int[][] pair = new int[n][2];
        for (int i = 0; i < n; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));
        for (int[] t : pair) {
            double time = (double) (target - t[0]) / t[1];
            st.push(time);
            if (st.size() >= 2 && st.peek() <= st.get(st.size() - 2)) {
                st.pop();
            }
        }

        return st.size();
    }
}
