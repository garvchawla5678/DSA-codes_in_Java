package leetcode.Binary_Search;

public class leetcode_744 {
    static void main() {
        char[] letters = { 'c', 'f', 'j' };
        char target = 'z';
        System.out.println(nextGreatestLetter(letters, target));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        char ans = 'A';
        if (target >= letters[end]) {
            return letters[0];
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target >= letters[mid]) {
                start = mid + 1;
            } else {
                ans = letters[mid];
                end = mid - 1;
            }
        }
        return ans;

        // can also do like this:
        // int start = 0;
        // int n = letters.length;
        // int end = letters.length - 1;
        // while(start <= end){
        // int mid = start + (end - start)/2;
        // if(target >= letters[mid]){
        // start = mid + 1;
        // } else {
        // end = mid - 1;
        // }
        // }
        // return letters[start%n];
    }
}
