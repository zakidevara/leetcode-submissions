class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < 2; i++){
            result.add(new ArrayList<>());
            for (int j = 0; j < colsum.length; j++) {
                result.get(i).add(0);
            }
        }
        for (int i = 0; i < colsum.length; i++){
            if (colsum[i] == 2) {
                result.get(0).set(i, 1);
                result.get(1).set(i, 1);
                upper--;
                lower--;
            }
        }

        
        for (int i = 0; i < colsum.length; i++){
            if (colsum[i] == 1) {
                if (upper > 0) {
                    result.get(0).set(i, 1);
                    upper--;

                } else {
                    result.get(1).set(i, 1);
                    lower--;
                }
            }
        }
        
        return upper == 0 && lower == 0 ? result : List.of();
    }

}
