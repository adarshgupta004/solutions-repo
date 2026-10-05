class Solution {
    public int arraySign(int[] nums) {

     int ncount = 0;
     for(int i = 0; i < nums.length; i++){
        if(nums[i]<0){
            ncount++;
        }

        else if(nums[i] == 0){
            return 0;
        }
     }   
     if(ncount % 2 != 0){
        return -1;
     }
     return 1;
    }
}