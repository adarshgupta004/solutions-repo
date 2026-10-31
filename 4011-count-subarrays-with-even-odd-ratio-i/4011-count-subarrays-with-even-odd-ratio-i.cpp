class Solution {
public:
    int countRatioSubarrays(vector<int>& nums, int a, int b) {
        int n = nums.size();

        // t2 tracks the raw prefix sums
        // t is used to create a sorted, deduplicated array for coordinate compression
        vector<int> t2(n + 1, 0);
        vector<int> t(n + 1, 0);
        
        int cur = 0;
        for(int i = 0; i < n; ++i) {
            // Odd numbers act as -a, Even numbers act as +b
            if(nums[i] & 1) cur -= a;
            else cur += b;
            
            t[i + 1] = cur;
            t2[i + 1] = cur;
        }

        // Coordinate Compression
        sort(t.begin(), t.end());
        t.erase(unique(t.begin(), t.end()), t.end());

        int m = t.size();
        
        // Fenwick tree to keep track of prefix sum frequencies
        vector<int> fen(m + 1, 0);

        auto add = [&](int idx, int val) {
            for(; idx <= m; idx += idx & -idx) fen[idx] += val;
        };
        
        // Gets the total count of prefix sums up to compressed index 'idx'
        auto query = [&](int idx) {
            int sum = 0;
            for(; idx > 0; idx -= idx & -idx) sum += fen[idx];
            return sum;
        };

        int ans = 0;
        
        for(int i = 0; i <= n; ++i) {
            // Find the 1-based compressed rank of the current prefix sum
            int temp = lower_bound(t.begin(), t.end(), t2[i]) - t.begin() + 1;

            // query(temp - 1) gives the count of prefix sums strictly LESS than t2[i]
            // We want the count of prefix sums >= t2[i], which is (total_seen_so_far - strictly_less)
            ans += i - query(temp - 1);
            
            add(temp, 1);
        }
        
        return ans;
    }
};