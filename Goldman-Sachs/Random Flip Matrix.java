
// 519 Random Flip Matrix

// There is an m x n binary grid matrix with all the values set 0 initially. Design an algorithm to randomly pick an index (i, j) where matrix[i][j] == 0 and flips it to 1. All the indices (i, j) where matrix[i][j] == 0 should be equally likely to be returned.

// Optimize your algorithm to minimize the number of calls made to the built-in random function of your language and optimize the time and space complexity.

// Implement the Solution class:

// Solution(int m, int n) Initializes the object with the size of the binary matrix m and n.
// int[] flip() Returns a random index [i, j] of the matrix where matrix[i][j] == 0 and flips it to 1.
// void reset() Resets all the values of the matrix to be 0.
 

// Example 1:

// Input
// ["Solution", "flip", "flip", "flip", "reset", "flip"]
// [[3, 1], [], [], [], [], []]
// Output
// [null, [1, 0], [2, 0], [0, 0], null, [2, 0]]

// Explanation
// Solution solution = new Solution(3, 1);
// solution.flip();  // return [1, 0], [0,0], [1,0], and [2,0] should be equally likely to be returned.
// solution.flip();  // return [2, 0], Since [1,0] was returned, [2,0] and [0,0]
// solution.flip();  // return [0, 0], Based on the previously returned indices, only [0,0] can be returned.
// solution.reset(); // All the values are reset to 0 and can be returned.
// solution.flip();  // return [2, 0], [0,0], [1,0], and [2,0] should be equally likely to be returned.

// Approach: int r = rand.nextInt(total); Generate a random index r within the range [0, total)
// int x = map.getOrDefault(r, r); Get the original index associated with r from the map. If r is not in the map, it returns r as the default value. This means that if r has not been flipped before, x will be the same as r
// map.put(r, map.getOrDefault(total, total)); Update the mapping in the map by swapping the values for indices r and total. This is done to ensure that each cell has an equal probability of being selected during the flipping operation
// why x/col and x%col => x/col give row , x%col give col number of that element

class Solution {
    HashMap<Integer, Integer> map;
    int row;
    int col;
    Random ran;
    int total;

    public Solution(int m, int n) {
        map = new HashMap<>();
        ran = new Random();
        row = m;
        col = n;
        total = row * col;
    }

    public int[] flip() {
        int r = ran.nextInt(total);
        int x = map.getOrDefault(r, r);
        total--;
        map.put(r, map.getOrDefault(total, total));
        
        return new int[] { x / col, x % col };
    }

    public void reset() {
        map.clear();
        total = row * col;
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */