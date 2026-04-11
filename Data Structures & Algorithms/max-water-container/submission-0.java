class Solution {
    public int maxArea(int[] heights) {
        int max_water = 0;
        int left = 0, right = heights.length- 1;
        while(left < right) {
            int water = Math.min(heights[left], heights[right]) * (right - left);
            max_water = Math.max(max_water, water);
            if(heights[left] < heights[right]){
                left++;
            } else if (heights[left] > heights[right]){
                right--;
            }
            left++;
            right--;
        }
        return max_water;
        
    }
}
