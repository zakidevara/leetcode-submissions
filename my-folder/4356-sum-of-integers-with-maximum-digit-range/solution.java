class Solution {
    public int maxDigitRange(int[] nums) {
        // 1. search for max digit range
        int maxDigitRange = Integer.MIN_VALUE;
        Map<Integer, List<Integer>> digitRangeMap = new HashMap<>();
        for (int n : nums) {
            char[] digits = String.valueOf(n).toCharArray();
            int minDigit = digits[0] - '0';
            int maxDigit = minDigit;
            for (Character digit : digits) {
                minDigit = Math.min(minDigit, digit - '0');
                maxDigit = Math.max(maxDigit, digit - '0');
            }
            int currDigitRange = maxDigit - minDigit;
            digitRangeMap.computeIfAbsent(currDigitRange, k -> new ArrayList<>()).add(n);
            maxDigitRange = Math.max(maxDigitRange, currDigitRange);
        }

        // 2. sum all integers with digit range == max digit range
        int sum = 0;
        for (int n : digitRangeMap.get(maxDigitRange)) {
            sum += n;
        }

        return sum;
    }
}
