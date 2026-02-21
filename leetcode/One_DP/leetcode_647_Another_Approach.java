package leetcode.One_DP;

public class leetcode_647_Another_Approach {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc";
		System.out.println(countSubstrings(s));
	}

	public static int countSubstrings(String s) {
		int count = 0;
		// odd substrings check whether they are palindrome or not
		for (int axis = 0; axis < s.length(); axis++) {
			for (int orbit = 0; axis - orbit >= 0 && axis + orbit < s.length(); orbit++) {
				if (s.charAt(axis - orbit) != s.charAt(axis + orbit)) {
					break;
				}
				count++;
			}
		}
		// even substrings check whether they are palindrome or not
		for (double axis = 0.5; axis < s.length(); axis++) {
			for (double orbit = 0.5; axis - orbit >= 0 && axis + orbit < s.length(); orbit++) {
				if (s.charAt((int) (axis - orbit)) != s.charAt((int) (axis + orbit))) {
					break;
				}
				count++;
			}
		}
		return count;

//		public int countSubstrings(String s) {
//	        int count = 0;
//
//	        for (int i = 0; i < s.length(); i++) {
//	            // Case 1: Odd length palindromes (center is at a character)
//	            count += expand(s, i, i);
//	            // Case 2: Even length palindromes (center is between two characters)
//	            count += expand(s, i, i + 1);
//	        }
//	        return count;
//	    }
//
//	    private int expand(String s, int left, int right) {
//	        int count = 0;
//	        // Expand outwards as long as characters match and pointers are in bounds
//	        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//	            count++;
//	            left--;
//	            right++;
//	        }
//	        return count;
//	    }
	}
}
