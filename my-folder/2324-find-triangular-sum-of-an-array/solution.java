class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        int result = 0;
        
        int nCr = 1; 
        int count2 = 0; // Tracks powers of 2
        int count5 = 0; // Tracks powers of 5
        
        // Precomputed modular inverses mod 10 for numbers coprime to 10 (1, 3, 7, 9)
        int[] inverseMod10 = {0, 1, 0, 7, 0, 0, 0, 3, 0, 9}; 
        
        for (int i = 0; i < n; i++) {
            // 1. Reconstruct the current coefficient
            int coef = nCr;
            if (count2 > 0 && count5 > 0) {
                coef = 0; // 2 * 5 = 10, which is 0 mod 10
            } else if (count2 > 0) {
                // Powers of 2 mod 10 repeat every 4 times: 2, 4, 8, 6
                int exp = count2 % 4 == 0 ? 4 : count2 % 4;
                coef = (coef * (int)Math.pow(2, exp)) % 10; 
            } else if (count5 > 0) {
                // Any power of 5 mod 10 is always 5
                coef = (coef * 5) % 10; 
            }
            
            // 2. Add to total sum
            result = (result + nums[i] * coef) % 10;
            
            // 3. Calculate nCr for the NEXT iteration: multiply by (n - 1 - i), divide by (i + 1)
            if (i < n - 1) {
                int num = n - 1 - i;
                int den = i + 1;
                
                // Extract 2s and 5s from numerator
                while (num % 2 == 0) { num /= 2; count2++; }
                while (num % 5 == 0) { num /= 5; count5++; }
                
                // Extract 2s and 5s from denominator
                while (den % 2 == 0) { den /= 2; count2--; }
                while (den % 5 == 0) { den /= 5; count5--; }
                
                // Multiply remaining coprime numbers
                nCr = (nCr * (num % 10)) % 10;
                nCr = (nCr * inverseMod10[den % 10]) % 10;
            }
        }
        
        return result;
    }
}
