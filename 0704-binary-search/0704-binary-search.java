class Solution {
    public int recursiveBinarySearch(int[] nums, int target, int start, int end){
       if(start <= end){
        int mid = start + (end - start) / 2;
        if(nums[mid] == target){
            return mid;
        }
        else if(nums[mid] >= target){
            return recursiveBinarySearch(nums,target,start,mid - 1);
        }
        else{
            return recursiveBinarySearch(nums, target, mid + 1, end);
        }
       } 
       return -1;
    }
    public int search(int[] nums, int target) {
        int st = 0;
        int end = nums.length - 1;
        return recursiveBinarySearch(nums, target, st, end);
    }
}