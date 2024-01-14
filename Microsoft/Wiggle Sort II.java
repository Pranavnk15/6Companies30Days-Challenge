// 324. Wiggle Sort II

// Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

// You may assume the input array always has a valid answer.

 

// Example 1:

// Input: nums = [1,5,1,1,6,4]
// Output: [1,6,1,5,1,4]
// Explanation: [1,4,1,5,1,6] is also accepted.
// Example 2:

// Input: nums = [1,3,2,2,3,1]
// Output: [2,3,1,3,1,2]

// Approach:- In this firstly we will sort thegiven array, and the make use of the another array, 
// in which we will point the i at index 1 of the new array, and the j at the index n-1 of the original array, 
// then we will pick from the orig array, and put it in the res array, and increase the i by 2 and decrease j by 1, 
// after the end when i reaches out of index, we again set the i = 0, then fill the in between position of res array, 
// and increase array by2, at the end we will make changes from res array to the original array, 

class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] res = new int[nums.length];
        int i = 1;
        int j = n-1;
        while( i<n) {
            res[i] = nums[j];
            i += 2;
            j--;
        }
        i = 0;
        while(i < n) {
            res[i] = nums[j];
            i += 2;
            j--;
        }

        for(i = 0; i<nums.length; i++) {
            nums[i] = res[i];
        }
    }
}