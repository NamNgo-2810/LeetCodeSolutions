import java.util.*;
class CombinationSumII {
    // Problem 40: Combination Sum II
    List<List<Integer>> res;
    Set<List<Integer>> set;
    public void dfs(int[] candidates, int target, int sum, int i, List<Integer> temp) {
        if (sum == target) {
            set.add(new ArrayList(temp));
            return;
        }
        if (sum > target) return;
        for (int j = i + 1; j < candidates.length; j++) {
            temp.add(candidates[j]);
            dfs(candidates, target, sum + candidates[j], j, temp);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        set = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            temp.clear();
            temp.add(candidates[i]);
            dfs(candidates, target, candidates[i], i, temp);
        }
        res.addAll(set);
        return res;
    }
}
