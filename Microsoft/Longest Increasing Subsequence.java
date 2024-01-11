// 300. Longest Increasing Subsequence

// Given an integer array nums, return the length of the longest strictly increasing 
// subsequence

// Example 1:

// Input: nums = [10,9,2,5,3,7,101,18]
// Output: 4
// Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
// Example 2:

// Input: nums = [0,1,0,3,2,3]
// Output: 4
// Example 3:

// Input: nums = [7,7,7,7,7,7,7]
// Output: 1

// Approach:- Function f: This function recursively explores all possibilities to find the longest increasing subsequence starting from each index index in the input array nums. It maintains the length of the current subsequence, considering two cases:

// Continuation of the current subsequence from the next index (f(index+1, prev_ind, nums, n, dp))
// Starting a new subsequence at the current index (f(index+1, index, nums, n, dp))
// Memoization using DP Array (dp): To optimize the recursive calls and avoid redundant computations, a 2D dp array is used to store the lengths of subsequences calculated for each index (index) and the previous index in the subsequence (prev_ind). The dp array helps store and retrieve already computed values without recalculating them.

// Base Case and Initialization: The base case is when the index reaches the end of the array (index == n). The function returns 0 in this case. The -1 initialization in the DP array (dp) is used to indicate that a particular subproblem has not been solved yet.

// Return Result: The lengthOfLIS function initiates the calculation by calling the f function from the starting index -1 (indicating no previous index) and returns the length of the longest increasing subsequence found.

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n+1];
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n+1; j++) {
                dp[i][j] = -1;
            }
        }
        return solveMem(n , nums, 0, -1, dp);
    }

    public static int solveMem(int n, int[] a, int curr, int prev, int[][] dp) {
        //base case
        if(curr == n) {
            return 0;
        }

        if(dp[curr][prev+1] != -1) {
            return dp[curr][prev+1];
        }

        int take = 0;
        if(prev == -1 || a[curr] > a[prev]) {
            take = 1+solveMem(n, a, curr+1, curr, dp);
        }
        int notTake = 0 + solveMem(n, a, curr+1, prev, dp);
        return dp[curr][prev+1] = Math.max(take, notTake);
    }
}