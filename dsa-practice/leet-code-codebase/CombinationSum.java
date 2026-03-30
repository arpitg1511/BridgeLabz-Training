class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ll = new ArrayList<>();
        helper(candidates, target, 0, ll, new ArrayList<>());
        return ll;
    }

    public void helper(int[] arr, int target, int i, List<List<Integer>> ll, List<Integer> ans) {

        if(target == 0) {
            ll.add(new ArrayList<>(ans));
            return;
        }

        if(i >= arr.length) return;

        if(target < 0) return;

        ans.add(arr[i]);
        helper(arr, target - arr[i], i, ll, ans);
        ans.remove(ans.size() - 1);

        helper(arr, target, i + 1, ll, ans);
    }
}