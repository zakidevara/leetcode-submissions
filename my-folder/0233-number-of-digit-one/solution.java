class Solution {
    public int countDigitOne(int n) {
        long count = 0;
        for (long i = 1; i <= n; i *= 10) {
            long divisor = i * 10;
            int divResult = (int) (n / divisor);
            int remainder = (int) (n % divisor);
            count += divResult * i + Math.min(Math.max(remainder - i + 1, 0L), i);
        }

        return (int) count;
    }
}
