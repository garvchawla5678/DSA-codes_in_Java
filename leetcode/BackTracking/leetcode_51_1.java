package leetcode.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_51_1 {
    static void main() {
        int n = 10;
        List<List<String>> ans = solveNQueens(n);
        for(List<String> list : ans){
            System.out.println(list);
        }
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(board[i],'.');
        }
        boolean[] cols = new boolean[n];
        boolean[] diag = new boolean[2 * n];
        boolean[] antiDiag = new boolean[2 * n];
        solve(n, board, 0, ans, cols, diag, antiDiag);
        return ans;
    }
    static void solve(int n, char[][] board, int row, List<List<String>> ans, boolean[] cols, boolean[] diag, boolean[] antiDiag) {
        if (row == n) {
            ArrayList<String> ans1 = new ArrayList<>();
            for(int i = 0; i < board.length; i++) {
                String ll = new String(board[i]);
                ans1.add(ll);
            }
            ans.add(ans1);
            return;
        }
        for(int i = 0; i < n; i++) {
            int diagonal = row + i;
            int anti = row - i + n;
            if(cols[i] || diag[diagonal] || antiDiag[anti]) continue;

            cols[i] = diag[diagonal] = antiDiag[anti] = true;
            board[row][i] = 'Q';

            solve(n, board, row + 1, ans, cols, diag, antiDiag);

            cols[i] = diag[diagonal] = antiDiag[anti] = false;
            board[row][i] = '.';
        }
    }
}
