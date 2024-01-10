// Run Length Encoding

// Given a string, Your task is to  complete the function encode that returns the run length encoded string for the given string.
// eg if the input string is “wwwwaaadexxxxxx”, then the function should return “w4a3d1e1x6″.
// You are required to complete the function encode that takes only one argument the string which is to be encoded and returns the encoded string.

// Example 1:

// Input:
// str = aaaabbbccc
// Output: a4b3c3
// Explanation: a repeated 4 times
// consecutively b 3 times, c also 3
// times.
// Example 2:

// Input:
// str = abbbcdddd
// Output: a1b3c1d4
// Your Task:
// Complete the function encode() which takes a character array as a input parameter and returns the encoded string.

// Expected Time Complexity: O(N), N = length of given string.
// Expected Auxiliary Space: O(1)


class GfG
 {
	String encode(String str)
	{
          //Your code here
          String encode = "";
          int  n = str.length();
          for(int i = 0; i<n ; i++) {
              int count = 1;
              while(i < n-1 && str.charAt(i) == str.charAt(i+1)) {
                  count++;
                  i++;
              }
              encode += str.charAt(i);
              encode += count;
          }
          return encode;
	}
	
 }