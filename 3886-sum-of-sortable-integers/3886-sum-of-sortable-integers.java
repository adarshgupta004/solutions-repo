class Solution {
    private void divisorFun(int n, List<Integer> ans){
    for(int i = 1; i * i <= n; i++){
        if(n % i == 0) {
            ans.add(i);

            if(i != n / i){
                ans.add(n / i);
            }
        }
    }
    }
    private boolean isSortable(
        int k, int[] sorted, int[] nums, int blockStart
    ){
        for(int start = 0; start < k; start++){
            if(sorted[blockStart + start] != nums[blockStart]){
                continue;
            }
            boolean matches = true;
            for(int j = 0; j < k; j++){
                int expectedIdx = blockStart + (start + j) % k;

                if(nums[blockStart + j] != sorted[expectedIdx]) {
                    matches = false;
                    break;
                }
            }
            if(matches){
                return true;
            }
        }
        return false;
    }
    public int sortableIntegers(int[] nums) {
       int n = nums.length;

       int[] sorted = nums.clone();
       Arrays.sort(sorted);

       List<Integer> divisors = new ArrayList<>();
       divisorFun(n, divisors);

       int ans = 0;

       for(int k : divisors){
        boolean valid = true;

        for(int blockStart = 0;
        blockStart < n; 
        blockStart += k){

       if(!isSortable(k, sorted, nums, blockStart)){
        valid = false;
        break;
       }     
        }
        if(valid){
            ans += k;
        }
       } 
       return ans;
    }
}