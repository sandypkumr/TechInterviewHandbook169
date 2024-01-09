package array;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resList = new ArrayList<>();
        combinationSumHelper(0, new ArrayList<>(), 0, resList, candidates, target);
        return resList;
    }

    private void combinationSumHelper(int index, List<Integer> curList, int total, List<List<Integer>> resList, int[] candidates, int target) {
        if (total == target) {
            resList.add(List.copyOf(curList));
            return;
        }
        if (index == candidates.length || total > target) {
            return;
        }
        curList.add(candidates[index]);
        combinationSumHelper(index, curList, total + candidates[index], resList, candidates, target);
        curList.removeLast();
        combinationSumHelper(index + 1, curList, total, resList, candidates, target);
    }
}
