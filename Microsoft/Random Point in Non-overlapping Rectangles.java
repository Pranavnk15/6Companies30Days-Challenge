// 497. Random Point in Non-overlapping Rectangles

// You are given an array of non-overlapping axis-aligned rectangles rects where rects[i] = [ai, bi, xi, yi] indicates that (ai, bi) is the bottom-left corner point of the ith rectangle and (xi, yi) is the top-right corner point of the ith rectangle. Design an algorithm to pick a random integer point inside the space covered by one of the given rectangles. A point on the perimeter of a rectangle is included in the space covered by the rectangle.

// Any integer point inside the space covered by one of the given rectangles should be equally likely to be returned.

// Note that an integer point is a point that has integer coordinates.

// Implement the Solution class:

// Solution(int[][] rects) Initializes the object with the given rectangles rects.
// int[] pick() Returns a random integer point [u, v] inside the space covered by one of the given rectangles.
 

// Example 1:


// Input
// ["Solution", "pick", "pick", "pick", "pick", "pick"]
// [[[[-2, -2, 1, 1], [2, 2, 4, 6]]], [], [], [], [], []]
// Output
// [null, [1, -2], [1, -1], [-1, -2], [-2, -2], [0, 0]]

// Explanation
// Solution solution = new Solution([[-2, -2, 1, 1], [2, 2, 4, 6]]);
// solution.pick(); // return [1, -2]
// solution.pick(); // return [1, -1]
// solution.pick(); // return [-1, -2]
// solution.pick(); // return [-2, -2]
// solution.pick(); // return [0, 0]
 

// Constraints:

// 1 <= rects.length <= 100
// rects[i].length == 4
// -109 <= ai < xi <= 109
// -109 <= bi < yi <= 109
// xi - ai <= 2000
// yi - bi <= 2000
// All the rectangles do not overlap.
// At most 104 calls will be made to pick.

// Approach:- 
// Case I:- Consider 2 rectangles of same area. Choose any 
// rectangle A or B, Choose any point in selected rectangle 
// & retun it.

// Case II: Consider two rectangles having 30 & 70 areas, 
// choosing a rectangle should be directly proportional to its area. 
// That means 30% probabilty chances of choosing 1st rectangle, and 70% chances of 2nd
// rectangle choosen.

class Solution {

    Random rand;
    TreeMap<Integer, Integer> map;
    int[][] rects;
    int area;

    public Solution(int[][] rects) {
        rand = new Random();
        map = new TreeMap<>();
        this.rects = rects;
        for(int i = 0; i<rects.length; i++) {
            int currArea = (rects[i][2] - rects[i][0]+1)* (rects[i][3] - rects[i][1]+1);
            area += currArea;
            map.put(area, i);
        }    
    }
    
    public int[] pick() {
        int randInt = rand.nextInt(area);
        int index = map.higherKey(randInt);
        int[] rectChoosen = rects[map.get(index)];
        int x = rectChoosen[0] + (index-randInt-1) % (rectChoosen[2] - rectChoosen[0] +1);
        int y = rectChoosen[1] + (index-randInt-1) / (rectChoosen[2] - rectChoosen[0] +1);
        return new int[]{x, y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */