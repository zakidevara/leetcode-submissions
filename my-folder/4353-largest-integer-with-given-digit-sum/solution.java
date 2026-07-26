class Solution {
    public int largestInteger(int n, int s) {
        if (9 * n < s) return -1;
        if (s == 0) return 0;
        

        int[] digits = new int[n];
        Arrays.fill(digits, 0);
        int r = s;
        int i = 0;
        while (r > 0) {
            int actual = Math.min(9, r);
            digits[i] = actual;
            r -= actual;
            i++;
        }
        System.out.println(Arrays.toString(digits));

        int result = 0;
        for (int j = 0; j < digits.length; j++) {
            result = result * 10 + digits[j];
        }

        return result;
    }
}
