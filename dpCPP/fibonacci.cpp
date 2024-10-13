class Solution {
  public:
    long long int topDown(int n) {
        // code here
        if(n == 0 || n==1) return n;
        long long int dp[n+1]; 
        for(int i =0 ;i<n+1;i++){
            dp[i] = 0;
        }
        helper(n,dp);
        return dp[n]; 
    }
    long long int bottomUp(int n) {
        if(n == 0 || n==1) return n;
        long long int dp[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2;i<=n;i++){
            dp[i] = (dp[i-1]+dp[i-2]) % 1000000007;
        }
        return dp[n]; 
    }
        long long int helper(int n, long long int dp[]) {
          
        if(n == 0 || n==1) return n;
        if(dp[n]!=0) return dp[n];
        long n1 = helper(n-1,dp);
        long n2 = helper(n-2,dp);
        dp[n] = (n1+n2)% 1000000007; 
        return( n1+n2 )% 1000000007; 
    }
};