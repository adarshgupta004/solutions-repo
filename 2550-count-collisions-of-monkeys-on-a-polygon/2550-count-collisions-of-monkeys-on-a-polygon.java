class Solution {
    int mod = 1_000_000_007;

    private int pow(int n) {
        if(n == 0) return 1;
        if (n == 1) return 2;

        long half = pow(n/2);
        long sq = (half * half) % mod;
        
        if(n % 2 != 0) {
            sq = (sq * 2) % mod;
        }
        return (int) sq;
    }
    
    public int monkeyMove(int n) {
        int choice = pow(n);
        return (choice - 2 + mod) % mod;
    }
}