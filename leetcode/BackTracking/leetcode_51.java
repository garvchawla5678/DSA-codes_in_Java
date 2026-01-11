package leetcode.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_51 {
    static void main() {
        int n = 4;
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
        solve(n, board, 0, ans);
        return ans;
    }
    static void solve(int n, char[][] board, int row, List<List<String>> ans) {
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
            if(isItPossible(board, row, i)) {
                board[row][i] = 'Q';
                solve(n, board, row + 1, ans);
                board[row][i] = '.';
            }
        }
    }
     static boolean isItPossible(char[][] board, int row, int col) {
        for(int i = row - 1; i >= 0; i--) {
            if(board[i][col] == 'Q') return false;
        }
        int i = row - 1;
        int j = col - 1;
        while(i >= 0 && j >= 0) {
            if(board[i][j] == 'Q') return false;
            i--;
            j--;
        }
        i = row - 1;
        j = col + 1;
        while(i >= 0 && j < board.length) {
            if(board[i][j] == 'Q') return false;
            i--;
            j++;
        }
        return true;
    }
}
