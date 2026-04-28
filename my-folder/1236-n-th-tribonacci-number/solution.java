class Solution {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n < 3) return 1;
        int[] arr = new int[3];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;

        for(int i = 3; i < n+1; i++) {
            arr[i % 3] = arr[0] + arr[1] + arr[2];
        }

        return arr[n % 3];
    }
}
