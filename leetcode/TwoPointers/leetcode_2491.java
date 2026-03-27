package leetcode.TwoPointers;

import java.util.Arrays;

public class leetcode_2491 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] skils = { 3, 2, 5, 1, 3, 4 };
		System.out.println(dividePlayers(skils));
	}

	public static long dividePlayers(int[] skill) {
		int m = skill.length;
		Arrays.sort(skill);
		int i = 0;
		int j = m - 1;
		int count = 1;
		int sum = skill[i] + skill[j];
		long chem = skill[i] * skill[j];
		i++;
		j--;

		while (i < j) {
			int currSum = skill[i] + skill[j];
			if (currSum == sum) {
				count++;
				chem += skill[i] * skill[j];
			}
			i++;
			j--;
		}
		if (count != m / 2)
			return -1;

		return chem;
	}
}
