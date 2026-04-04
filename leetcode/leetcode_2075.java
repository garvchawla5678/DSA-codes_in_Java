package leetcode;

import java.util.Arrays;

public class leetcode_2075 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String encodedText = "iveo    eed   l te   olc";
		System.out.println(decodeCiphertext(encodedText, 4));
	}

	public static String decodeCiphertext(String encodedText, int rows) {
		char[] wrd = encodedText.toCharArray();
		int n = wrd.length;
		int cols = n / rows;

		char[][] arr = new char[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				arr[i][j] = wrd[j + (i * cols)];
			}
		}

		for (char[] row : arr)
			System.out.println(Arrays.toString(row));
//
//		StringBuilder ans = new StringBuilder();
//
//		for (int startCol = 0; startCol < cols; startCol++) {
//			int i = 0;
//			int j = startCol;
//
//			while (i < rows && j < cols) {
//				ans.append(arr[i][j]);
//				i++;
//				j++;
//			}
//		}
//
//		while (ans.length() > 0 && ans.charAt(ans.length() - 1) == ' ') {
//			ans.deleteCharAt(ans.length() - 1);
//		}
//
//		return ans.toString();

		StringBuilder ans = new StringBuilder();
		for (int col = 0; col < cols; col++) {
			for (int skip = col; skip < n; skip += (cols + 1)) {
				ans.append(wrd[skip]);
			}
		}

		return ans.toString().stripTrailing();
	}
}
