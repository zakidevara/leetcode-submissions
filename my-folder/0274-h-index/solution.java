class Solution {
    public int hIndex(int[] citations) {

        // sort the citations first from the fewest citations to largest
        Arrays.sort(citations);

        // do binary search
        int n = citations.length;
        int l = 0, r = n - 1;
        
        while (l <= r) {
            int mid = (l + r) / 2;
            int h = n - mid; 
            if (citations[mid] >= h) {
                r = mid - 1; 
            } else {
                l = mid + 1;
            }
        }
        return n - l;
    }
}
