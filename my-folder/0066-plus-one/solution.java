class Solution {
    public int[] plusOne(int[] digits) {

        int curr = digits.length - 1;
        int add = 1;
        while (add > 0 && curr >= 0) {
            digits[curr] = (digits[curr] + add);

            if (digits[curr] % 10 == 0) {
                digits[curr] = 0;
                add = 1;
                curr--;
            } else {
                add = 0;
            }
        }

        if (add > 0) {
            List<Integer> linkedList = Arrays.stream(digits)
                                       .boxed()
                                       .collect(Collectors.toCollection(LinkedList::new));
            linkedList.addFirst(1);
            return linkedList.stream()
                                   .mapToInt(i -> i) 
                                   .toArray();
        }
        return digits;
    }
}
