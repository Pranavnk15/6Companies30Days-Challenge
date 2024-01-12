// 462. Minimum Moves to Equal Array Elements II

// Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.

// In one move, you can increment or decrement an element of the array by 1.

// Test cases are designed so that the answer will fit in a 32-bit integer.

 

// Example 1:

// Input: nums = [1,2,3]
// Output: 2
// Explanation:
// Only two moves are needed (remember each move increments or decrements one element):
// [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
// Example 2:

// Input: nums = [1,10,2,9]
// Output: 16


// Approach: First Mainly identify the number to which all the other elements should be made equal to. 
// And that element should be nothing but the median of the array. As because
// it stands in the middle of array, then the left elements are lower than middle, and the right elements
// are greater than it., 
// We will first sort the array, then find the middle element, 
// then by taking the absoulte differnece betweeen the ele in array and the middle, 
// taking the sum of it will give us the required moves.


class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int middle = nums[(nums.length)/2];
        int count = 0;

        for(int el: nums) {
            count += Math.abs(el-middle);
        }
        return count;
    }
}