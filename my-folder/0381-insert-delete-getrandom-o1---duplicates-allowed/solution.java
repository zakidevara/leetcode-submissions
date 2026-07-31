class RandomizedCollection {

    private List<Integer> list = new ArrayList<>();
    private Map<Integer, Set<Integer>> index = new HashMap<>(); // value to index in the list;

    public RandomizedCollection() {
        
    }
    
    public boolean insert(int val) {
        Set<Integer> indices = index.getOrDefault(val, new HashSet<>());
        boolean result = indices.isEmpty();
        indices.add(list.size());
        index.put(val, indices);
        list.add(val);

        return result;
    }
    
    public boolean remove(int val) {
        Set<Integer> indices = index.getOrDefault(val, new HashSet<>());
        if (indices.isEmpty()) return false;

        // swap last element and removed element for O(1) deletion
        int idxToRemove = index.get(val).iterator().next();
        int temp = list.getLast();
        list.set(idxToRemove, temp);

        // update the index
        indices.remove(idxToRemove);

        // update the swapped element index
        index.get(temp).add(idxToRemove);
        index.get(temp).remove(list.size() - 1);

        // remove last element
        list.removeLast();

        return true;
    }
    
    public int getRandom() {
        int random = new Random().nextInt(list.size());
        return list.get(random);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
