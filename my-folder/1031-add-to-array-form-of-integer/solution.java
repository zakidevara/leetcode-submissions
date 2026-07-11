class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> resultList = new ArrayList<>();
        int i = num.length - 1;
        int carry = k;

        while (i >= 0 || carry > 0) {
            if (i >= 0) {
                carry += num[i];
                i--;
            }
            resultList.add(carry % 10);
            
            carry /= 10;
        }

        Collections.reverse(resultList);

        return resultList;
    }
}
