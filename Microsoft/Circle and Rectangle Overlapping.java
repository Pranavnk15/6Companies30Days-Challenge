// 1401 Circle and Rectangle Overlapping

// Intuition
// We will first try to find nearst point from the circle to the rectangle & then calculate the distance between them.
// If the radius is greater than the radius, then it does not overlapp & else if the distance is less than or equal to the radius, then the reactangle and the circle overlaps.

// Approach
// First we will try to find which side the circle lies of the reactangle, by calculating Min(xCenter, x2), & then find the nearst X co-ordinate by,
// X point = Max(x1, Min(xCenter, x2)); similarly calculate the Y neast co-ordinate by,
// Y point = Max(y1, Min(yCenter, y2)).
// Then calculate the distance between
// distX = nearstX - xCenter
// distY = nearstY = yCenter
// THen by Comparing the radius, between the distX & distY using pythgoras theorem.

class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int nearstX = Math.max(x1, Math.min(x2, xCenter));
        int nearstY = Math.max(y1, Math.min(y2, yCenter));

        int distX = nearstX - xCenter;
        int distY = nearstY - yCenter;

        return ((distX*distX)+ (distY*distY) <= (radius*radius));       
    }
}