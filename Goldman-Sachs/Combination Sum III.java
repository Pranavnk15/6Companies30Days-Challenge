// 216. Combination Sum III

// Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

// Only numbers 1 through 9 are used.
// Each number is used at most once.
// Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

 

// Example 1:

// Input: k = 3, n = 7
// Output: [[1,2,4]]
// Explanation:
// 1 + 2 + 4 = 7
// There are no other valid combinations.
// Example 2:

// Input: k = 3, n = 9
// Output: [[1,2,6],[1,3,5],[2,3,4]]
// Explanation:
// 1 + 2 + 6 = 9
// 1 + 3 + 5 = 9
// 2 + 3 + 4 = 9
// There are no other valid combinations.
// Example 3:

// Input: k = 4, n = 1
// Output: []
// Explanation: There are no valid combinations.
// Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
 
// Approach: We will use recursion in which we will pick or not pick an element.
// In this when we pick an element we will deuct the value of element from `n` &
// reduce the value of `k` by 1.
// When we reach a condition where k & n == 0, we will reach a considerable solution, 
// as because we add up the elements choosen, we will gain the value of the n, and with the 
// nimber of k elements.
// When the value of the k or n goes negative or i > 9  we will return the function.

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(1, k, n, new ArrayList<>(), ans);
        return ans;        
    }

    public static void helper(int i, int k, int n, List<Integer> curr, List<List<Integer>> ans) {
        if(n == 0 && k == 0) {
            ans.add(curr);
            return;
        }
        if(i > 9) {
            return;
        }
        if(n<0 || k <0) {
            return;
        }
        List<Integer> temp = new ArrayList<>(curr);
        temp.add(i);
        helper(i+1, k-1, n-i, temp, ans); // pick
        
        helper(i+1, k, n, curr, ans); //not pick
    }
}