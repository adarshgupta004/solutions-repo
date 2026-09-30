class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
    Map<String, Integer> map = new HashMap<>();
    List<List<Integer>> res = new ArrayList<>();

    for(int i = 0; i < words.length; i++){
        map.put(words[i], i);
    }    
    for(int i = 0; i < words.length; i++){
        String word = words[i];
        int n = word.length();

        for(int cut = 0; cut <= n; cut++){
            String left = word.substring(0, cut);
            String right = word.substring(cut);

            if(isPalindrome(left)){
                String need = reverse(right);
                Integer j = map.get(need);
                if(j != null && j != i){
                    res.add(Arrays.asList(j, i));
                }
            }
            if(cut < n && isPalindrome(right)){
                String need = reverse(left);
                Integer j = map.get(need);
                if(j != null && j != i){
                    res.add(Arrays.asList(i, j));
                }
            }
        }
    }
    return res;
    }
    private boolean isPalindrome(String s){
        int left = 0, right = s.length() - 1;

        while(left < right){
            if(s.charAt(left++) != s.charAt(right--)){
                return false;
            }
        }
        return true;
    }
    private String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }
}