class Solution {
    public boolean isArmstrong(int n) {
        int k = 0;
        
        int remaining = n;
        int numOfDigit = 0;
        while (remaining > 0) {
            remaining /= 10;
            numOfDigit++;
        }
        
        int sumPower = 0;
        remaining = n;
        while (remaining > 0) {
            int remainder = remaining % 10;
            remaining /= 10;
            sumPower += (int) Math.pow(remainder, numOfDigit);
        }
        
        return sumPower == n;
    }
}
