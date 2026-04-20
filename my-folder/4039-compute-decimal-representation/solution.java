class Solution {
    public int[] decimalRepresentation(int n) {
        List<Integer> result = new LinkedList<>();
        int i = 1;
        while (n > 0) {
            int mod = n % ((int) Math.pow(10, i));
            if (mod > 0) {
                result.addFirst(mod);
            }
            n = n - mod;
            i++;
        }

        int[] res = new int[result.size()];
        int j = 0;
        for (Integer num : result) {
            res[j] = num;
            j++;
        }

        return res;
    }
}
