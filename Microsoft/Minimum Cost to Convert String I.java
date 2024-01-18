/*2976. Minimum Cost to Convert String I

You are given two 0-indexed strings source and target, both of length n and consisting of lowercase English letters. You are also given two 0-indexed character arrays original and changed, and an integer array cost, where cost[i] represents the cost of changing the character original[i] to the character changed[i].

You start with the string source. In one operation, you can pick a character x from the string and change it to the character y at a cost of z if there exists any index j such that cost[j] == z, original[j] == x, and changed[j] == y.

Return the minimum cost to convert the string source to the string target using any number of operations. If it is impossible to convert source to target, return -1.

Note that there may exist indices i, j such that original[j] == original[i] and changed[j] == changed[i].

 

Example 1:

Input: source = "abcd", target = "acbe", original = ["a","b","c","c","e","d"], changed = ["b","c","b","e","b","e"], cost = [2,5,5,1,2,20]
Output: 28
Explanation: To convert the string "abcd" to string "acbe":
- Change value at index 1 from 'b' to 'c' at a cost of 5.
- Change value at index 2 from 'c' to 'e' at a cost of 1.
- Change value at index 2 from 'e' to 'b' at a cost of 2.
- Change value at index 3 from 'd' to 'e' at a cost of 20.
The total cost incurred is 5 + 1 + 2 + 20 = 28.
It can be shown that this is the minimum possible cost.
Example 2:

Input: source = "aaaa", target = "bbbb", original = ["a","c"], changed = ["c","b"], cost = [1,2]
Output: 12
Explanation: To change the character 'a' to 'b' change the character 'a' to 'c' at a cost of 1, followed by changing the character 'c' to 'b' at a cost of 2, for a total cost of 1 + 2 = 3. To change all occurrences of 'a' to 'b', a total cost of 3 * 4 = 12 is incurred.
Example 3:

Input: source = "abcd", target = "abce", original = ["a"], changed = ["e"], cost = [10000]
Output: -1
Explanation: It is impossible to convert source to target because the value at index 3 cannot be changed from 'd' to 'e'.
 

Constraints:

1 <= source.length == target.length <= 105
source, target consist of lowercase English letters.
1 <= cost.length == original.length == changed.length <= 2000
original[i], changed[i] are lowercase English letters.
1 <= cost[i] <= 106
original[i] != changed[i]

Intuition:
To find the minimum cost to convert the string source to the string target, we need to find the optimal sequence of operations that minimizes the cost. We are allowed to change characters in the source string based on the given costs associated with changing each character from original to changed.

Approach:
First, create a mapping of characters from original to changed along with their corresponding costs.
Initialize a 2D array dp where dp[i][j] represents the minimum cost to convert the prefix of length i of the source string to the prefix of length j of the target string.
Iterate through the characters of source and target and update the dp array based on the possible operations and their costs.
Finally, the value at dp[n][n] will represent the minimum cost to convert the entire source string to the entire target string. If it is not possible, return -1.
Detailed Steps:
Initialize a mapping charMap to store the mapping of characters from original to changed along with their corresponding costs.
Iterate through the original, changed, and cost arrays and populate the charMap.
Initialize a 2D array dp of size (n+1) x (n+1) where n is the length of the strings.
Initialize the base case: dp[0][0] = 0 since no cost is required to convert an empty string to an empty string.
Iterate through the characters of source and target using two nested loops:
For each pair of characters (source[i-1], target[j-1]), check if the characters are the same. If they are the same, no operation is needed, and the cost remains the same (dp[i][j] = dp[i-1][j-1]).
If the characters are different, consider all possible operations (changing the character at position i-1 in source):
For each operation, update the dp[i][j] based on the minimum cost of the previous state and the cost of the current operation.
The final answer is stored in dp[n][n], representing the minimum cost to convert the entire source string to the entire target string. If it is not possible, return -1.
Complexity
Let n be the length of the strings.
Building the charMap takes O(len(original)) time.
Constructing the dp array requires two nested loops, each running for n iterations, resulting in O(n^2) time complexity.
Thus, the overall time complexity is O(len(original) + n^2).
The space complexity is O(n^2) for the dp array and O(len(original)) for the charMap.

*/

class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] dis = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
            dis[i][i] = 0;
        }
        for (int i = 0; i < cost.length; i++) {
            dis[original[i] - 'a'][changed[i] - 'a'] = Math.min(dis[original[i] - 'a'][changed[i] - 'a'], cost[i]);
        }
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++)
                if (dis[i][k] < Integer.MAX_VALUE) {
                    for (int j = 0; j < 26; j++) {
                        if (dis[k][j] < Integer.MAX_VALUE) {
                            dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                        }
                    }
                }
        }
        long ans = 0L;
        for (int i = 0; i < source.length(); i++) {
            int c1 = source.charAt(i) - 'a';
            int c2 = target.charAt(i) - 'a';
            if (dis[c1][c2] == Integer.MAX_VALUE) {
                return -1L;
            } else {
                ans += (long)dis[c1][c2];
            }
        }
        return ans;
    }
}