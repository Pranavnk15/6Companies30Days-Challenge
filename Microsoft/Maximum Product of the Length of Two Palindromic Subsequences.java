// 2002. Maximum Product of the Length of Two Palindromic Subsequences

// Given a string s, find two disjoint palindromic subsequences of s such that the product of their lengths is maximized. The two subsequences are disjoint if they do not both pick a character at the same index.

// Return the maximum possible product of the lengths of the two palindromic subsequences.

// A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters. A string is palindromic if it reads the same forward and backward.

 

// Example 1:

// example-1
// Input: s = "leetcodecom"
// Output: 9
// Explanation: An optimal solution is to choose "ete" for the 1st subsequence and "cdc" for the 2nd subsequence.
// The product of their lengths is: 3 * 3 = 9.
// Example 2:

// Input: s = "bb"
// Output: 1
// Explanation: An optimal solution is to choose "b" (the first character) for the 1st subsequence and "b" (the second character) for the 2nd subsequence.
// The product of their lengths is: 1 * 1 = 1.
// Example 3:

// Input: s = "accbcaxxcxx"
// Output: 25
// Explanation: An optimal solution is to choose "accca" for the 1st subsequence and "xxcxx" for the 2nd subsequence.
// The product of their lengths is: 5 * 5 = 25.
 

class Solution {
    public int maxProduct(String s) {
        int[] dp = new int[4096];
        int res = 0, mask = (1 << s.length())-1;
        for(int m = 1; m<=mask; m++) {
            dp[m] = palSize(s, m);
        }
        for(int m1 = mask; m1 > 0; m1--) {
            if(dp[m1]*(s.length()-dp[m1]) > res) {
                for(int m2 = mask ^ m1; m2 > 0; m2 = (m2-1) & (mask ^ m1)){
                    res = Math.max(res, dp[m1]*dp[m2]);
                }
            }
        }
        return res;
    }

    private int palSize(String s, int mask) {
        int p1 = 0, p2 = s.length(), res = 0;
        while(p1 <= p2) {
            if((mask & (1 << p1)) == 0) {
                ++p1;
            } else if((mask & ( 1 << p2)) == 0) {
                --p2;
            } else if(s.charAt(p1) != s.charAt(p2)) {
                return 0;
            } else {
                res += 1 + (p1++ != p2-- ? 1:0);
            }
        }
        return res;
    }
}