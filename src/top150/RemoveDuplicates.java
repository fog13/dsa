package top150;

//80. Remove Duplicates from Sorted Array II
class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }

        int idx = 0, k = 0;
        while (idx < nums.length) {
            int count = 1;
            while (idx + count < nums.length && nums[idx + count] == nums[idx + count - 1]) {
                count++;
            }
            if (idx != k) {
                for (int i = 0; i < count; i++) {
                    swap(nums, k + i, idx + i);
                }
            }


            if (count > 2) {
                k = k + 2;
            } else {
                k = k + count;
            }

            idx += count;
        }
        return k;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// 1, 2, 2, 2, 3, 4, 5, 5, 5, 6
// 1, 2, 2, 3, 2, 4