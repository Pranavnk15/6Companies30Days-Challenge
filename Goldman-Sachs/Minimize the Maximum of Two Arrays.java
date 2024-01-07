// 2513. Minimize the Maximum of Two Arrays


// We have two arrays arr1 and arr2 which are initially empty. You need to add positive integers to them such that they satisfy all the following conditions:

// arr1 contains uniqueCnt1 distinct positive integers, each of which is not divisible by divisor1.
// arr2 contains uniqueCnt2 distinct positive integers, each of which is not divisible by divisor2.
// No integer is present in both arr1 and arr2.
// Given divisor1, divisor2, uniqueCnt1, and uniqueCnt2, return the minimum possible maximum integer that can be present in either array.

 

// Example 1:

// Input: divisor1 = 2, divisor2 = 7, uniqueCnt1 = 1, uniqueCnt2 = 3
// Output: 4
// Explanation: 
// We can distribute the first 4 natural numbers into arr1 and arr2.
// arr1 = [1] and arr2 = [2,3,4].
// We can see that both arrays satisfy all the conditions.
// Since the maximum value is 4, we return it.
// Example 2:

// Input: divisor1 = 3, divisor2 = 5, uniqueCnt1 = 2, uniqueCnt2 = 1
// Output: 3
// Explanation: 
// Here arr1 = [1,2], and arr2 = [3] satisfy all conditions.
// Since the maximum value is 3, we return it.
// Example 3:

// Input: divisor1 = 2, divisor2 = 4, uniqueCnt1 = 8, uniqueCnt2 = 2
// Output: 15
// Explanation: 
// Here, the final possible arrays can be arr1 = [1,3,5,7,9,11,13,15], and arr2 = [2,6].
// It can be shown that it is not possible to obtain a lower maximum satisfying all conditions. 

// Approach: Binary Search

class Solution {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        int low=1;
        int high=Integer.MAX_VALUE;
        while(low<high){
            int mid=low+(high-low)/2;
            if(blackbox(mid,divisor1,divisor2,uniqueCnt1,uniqueCnt2))
                high=mid;
            else
                low=mid+1;
        }
        return low;
    }
    public boolean blackbox(long num,long d1,long d2,long c1,long c2){
        long bothdivisiblebyd1andd2=num/lcm(d1,d2);
        long canbestoredinarr1=(num/d1)-bothdivisiblebyd1andd2;
        long canbestoredinarr2=(num/d2)-bothdivisiblebyd1andd2;
        long rest=num-(bothdivisiblebyd1andd2+canbestoredinarr1+canbestoredinarr2);
        if(c1>=canbestoredinarr2){
            rest-=(c1-canbestoredinarr2);
        }
        if(c2>=canbestoredinarr1){
            rest-=(c2-canbestoredinarr1);
        }
        if(rest>=0)
            return true;
        return false;
    }
    public long lcm(long d1,long d2){
        return (d1*d2)/gcd(d1,d2);
    }
    public long gcd(long a,long b){
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
}