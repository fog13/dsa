package top150;


import java.util.Arrays;


// 45. Jump Game II
class JumpGame2Greedy {
    public int jump(int[] nums) {
        int currEnd = 0, currFarthest = 0, jump = 0;
        for (int i = 0; i < nums.length-1; i++) {
            currFarthest = Math.max(currFarthest, i + nums[i]);
            if(currEnd == i) {
                jump++;
                currEnd = currFarthest;
                // Only needed for optimization
//                if(currEnd >=nums.length-1) {
//                    return jump;
//                }
            }
            // Only needed for optimization
//            if(currFarthest >= nums.length-1) {
//                return jump+1;
//            }
        }
        return jump;
    }
}

// 55. Jump Game 1
class JumpGame1 {
    public boolean canJump(int[] nums) {
        int curr = nums[0], i = 1;
        while (i < nums.length && curr > 0) {
            curr--;
            if (nums[i] > curr) {
                curr = nums[i];
            }
            i++;
        }
        return i == nums.length;
    }
}

class JumpGame2DP {
    public int jump(int[] nums) {
        int MAX_NUM = 1000000;
        int dp[] = new int[nums.length];
        Arrays.fill(dp, MAX_NUM);
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int j = i + 1;
            while (curr > 0 && j < nums.length) {
                dp[j] = Math.min(dp[i] + 1, dp[j]);
                j++;
                curr--;
            }
        }
        return dp[nums.length - 1];
    }
}