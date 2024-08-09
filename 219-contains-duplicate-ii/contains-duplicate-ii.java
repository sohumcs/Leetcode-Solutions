public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer, Integer> numIndices = new HashMap<>();

        for (int currentIndex = 0; currentIndex < n; ++currentIndex) {
            int currentNum = nums[currentIndex];

            if (numIndices.containsKey(currentNum)) {
                if (currentIndex - numIndices.get(currentNum) <= k) {
                    return true;
                }
            }

            numIndices.put(currentNum, currentIndex);
        }

        return false;
    }
}