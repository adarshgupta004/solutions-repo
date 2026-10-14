class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int m = A.length, n = B.length;
        if(m < n) return maxUncrossedLines(B, A);

        int dp[] = new int[n + 1];
        for(int i = 0; i < m; i++){
            for(int j = 0, prev = 0, cur; j < n; j++){
                cur = dp[j+1];
                if(A[i] == B[j]) dp[j+1] = 1+prev;
                else dp[j+1] = Math.max(dp[j+1], dp[j]);
                prev = cur;
            }
        }
        return dp[n];
        
    }
}