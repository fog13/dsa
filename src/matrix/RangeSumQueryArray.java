package matrix;

class NumArray {
    int []sums;
    public NumArray(int[] nums) {
        fillSum(nums);

    }

    public int sumRange(int left, int right) {
        return sums[right+1] -sums[left];
    }

    private void fillSum(int[] nums) {
        int len = nums.length + 1;
        sums = new int[len];

        for(int i = 1; i < len; i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }
    }
}
