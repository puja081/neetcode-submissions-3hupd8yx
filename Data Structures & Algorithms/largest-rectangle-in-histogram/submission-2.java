class Solution {
    public int largestRectangleArea(int[] heights) {
             /*🔥 Intuition (Very Important) 
            Maintain increasing stack of indices
            When current height is smaller
                → we found the right boundary
                → compute area immediately
        stack store - indices of increasing heights
        current height < stack top height (right boundary)
        left boundary = new stack top
        right boundary = current index
        When a smaller bar comes, calculate area for all taller bars :
        --> TC - O(n) and SC - O(1)
        NOTE: We can precompute NSL & NSR, but we can optimize to single pass 
        using a monotonic stack. TC - O(n) and SC - O(n)
        */
        int maxArea = 0 ;
        Stack<Integer> stk = new Stack<>();
        int n = heights.length;
        for(int i = 0 ; i <= n ; i++){
            int currentHeight = (i == n) ? 0 : heights[i];
            while(!stk.isEmpty() && currentHeight < heights[stk.peek()]){
                int height = heights[stk.pop()];
                int right = i;
                int left = stk.isEmpty() ? -1 : stk.peek();
                int width = right - left - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stk.push(i);

        }

        return maxArea;
    }
}
