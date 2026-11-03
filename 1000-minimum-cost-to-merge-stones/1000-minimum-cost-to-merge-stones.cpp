class Solution {
public:
    int mergeStones(vector<int>& stones, int k) {
    int n = stones.size();
    if((n-1)%(k-1) != 0) return -1;

    vector<int> prefixSum = {0};
    for(int i : stones) prefixSum.emplace_back(prefixSum.back() + i);
    int dp[n][n];

    for(int i = 0; i < n; i++){
        for(int j = 0; j <= i; j++)
{
    dp[i][j] = 0;
}   
 }
 int piles = k;
 for(int i = n - 1; i >= 0; i--){
    for(int j = i + 1; j < n; j++){
        int mini  = INT_MAX;
        for(int k = i; k < j; k = k + piles - 1){
            int tempAns = dp[i][k] + dp[k+1][j];
            mini = min(tempAns, mini);
        }
        if((j-i)%(piles-1) == 0){
            mini += prefixSum[j + 1] - prefixSum[i];
        }
        dp[i][j] = mini;
    }
 }    
 return dp[0][n - 1];
    }
};