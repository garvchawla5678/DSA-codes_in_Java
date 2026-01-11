package leetcode.Recursion;

import java.util.ArrayList;
import java.util.List;

public class leetcode_22 {
    static void main() {
        int n = 3;
        String ans = "";
        List<String> ls = new ArrayList<>();
        printSub(n, 0, 0, ans, ls);
        System.out.println(ls);
    }

    static void printSub(int n, int openbr, int closebr, String ans, List<String> ls) {
        if (openbr == n && closebr == n) {
            System.out.println(ans);
            ls.add(ans);
            return;
        }
        if (openbr < n) {
            printSub(n, openbr + 1, closebr, ans + "(", ls);
        }
        if (closebr < openbr) {
            printSub(n, openbr, closebr + 1, ans + ")", ls);
        }
    }
}
