class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        return permute(nums, 0);
    }
    
    private List<List<Integer>> permute (int[] nums, int start) {
        List<List<Integer>> res = new ArrayList<>();
        if (start == nums.length - 1) {
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return res;
        }
        
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            List<List<Integer>> sub = permute(nums, start+1);
            swap(nums, start, i);
            res.addAll(sub);
        }
        
        return res;
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
