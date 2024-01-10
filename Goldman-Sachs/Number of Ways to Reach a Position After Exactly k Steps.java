Number of Ways to Reach a Position After Exactly k Steps

You are given two positive integers startPos and endPos. Initially, you are standing at position startPos on an infinite number line. With one step, you can move either one position to the left, or one position to the right.

Given a positive integer k, return the number of different ways to reach the position endPos starting from startPos, such that you perform exactly k steps. Since the answer may be very large, return it modulo 109 + 7.

Two ways are considered different if the order of the steps made is not exactly the same.

Note that the number line includes negative integers.

 

Example 1:

Input: startPos = 1, endPos = 2, k = 3
Output: 3
Explanation: We can reach position 2 from 1 in exactly 3 steps in three ways:
- 1 -> 2 -> 3 -> 2.
- 1 -> 2 -> 1 -> 2.
- 1 -> 0 -> 1 -> 2.
It can be proven that no other way is possible, so we return 3.
Example 2:

Input: startPos = 2, endPos = 5, k = 10
Output: 0
Explanation: It is impossible to reach position 5 from position 2 in exactly 10 steps.

Approach DP + memoization

class Solution {
    public int numberOfWays(int startPos, int endPos, int k) {
            // for any index within range[start, end], it can be reached from index-1 || index + 1
    // -> 2D dp problem, TC = O(3000k) = O(k), SC = O(3000k) = O(k)
        int mod = 1000000007;
        // dp[idx][k] represents the number of different ways to reach (idx - 1000) with k steps left
        int[][] dp = new int[3002][k + 1];
        // initialization
        dp[startPos+1000][k] = 1;
        // dp for different remaining steps
        for(int j = k - 1; j >= 0; j--){
            // iterate different idx
            for(int idx = 1; idx <= 3000; idx++){
                // reach from previous idx or next idx
                dp[idx][j] = ((dp[idx][j] + dp[idx - 1][j + 1]) % mod + dp[idx + 1][j + 1]) % mod;
            }
        }
        return dp[endPos + 1000][0];
    }
}