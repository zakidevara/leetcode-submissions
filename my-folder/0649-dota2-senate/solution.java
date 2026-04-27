class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Character> queue = new LinkedList<>();

        for (Character c : senate.toCharArray()) {
            queue.add(c);
        }

        int power = 0;
        while (power <= queue.size() && queue.size() > 1) {
            Character curr = queue.poll();
            power++;
            while (curr != queue.peek() && power > 0) {
                queue.poll();
                power--;
            }

            queue.add(curr);
        }

        return queue.peek() == 'R' ? "Radiant" : "Dire";
    }
}
