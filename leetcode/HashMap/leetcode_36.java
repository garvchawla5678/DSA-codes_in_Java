package leetcode.HashMap;

public class leetcode_36 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		leetcode_36 cl = new leetcode_36();
		System.out.println(cl.isValidSudoku(board));
	}

	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					if (isItSafe(board, i, j, board[i][j]) == false)
						return false;
				}
			}
		}
		return true;
	}

	boolean isItSafe(char[][] grid, int cr, int cc, char val) {
		for (int j = 0; j < 9; j++) {
			if (j != cc && grid[cr][j] == val)
				return false;
		}
		for (int i = 0; i < 9; i++) {
			if (i != cr && grid[i][cc] == val)
				return false;
		}
		int r = cr / 3 * 3;
		int c = cc / 3 * 3;
		for (int i = r; i < r + 3; i++) {
			for (int j = c; j < c + 3; j++) {
				if (i != cr || j != cc) {
					if (grid[i][j] == val)
						return false;
				}
			}
		}
		return true;
	}
}
