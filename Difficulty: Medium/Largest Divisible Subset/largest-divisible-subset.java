class Solution {
    HashMap<String, ArrayList<Integer>> memo = new HashMap<>();

    ArrayList<Integer> helper(int[] arr, int i, int prevEle) {
        if (i >= arr.length) return new ArrayList<>();

        String key = i + "-" + prevEle;
        if (memo.containsKey(key)) return memo.get(key);

        ArrayList<Integer> include = new ArrayList<>();
        if (arr[i] % prevEle == 0) {
            include = helper(arr, i + 1, arr[i]);
            include = new ArrayList<>(include);  
            include.add(0, arr[i]);             
        }

        ArrayList<Integer> exclude = helper(arr, i + 1, prevEle);
        ArrayList<Integer> result = (include.size() > exclude.size()) ? include : exclude;
        memo.put(key, result);
        return result;
    }

    public ArrayList<Integer> largestSubset(int[] arr) {
        Arrays.sort(arr);
        ArrayList<Integer> result = helper(arr, 0, 1);
        return result;
    }
}