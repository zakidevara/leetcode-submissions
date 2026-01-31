class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int currArea  = area(left, height[left], right, height[right]);

            if (currArea > maxArea) maxArea = currArea;

            if (height[right] > height[left]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;

    }

    public int area(int x1, int y1, int x2, int y2) {
        return Math.min(y1, y2) * Math.abs(x2 - x1);
    }
}
