class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0, current=0;
        for(int element: nums){
            if(element == 0){
                if(max<current){
                    max = current;
                }
                current=0;
            }
            else{
                current++;
            }
        }
        return max>current?max:current;
    }
}