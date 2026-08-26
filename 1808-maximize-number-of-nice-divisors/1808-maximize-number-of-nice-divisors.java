class Solution {
    int mod = (int)(1e9+7);
    public int maxNiceDivisors(int primeFactors) {
    return (int)(breakInteger(primeFactors) % mod);    
    }
    private long power(long x, long a){
        if(a == 1) return x;
        if(a == 0) return 1;
        long k1 = power(x, a/2);
        if(a % 2 == 0){
            return(k1 * k1) % mod;
        }else{
            return(k1*k1*x) % mod;
        }
    }
    private long breakInteger(int N){
        if(N <= 3) return N;
        long maxProduct = N;
        switch(N % 3) {
            case 0:
            maxProduct = power(3, (long)(N/3));
            break;
            case 1:
            maxProduct = 4 * power(3, (long)((N / 3) - 1));
            break;

            case 2:
            maxProduct = 2 * power(3, (long)(N / 3));
            break;
        }
        return maxProduct;
    }
}