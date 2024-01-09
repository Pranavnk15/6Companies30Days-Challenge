// Find Missing And Repeating
// // User function Template for Java
// Given an unsorted array Arr of size N of positive integers. One number 'A' from set {1, 2,....,N} is missing and one number 'B' occurs twice in array. Find these two numbers.

// Example 1:

// Input:
// N = 2
// Arr[] = {2, 2}
// Output: 2 1
// Explanation: Repeating number is 2 and 
// smallest positive missing number is 1.
// Example 2:

// Input:
// N = 3
// Arr[] = {1, 3, 3}
// Output: 3 2
// Explanation: Repeating number is 3 and 
// smallest positive missing number is 2.
// Your Task:
// You don't need to read input or print anything. Your task is to complete the function findTwoElement() which takes the array of integers arr and n as parameters and returns an array of integers of size 2 denoting the answer ( The first index contains B and second index contains A.)

// Expected Time Complexity: O(N)
// Expected Auxiliary Space: O(1)

class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int hash[] = new int[n+1];
        for(int i = 0; i<n; i++) {
            hash[arr[i]]++;
        }
        int mis = -1;
        int rep = -1;
        for(int i = 1; i<n+1; i++) {
            if(hash[i] == 2) {
                rep = i;
            }
            if(hash[i] == 0) {
                mis = i;
            }
            if(mis != -1 && rep != -1) {
                break;
            }
        }
        return new int[]{rep, mis};
    }
}