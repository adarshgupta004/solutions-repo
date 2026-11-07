class Solution {
    public int getMoneyAmount(int n) {
   int[][] dp = new int[n + 1][n + 1];

   for(int l = 2; l <= n; l++){
    for(int i = 1; i <= n - (l - 1); i++){
        dp[i][i + (l - 1)] = Integer.MAX_VALUE;
        for(int g = i; g <= i + (l - 1); g++){
            int costForThisGuess;

            if(g == n){
                costForThisGuess = dp[i][g - 1] + g;
            } else{
                costForThisGuess = g + Math.max(dp[i][g - 1], dp[g + 1][i + (l - 1)]);
            }
            dp[i][i +(l - 1)] = Math.min(dp[i][i + (l - 1)], costForThisGuess);
        }
    }
   }  
   return dp[1][n];   
    }
}