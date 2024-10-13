// https://leetcode.com/problems/climbing-stairs/
class Solution {
public:
    int climbStairs(int n) {
        if(n == 0|| n== 1) return 1;
        int dp[n+1] ;
        for(int i = 2 ;i<n+1;i++){
            dp[i] = 0;
        }
        dp[0] = dp[1] = 1;
        // return helper(n,dp);
        return tabulation(n,dp);
    }
    
//     Recursive
    int helper(int n,int dp[]){
        if( n == 0 || n==1 ) return 1;
        
        if(dp[n] != 0) return dp[n];
        int oneLess = helper(n-1, dp);
        int twoLess = helper(n-2, dp);
        dp[n] = oneLess + twoLess;
        return dp[n];
    }
    
//     tabulation
    int tabulation(int n, int dp[]){
        for(int i = 2 ;i<n+1;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
};