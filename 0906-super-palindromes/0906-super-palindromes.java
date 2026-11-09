class Solution {
    public int superpalindromesInRange(String L, String R) {
    long l = Long.parseLong(L);
    long r = Long.parseLong(R);
    int[] res = new int[1];

    dfs("", l, r, res);

    for(int i = 0; i < 10; i++){
        dfs("" + i, l, r, res);
    }    
    return res[0];
    }

    private void dfs(String s, long l, long r, int[] res){
        if(s.length() > 9){
            return;
        }
        if(s.length() > 0 && s.charAt(0) != 0){
            long num = Long.parseLong(s);
            num *= num;
            if(num > r) {return; }
            if(num >= l && isPalindrome("" + num)){
                res[0]++;
            }
        }
        for(int i = 0; i < 10; i++){
            String next = "" + i + s + i;
            dfs(next, l, r, res);
        }
    }

    private boolean isPalindrome(String s){
        int head = 0;
        int tail = s.length() - 1;
        while(head < tail){
            if(s.charAt(head++) != s.charAt(tail--)){
                return false;
            }
        }
        return true;
    }
}