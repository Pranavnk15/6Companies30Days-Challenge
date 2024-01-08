// 17. Letter Combinations of a Phone Number

// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

// Example 1:

// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// Example 2:

// Input: digits = ""
// Output: []
// Example 3:

// Input: digits = "2"
// Output: ["a","b","c"]

// Approach: Intuition
// Given a string containing digits from 2-9 inclusive, we need to return all possible letter combinations that the number could represent, just like on a telephone's buttons. To accomplish this, we present two different approaches:

// Backtracking Approach: This approach leverages recursion to explore all possible combinations. We create a recursive function that takes the current combination and the next digits to explore. For each digit, we iterate through its corresponding letters and recursively explore the remaining digits. We append the combination when no more digits are left to explore.

// Iterative Approach: This approach builds the combinations iteratively without using recursion. We start with an empty combination and iteratively add letters for each digit in the input string. For each existing combination, we append each corresponding letter for the current digit, building new combinations.

// Differences:

// The backtracking approach relies on recursion to explore all possible combinations, whereas the iterative approach builds combinations step by step using loops.
// Both approaches have similar time complexity, but the iterative approach might save some function call overhead, leading to more efficient execution in some cases.

// Approach - Backtracking
// Initialize a Mapping: Create a dictionary that maps each digit from 2 to 9 to their corresponding letters on a telephone's buttons. For example, the digit '2' maps to "abc," '3' maps to "def," and so on.

// Base Case: Check if the input string digits is empty. If it is, return an empty list, as there are no combinations to generate.

// Recursive Backtracking:

// Define Recursive Function: Create a recursive function, backtrack, that will be used to explore all possible combinations. It takes two parameters: combination, which holds the current combination of letters, and next_digits, which holds the remaining digits to be explored.
// Termination Condition: If next_digits is empty, it means that all digits have been processed, so append the current combination to the result.
// Exploration: If there are more digits to explore, take the first digit from next_digits and iterate over its corresponding letters in the mapping. For each letter, concatenate it to the current combination and recursively call the backtrack function with the new combination and the remaining digits.
// Example: If the input is "23", the first recursive call explores all combinations starting with 'a', 'b', and 'c' (from '2'), and the next level of recursive calls explores combinations starting with 'd', 'e', 'f' (from '3'), building combinations like "ad," "ae," "af," "bd," "be," etc.
// Result: Once the recursive exploration is complete, return the collected combinations as the final result. By using recursion, we ensure that all possible combinations are explored, and the result includes all valid letter combinations that the input digits can represent.

// Complexity
// Time complexity: ( O(4^n) ), where ( n ) is the length of the input string. In the worst case, each digit can represent 4 letters, so there will be 4 recursive calls for each digit.
// Space complexity: ( O(n) ), where ( n ) is the length of the input string. This accounts for the recursion stack space.

class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) {
            return Collections.emptyList();
        }

        String[] phone_map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> output = new ArrayList<>();
        backtrack("", digits, phone_map, output);
        return output;
    }

    private void backtrack(String combination, String next_digits, String[] phone_map, List<String> output) {
        if(next_digits.isEmpty()) {
            output.add(combination);
        } else {
            String letters = phone_map[next_digits.charAt(0) - '2'];
            for(char letter: letters.toCharArray()) {
                backtrack(combination + letter, next_digits.substring(1), phone_map, output);
            }
        }
    }
}