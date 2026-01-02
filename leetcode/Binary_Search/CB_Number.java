package leetcode.Binary_Search;

public class CB_Number {
    static void main() {
        String number = "4991";
        Integer[] arr = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };
        System.out.println(ans(number, arr));
    }

    public static int ans(String num, Integer[] arr) {
        int count = 0;
        boolean[] visited = new boolean[num.length()];
        for (int len = 1; len <= num.length(); len++) {
            for (int j = len; j <= num.length(); j++) {
                int i = j - len;
                String s1 = num.substring(i, j);
                if (is_CB(Long.parseLong(s1), arr) && IsValid(visited, i, j)) {
                    count++;
                    for (int k = i; k < j; k++) {
                        visited[k] = true;
                    }
                }
            }
        }
        return count;
    }

    public static boolean IsValid(boolean[] visited, int i, int j) {
        for (; i < j; i++) {
            if (visited[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean is_CB(long num, Integer[] arr) {
        if (num == 0 || num == 1) {
            return false;
        }
        for (Integer i : arr) {
            if (num == i) {
                return true;
            }
        }
        for (Integer i : arr) {
            if ((num) % i == 0) {
                return false;
            }
        }
        return true;
    }
}
