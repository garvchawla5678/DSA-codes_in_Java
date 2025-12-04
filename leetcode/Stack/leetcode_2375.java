package leetcode.Stack;

import java.util.*;

public class leetcode_2375 {
    static void main() {
        String s = "IIIDIDDD";
        System.out.println(smallestNumber(s));

    }

    public static String smallestNumber(String pattern) {
        int n = pattern.length();
        int[] ans = new int[n + 1];
        Stack<Integer> st = new Stack<>();
        int count = 1;
        for (int i = 0; i <= n; i++) {
            if (i == n || pattern.charAt(i) == 'I') {
                ans[i] = count++;
                while (!st.isEmpty()) {
                    ans[st.pop()] = count++;
                }
            } else {
                st.push(i);
            }
        }
        StringBuilder ans1 = new StringBuilder();
        for (int i : ans) {
            ans1.append(i);
        }
        return ans1.toString();
    }
}