// 2327. Number of People Aware of a Secret

// On day 1, one person discovers a secret.

// You are given an integer delay, which means that each person will share the secret with a new person every day, starting from delay days after discovering the secret. You are also given an integer forget, which means that each person will forget the secret forget days after discovering it. A person cannot share the secret on the same day they forgot it, or on any day afterwards.

// Given an integer n, return the number of people who know the secret at the end of day n. Since the answer may be very large, return it modulo 109 + 7.

 

// Example 1:

// Input: n = 6, delay = 2, forget = 4
// Output: 5
// Explanation:
// Day 1: Suppose the first person is named A. (1 person)
// Day 2: A is the only person who knows the secret. (1 person)
// Day 3: A shares the secret with a new person, B. (2 people)
// Day 4: A shares the secret with a new person, C. (3 people)
// Day 5: A forgets the secret, and B shares the secret with a new person, D. (3 people)
// Day 6: B shares the secret with E, and C shares the secret with F. (5 people)
// Example 2:

// Input: n = 4, delay = 1, forget = 3
// Output: 6
// Explanation:
// Day 1: The first person is named A. (1 person)
// Day 2: A shares the secret with B. (2 people)
// Day 3: A and B share the secret with 2 new people, C and D. (4 people)
// Day 4: A forgets the secret. B, C, and D share the secret with 3 new people. (6 people)

// Approach:- 
// 1) WE get to know secret at ith day, then we can spread secret after "i + delay" days.
// 2) We will forget the secret after i+forget

// We will be using a dp array, which signifies the no. of people found the secret on the ith day
// i -> i + delay (Acting as a spreader)
// i -> i+forget (Forgetting the secret)

// noOfNewPeopleSharingSecret on ith day i -> dp[i-delay]
// We need to go back i-delay days, to find out no. of people who will be applicable to share the secret on ith day
// noOfPeopleForgettingSecret on ith day i -> dp[i-forget]

// noOfPeopleSharingSecret = (noOfPeopleSharingSecret + noOfNewPeopleSHaringSecret - noOfPeopleForgettingSecret)

// In total by the end of day 'n' i.e total no of people knowing secret will be calculated by adding all the 
// ans in dp array from dp[i-forget+1] to dp[n], as previous no. of people ill not be contributing to ans, as they have
// forgotte the secret.

class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] dp =  new long[n+1];
        long mod = (long)1e9 + 7;
        long noOfPeopleSharingSecret = 0;
        long ans = 0;

        //day 1 only one person knows the secret
        dp[1] = 1;
        // i standas for days
        for(int i = 2; i<=n; i++) {
            long noOfNewPeopleSharingSecret = dp[Math.max(i-delay, 0)];
            long noOfPeopleForgettingSecret = dp[Math.max(i-forget, 0)];
            noOfPeopleSharingSecret += (noOfNewPeopleSharingSecret - noOfPeopleForgettingSecret + mod) % mod;
            //dp[i] means no. of people who found secret on ith day
            dp[i] = noOfPeopleSharingSecret;
        }

        for(int i = n-forget+1; i<=n; i++) {
            ans = (ans + dp[i]) % mod;
        }
        return (int)ans;
    }
}