#include <iostream>
using namespace std;


int helper(int n, int dp[]){
	if(n == 0 || n == 1) return 1;
	if(n<0) return 0;
	if(dp[n] != 0) return dp[n];
	int allPaths = 0;
	for(int i = n-1;i>=0;i--){
		allPaths += helper(i,dp);
	}
	dp[n] = allPaths;
	return allPaths;
}

int cs(int n){
	  if(n==0 || n==1) return 1;
		int dp[n+1];
		for(int i = 0;i<=n;i++){
		    dp[i] = 0;
		}
		helper(n,dp);
    return dp[n];
}

int main(){
    int n;
    cin>>n;
    cout<<cs(n)<<endl;
}