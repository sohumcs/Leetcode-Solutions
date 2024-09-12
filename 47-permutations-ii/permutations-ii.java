class Solution {
    int N;
    List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>(); 
        N = nums.length; 
        Arrays.sort(nums); 
        helper(nums, new ArrayList<Integer>(), new ArrayList<Integer>()); 
        return res; 
    }

    public void helper(int[] nums, List<Integer> curr, List<Integer> consumed) {
        if (curr.size() == N) {
            res.add(new ArrayList<Integer>(curr)); }

        
        for (int i = 0; i < N; i++) {
            if (!consumed.contains(i)) { // Skip if the index is already consumed
                curr.add(nums[i]); // Add the element to current list
                consumed.add(i); // Mark the index as consumed
                helper(nums, curr, consumed); // Recursively call helper to explore further permutations
                curr.remove(curr.size() - 1); // Backtrack by removing the last added element
                consumed.remove(consumed.size() - 1); // Remove the index from consumed list
                
                while (i < N - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
    }
}