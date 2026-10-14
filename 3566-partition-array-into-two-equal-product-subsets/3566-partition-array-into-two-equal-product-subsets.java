class Solution {
    boolean solve(int[] nums, int n, long target, int i, long pro1, long pro2){
        if(i == n) return (target == pro1 && pro1 == pro2);

        boolean a = solve(nums, n, target, i+1, pro1*nums[i], pro2);
        boolean b = solve(nums, n, target, i+1, pro1, pro2*nums[i]);
        return a|b;
    }
    public boolean checkEqualPartitions(int[] nums, long target) {
        return solve(nums, nums.length, target, 0, 1, 1);
    }
}