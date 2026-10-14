class Solution {
   public int longestCommonSubsequence(String s, String s2) {
     int n = s.length();
     int m = s2.length();

     int dp[][] = new int[n+1][m+1];

     for(int i = 0; i<n+1; i++){
        for(int j = 0; j<m+1; j++){
            if(i == 0 || j == 0){
                dp[i][j] = 0;
            }
        }
     }   
     for(int i = 1; i <n+1; i++){
        for(int j=1; j<m+1; j++){
            if(s.charAt(i-1) == s2.charAt(j-1)){
                dp[i][j] = dp[i-1][j-1] + 1;
            }
            else{
                int ans1 = dp[i-1][j];
                int ans2 = dp[i][j-1];
                dp[i][j] = Math.max(ans1, ans2);
            }
        }
     }
     return dp[n][m];
    }
     public int longestPalindromeSubseq(String s) {
        StringBuilder reversed = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--){
            reversed.append(s.charAt(i));
        }
        String s2 = reversed.toString();

        return longestCommonSubsequence(s, s2);
}
}