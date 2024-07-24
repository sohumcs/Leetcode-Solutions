class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0; 
        int j=0;
        int window =0;
        int min=Integer.MAX_VALUE;
        while(i<nums.length){
            window+=nums[i];
            while(window>=target){
                min=Math.min(min, i-j+1);
                window-=nums[j];
                j++;
            }
            i++;
        }
        if(min==Integer.MAX_VALUE){
            return 0;
        }
        return min;
    }
}