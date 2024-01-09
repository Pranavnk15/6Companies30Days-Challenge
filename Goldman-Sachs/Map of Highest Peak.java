// Map of Highest Peak

// You are given an integer matrix isWater of size m x n that represents a map of land and water cells.

// If isWater[i][j] == 0, cell (i, j) is a land cell.
// If isWater[i][j] == 1, cell (i, j) is a water cell.
// You must assign each cell a height in a way that follows these rules:

// The height of each cell must be non-negative.
// If the cell is a water cell, its height must be 0.
// Any two adjacent cells must have an absolute height difference of at most 1. A cell is adjacent to another cell if the former is directly north, east, south, or west of the latter (i.e., their sides are touching).
// Find an assignment of heights such that the maximum height in the matrix is maximized.

// Return an integer matrix height of size m x n where height[i][j] is cell (i, j)'s height. If there are multiple solutions, return any of them.

 

// Example 1:



// Input: isWater = [[0,1],[0,0]]
// Output: [[1,0],[2,1]]
// Explanation: The image shows the assigned heights of each cell.
// The blue cell is the water cell, and the green cells are the land cells.
// Example 2:



// Input: isWater = [[0,0,1],[1,0,0],[0,0,0]]
// Output: [[1,1,0],[0,1,1],[1,2,2]]
// Explanation: A height of 2 is the maximum possible height of any assignment.
// Any height assignment that has a maximum height of 2 while still meeting the rules will also be accepted.
 
// Intuition
// The code aims to find the highest peak values for cells in a grid where some cells are marked as water (with a value of 1), and others need to be assigned a height value based on their distance from the water cells. It uses a breadth-first search (BFS) approach to propagate height values from water cells to land cells.

// Approach
// Initialize a matrix to store height values, initially filled with Integer.MAX_VALUE.
// Enqueue all water cells with a height of 0 and store them in a queue.
// Perform a BFS traversal starting from water cells to assign heights to land cells.
// For each cell in the queue, calculate the height of its neighboring cells (up, down, left, and right).
// If the height can be improved (i.e., the new height is smaller), update the height of the neighboring cell and enqueue it.
// Continue this process until the queue is empty, at which point all cells will have their heights assigned.
// Return the resulting matrix.
// Complexity
// Time complexity: O(n * m)
// Space complexity: O(n * m)

class Solution {
    public int[][] highestPeak(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] ans = new int[n][m];
        for(int[] row: ans) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Queue<Pair> qu = new LinkedList<>();
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(matrix[i][j] == 1) {
                    ans[i][j] = 0;
                    qu.add(new Pair(i, j));
                }
            }
        }

        while(!qu.isEmpty()) {
            Pair curr = qu.poll();
            int r = curr.first;
            int c = curr.second;

            int[] dr = {1, 0, -1, 0};
            int[] dc = {0, 1, 0, -1};

            for(int i = 0; i<4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr >=0 && nc >=0 && nr<n && nc<m && ans[nr][nc] > 1+ans[r][c]) {
                    ans[nr][nc] = 1+ans[r][c];
                    qu.add(new Pair(nr, nc));
                }
            }
        }
        return ans;
    }
}

class Pair {
    int first;
    int second;
    
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}