class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int i = 0;
        
        while (i < arr.length) {
            boolean found = false;
            for (int[] row : pieces) {
                if (row[0] != arr[i]) {
                    continue;
                }
                
                found = true;
                if (row.length > arr.length - i) return false;
                
                int j = 0;
                while (j < row.length && row[j] == arr[i]) {
                    System.out.println(row[j]);
                    i++;
                    j++;
                }
                
                if (j < row.length-1) return false;
                break;
            }
            
            if (!found) {
                return false;
            }
        }
        return true;
    }
}
