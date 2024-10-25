#include <iostream>
#include <vector>

using namespace std;


int maxValue;

void helper(int sr, int sc, int goldCollected,  vector<vector<int>>& arr, vector<vector<int>>& dp){
    if(sr<0 || sr >= arr.size()) return ;
    if(sc == arr[0].size()){
        maxValue = std::max(maxValue, goldCollected);
        return;
    }
    helper(sr-1, sc+1, goldCollected+arr[sr][sc], arr,dp);
    helper(sr, sc+1, goldCollected+arr[sr][sc], arr,dp);
    helper(sr+1, sc+1, goldCollected+arr[sr][sc], arr,dp);
}

int minCost(int n, int m, vector<vector<int>>& arr, vector<vector<int>>& dp ) {

  // write your code here
    maxValue = -1;
    for(int i = 0;i<n;i++){
        helper(i,0, 0,arr,dp);
}

  return maxValue!=-1 ? maxValue: 0;

}



int main()  {

  int n;
  int m;

  cin >> n >> m;

  vector<vector<int>> arr(n, vector<int>(m));

  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      cin >> arr[i][j];
    }
  }

  vector<vector<int>> dp(n, vector<int>(m));

  cout << minCost(n, m, arr, dp);
}