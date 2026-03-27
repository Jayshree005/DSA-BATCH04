import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, candidates, target, new ArrayList<>(), res);
        return res;
    }
    public void dfs(int i, int[] candidates, int target, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (i == candidates.length || target < 0) return;
        curr.add(candidates[i]);
        dfs(i, candidates, target - candidates[i], curr, res);
        curr.remove(curr.size() - 1);
        dfs(i + 1, candidates, target, curr, res);
    }
}