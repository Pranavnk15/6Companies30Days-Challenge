// 187. Repeated DNA Sequences

// The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

// For example, "ACGAATTCCG" is a DNA sequence.
// When studying DNA, it is useful to identify repeated sequences within the DNA.

// Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.

 

// Example 1:

// Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
// Output: ["AAAAACCCCC","CCCCCAAAAA"]
// Example 2:

// Input: s = "AAAAAAAAAAAAA"
// Output: ["AAAAAAAAAA"]
 

// Approach 1:- In this we will break the sequence into the substrings 
// of length 10 & add it to the Map. With the key as the substring, & the value
// as the freq the no. of times the substring occues.& at the end we will return the substring whose
// freq is greater than one. 

// Approach 2:- In this we will maintain 2 sets, namely seen & repeataed. 
// In which the first time occruing substring sequnce we will stored in to the seen set, 
// and the repeated occuring substring sequnce will be store into the repeated set. 

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        for(int i = 0; i<s.length()-9; i++) {
            String subStr = s.substring(i, i+10);
            if(seen.contains(subStr)) {
                repeated.add(subStr);
            }
            seen.add(subStr);
        }

        return new ArrayList(repeated);
    }
}