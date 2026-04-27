class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> unique1 = new HashSet<>();
        Set<Integer> unique2 = new HashSet<>();
        Set<Integer> common = new HashSet<>();

        for (int n : nums1) {
            unique1.add(n);
        }

        for (int n : nums2) {
            if (unique1.contains(n)) {
                common.add(n);
            } else {
                unique2.add(n);
            }
        }

        for (int n : common) {
            unique1.remove(n);
        }

        return List.of(new ArrayList<>(unique1), new ArrayList<>(unique2));
    }
}
