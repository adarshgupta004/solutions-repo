#include <vector>
using namespace std;

class Solution {
public:
    int change(int amount, vector<int>& coins) {
        vector<vector<unsigned long long>> dp(
            coins.size() + 1,
            vector<unsigned long long>(amount + 1, 0)
        );

        dp[coins.size()][0] = 1;

        for (int i = coins.size() - 1; i >= 0; i--) {
            for (int j = 0; j <= amount; j++) {
                unsigned long long include = 0;

                if (coins[i] <= j) {
                    include = dp[i][j - coins[i]];
                }

                unsigned long long exclude = dp[i + 1][j];
                dp[i][j] = include + exclude;
            }
        }

        return dp[0][amount];
    }
};