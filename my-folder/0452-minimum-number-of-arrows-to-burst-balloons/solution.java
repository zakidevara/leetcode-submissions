class Solution {
    public int findMinArrowShots(int[][] points) {
        // sort ascendingly based on xEnd (O(n log n))
        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        // try to shoot arrows at each xEnd, greedy (O(n))
        int currArrowX = points[0][1];
        for (int[] balloon : points) {
            if (currArrowX < balloon[0]) {
                // draw more arrow
                arrows++;
                currArrowX = balloon[1];
            }
        }
        return arrows;
    }
}
