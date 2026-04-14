package leetcode.SquareRootDecomposition;

public class leetcode_307 {

	class NumArray {
		int[] nums;
		int[] blocks;
		int n;
		int blockSize;

		public NumArray(int[] nums) {
			this.nums = nums;
			this.n = nums.length;

			this.blockSize = (int) Math.ceil(Math.sqrt(this.n));
			this.blocks = new int[this.blockSize];

			for (int i = 0; i < this.n; i++) {
				int blockIdx = i / this.blockSize;
				this.blocks[blockIdx] += nums[i];
			}
		}

		public void update(int index, int val) {
			int blockIdx = index / this.blockSize;
			this.blocks[blockIdx] -= nums[index];
			this.blocks[blockIdx] += val;
			nums[index] = val;
		}

		public int sumRange(int left, int right) {
			int startBlock = left / this.blockSize;
			int endBlock = right / this.blockSize;

			int sum = 0;
			// case - 1
			if (startBlock == endBlock) {
				for (int i = left; i <= right; i++) {
					sum += nums[i];
				}

				return sum;
			}

			// case - 2
			int endOfStartBloack = ((startBlock + 1) * this.blockSize) - 1;
			int startOfEndBlock = endBlock * this.blockSize;

			for (int i = left; i <= endOfStartBloack; i++) {
				sum += nums[i];
			}

			for (int i = startBlock + 1; i <= endBlock - 1; i++) {
				sum += blocks[i];
			}

			for (int i = startOfEndBlock; i <= right; i++) {
				sum += nums[i];
			}

			return sum;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 9, 1, 3, 4, 6, 7, 10, 78, -1 };
		leetcode_307 cl = new leetcode_307();
		NumArray cl1 = cl.new NumArray(arr);
		System.out.println(cl1.sumRange(2, 7));
	}

}
