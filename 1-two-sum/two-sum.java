class Solution {
    public int[] twoSum(int[] nums, int target) {
        int size = nums.length;
        for(int i = 1; i < size; i++){
            for(int j = i; j < size; j++){
                if(nums[j] + nums[j - i] == target){
                    return new int[]{j, j - i};
                }
            }
        }
        return new int[]{};
    }
}