// 354. Russian Doll Envelopes

// You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.

// One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.

// Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).

// Note: You cannot rotate an envelope.

 

// Example 1:

// Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
// Output: 3
// Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
// Example 2:

// Input: envelopes = [[1,1],[1,1],[1,1]]
// Output: 1

class Solution {
    //TC O(nlogn)

    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) {
            return 0;
        }

        //width increasing
        //height decreasing
        Arrays.sort(envelopes, (a, b) -> a[0]-b[0] == 0 ? b[1] - a[1]: a[0]-b[0]);

        int[] dp = new int[envelopes.length+1];
        int len = 0, idx = 0;
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i<envelopes.length; i++) {
            idx = Arrays.binarySearch(dp, envelopes[i][1]);
            idx = idx < 0 ? -1-idx:idx;
            dp[idx] = envelopes[i][1];
            len = Math.max(len, idx);
        }
        return len;
    }   


    // //TC O(n^2)
    // public int maxEnvelopes(int[][] envelopes) {
    //     int maxEn = 1;
    //     Arrays.sort(envelopes, (a,b) -> (a[0]-b[0]));
    //     int len = envelopes.length;
    //     int[] dp = new int[len];
    //     Arrays.fill(dp, 1);
    //     for(int i = 0; i<len; i++){
    //         for(int j = 0; j<len; j++) {
    //             if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
    //                 dp[i] = Math.max(dp[i], dp[j]+1);
    //             }
    //         }
    //         maxEn = Math.max(maxEn, dp[i]);
    //     }
    //     return maxEn;
    // }
}