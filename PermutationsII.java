import java.util.*;
class PermutationsII {
    // Problem 47: Permutations II
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, res);
        return res;
    }

    private void dfs(int[] nums, int index, List<List<Integer>> res){
        if (index==nums.length){
            List<Integer> temp = new ArrayList<>();
            for (int num: nums){
                temp.add(num);
            }
            res.add(temp);
        }

        Set<Integer> set = new HashSet<>();
        for (int i=index; i<nums.length; i++){
            if (set.add(nums[i])){
                swap(nums, index, i);
                dfs(nums, index+1, res);
                swap(nums, index, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
