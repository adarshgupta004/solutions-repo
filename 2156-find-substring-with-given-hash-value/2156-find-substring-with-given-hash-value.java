class Solution {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
    int l = s.length() - 1;
    int r = s.length() - 1;
    long sum = 0;
    long weight = 1;
    for(int i = 0; i < k - 1; i++){
        weight = (weight * power) % modulo;
    }
    String can = "";
    while(r >= 0){
        while(r >= 0 && l - r + 1 <= k){
            char c = s.charAt(r);
            sum = ((sum * power) % modulo + (c - 'a' + 1)) % modulo;
           r--; 
        }
        if(sum == (long)hashValue){
            can = s.substring(r + 1, l + 1);
        }
        char x = s.charAt(l);
        sum = (sum - (x - 'a' + 1) * weight % modulo + modulo) % modulo;
        l--;
    } 
   return can;
    }
}