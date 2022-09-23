package Recursion;

/*
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
 */

import java.util.*;

public class CombinationSum1 {

    ArrayList<List<Integer>> ans = new ArrayList();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        ArrayList<Integer> op = new ArrayList();

        Arrays.sort(candidates);

        solve(candidates, 0, op, target);

        return this.ans;

    }

    public void solve(int[] candidates, int index, ArrayList<Integer> op, int target) {

        //target is 
        if (target < 0) {
            return;
        } else if (target == 0) {
            this.ans.add(new ArrayList<>(op));
            return;
        } else {

            for (int i = index; i < candidates.length; i++) {

                op.add(candidates[i]);
                solve(candidates, i, op, target - candidates[i]);
                op.remove(op.size() - 1);

            }
        }

    }

}

/*
**************** Logic ****************
Use backtracking to create different combinations.
*/
