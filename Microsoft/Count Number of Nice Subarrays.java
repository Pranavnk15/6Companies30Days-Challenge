// 1248. Count Number of Nice Subarrays

// Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

// Return the number of nice sub-arrays.

 

// Example 1:

// Input: nums = [1,1,2,1,1], k = 3
// Output: 2
// Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
// Example 2:

// Input: nums = [2,4,6], k = 1
// Output: 0
// Explanation: There is no odd numbers in the array.
// Example 3:

// Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
// Output: 16

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atmost(nums, k) - atmost(nums, k-1);        
    }

    private int atmost(int[] nums, int k) {
        int count = 0;
        int ans = 0;
        int start = 0;
        for(int end = 0; end<nums.length; end++) {
            if(nums[end] % 2 != 0) {
                count++;
            }
            while(start <= end && count > k) {
                if(nums[start++] % 2 != 0) {
                    count--;
                }
            }
            ans += (end-start+1);
        }
        return ans;
    }
}