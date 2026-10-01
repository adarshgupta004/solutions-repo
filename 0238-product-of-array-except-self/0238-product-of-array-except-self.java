class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        
        // 1. Forward pass: Collect products from the left
        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            ans[i] = leftProduct;
            leftProduct *= nums[i];
        }
        
        // Backward pass:multiply by product from right
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        
        return ans;
    }
}