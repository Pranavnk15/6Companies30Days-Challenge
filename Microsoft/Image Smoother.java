// 661. Image Smoother

// An image smoother is a filter of the size 3 x 3 that can be applied to each cell of an image by rounding down the average of the cell and the eight surrounding cells (i.e., the average of the nine cells in the blue smoother). If one or more of the surrounding cells of a cell is not present, we do not consider it in the average (i.e., the average of the four cells in the red smoother).


// Given an m x n integer matrix img representing the grayscale of an image, return the image after applying the smoother on each cell of it.

 

// Example 1:


// Input: img = [[1,1,1],[1,0,1],[1,1,1]]
// Output: [[0,0,0],[0,0,0],[0,0,0]]
// Explanation:
// For the points (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
// For the points (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
// For the point (1,1): floor(8/9) = floor(0.88888889) = 0
// Example 2:


// Input: img = [[100,200,100],[200,50,200],[100,200,100]]
// Output: [[137,141,137],[141,138,141],[137,141,137]]
// Explanation:
// For the points (0,0), (0,2), (2,0), (2,2): floor((100+200+200+50)/4) = floor(137.5) = 137
// For the points (0,1), (1,0), (1,2), (2,1): floor((200+200+50+200+100+100)/6) = floor(141.666667) = 141
// For the point (1,1): floor((50+200+200+200+200+100+100+100+100)/9) = floor(138.888889) = 138

// Step by step algorithm
// Step 1: Initialization
// # Get the dimensions of the input image matrix
// rows, cols = len(img), len(img[0])
// In this step, the dimensions of the input image matrix are obtained, with rows representing the number of rows and cols representing the number of columns.

// Step 2: Average Calculation Function
// def average_value(r, c):
//     # Define the boundaries for the neighboring pixels
//     top = max(0, r - 1)
//     bottom = min(rows, r + 2)
//     left = max(0, c - 1)
//     right = min(cols, c + 2)

//     total, count = 0, 0
// This step defines a helper function average_value(r, c) that calculates the average value for a pixel at position (r, c) based on its neighboring pixels. The boundaries for neighboring pixels are determined to ensure we don't go beyond the image edges.

// Step 3: Neighboring Pixel Boundaries
// top = max(0, r - 1)
// bottom = min(rows, r + 2)
// left = max(0, c - 1)
// right = min(cols, c + 2)
// Here, the boundaries for neighboring pixels are defined. These boundaries ensure that we don't go beyond the edges of the image matrix.

// Step 4: Iterate Over Neighboring Pixels
// for row in range(top, bottom):
//     for col in range(left, right):
//         total += img[row][col]
//         count += 1
// In this step, nested loops iterate over the neighboring pixels within the determined boundaries. The pixel values are accumulated in total, and the count of pixels considered is incremented.

// Step 5: Calculate Average Value
// return total // count
// The average value for the pixel is calculated by dividing the total sum of neighboring pixel values by the count of pixels considered.

// Step 6: Apply Average Function to Each Pixel
// result = [[average_value(r, c) for c in range(cols)] for r in range(rows)]
// Using a nested list comprehension, the average_value function is applied to each pixel in the image matrix. The outer loop iterates over each row (r), and the inner loop iterates over each column (c).

// Step 7: Return the Result
// return result
// The resulting smoothed image matrix is returned.

class Solution {
    public int[][] imageSmoother(int[][] img) {
        int rows = img.length;
        int cols = img[0].length;

        //aply the average function to each pixel in the image matrix
        int[][] result = new int[rows][cols];
        for(int r = 0; r<rows; r++) {
            for(int c = 0; c<cols; c++) {
                result[r][c] = calculateAvg(img, r, c, rows, cols);
            }
        }
        return result;
    }

    private int calculateAvg(int[][] img, int r, int c, int rows, int cols) {
        int total = 0;
        int count = 0;

        //define the boundaries for the neighbouring pixels
        int top = Math.max(0, r-1);
        int bottom = Math.min(rows, r+2);
        int left = Math.max(0, c-1);
        int right = Math.min(cols, c+2);


        // Iterate over the neighboring pixels and calculate the sum and count
        for(int row = top; row<bottom; row++) {
            for(int col = left; col<right; col++) {
                total += img[row][col];
                count +=1;
            }
        }

        //calculate and return the avg valur for the pixel
        return total/count;
    }
}