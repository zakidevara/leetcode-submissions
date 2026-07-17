class Solution {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        boolean negative = num < 0;
        num = Math.abs(num);
        int maxPow = 0;
        while (num / (int) Math.pow(7, maxPow) > 0) {
            maxPow++;
        }
        maxPow--;
        
        StringBuilder result = new StringBuilder();
        while (maxPow >= 0) {
            int sevenPower = (int) Math.pow(7, maxPow);
            result.append((num / sevenPower));
            num = num % sevenPower;
            maxPow--;
        }
        
        return negative ? "-" + result.toString() : result.toString();
    }
}
