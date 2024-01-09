// Number following a patter

// Given a pattern containing only I's and D's. I for increasing and D for decreasing. Devise an algorithm to print the minimum number following that pattern. Digits from 1-9 and digits can't repeat.

// Example 1:

// Input:
// D
// Output:
// 21
// Explanation:
// D is meant for decreasing, so we choose the minimum number among all possible numbers like 21,31,54,87,etc.
// Example 2:

// Input:
// IIDDD
// Output:
// 126543
// Explanation:
// Above example is self- explanatory,
// 1 < 2 < 6 > 5 > 4 > 3
//   I - I - D - D - D
// Your Task:

// You don't need to read input or print anything. Your task is to complete the function printMinNumberForPattern() which takes the string S and returns a string containing the minimum number following the valid number.

// Expected Time Complexity: O(N)
// Expected Auxiliary Space: O(1)

// Approach:- 
// In this digits must be unique
// Increase such that it can compensate the decrease means, that we need to increae the value such that for further
// when we encounter decrease then it should be able to decrease the number such that
// it maintains the uniquenss i.e does not repeat and also should follow the pattern

class Solution{
    static String printMinNumberForPattern(String S){
        // code here
        int n = S.length(), current = 1, i = 0;
        StringBuilder ans = new StringBuilder();
        ans.append('1');
        while(i < n) {
            if(S.charAt(i) == 'D') {
                int j = i;
                while(j < n && S.charAt(j) == 'D') {
                    //cout no. of D's
                    j++;
                }
                int noOfD = j-i;
                current += noOfD;
                ans.setCharAt(i, (char)((int)('0') + current));
                int count = current;
                while(i != j) {
                    count--;
                    ans.append(count);
                    i++;
                }
            } else {
                current++;
                ans.append(current);
                i++;
            }
        }
        return ans.toString();
    }
}