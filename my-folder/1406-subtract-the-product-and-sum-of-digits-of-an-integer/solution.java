class Solution {
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;
        
        int r = n;
        
        while (r > 0) {
            int digit = r % 10;
            sum += digit;
            product *= digit;
            r /= 10;
        }
        
        return product - sum;
    }
}
