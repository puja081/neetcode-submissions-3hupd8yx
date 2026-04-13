class Solution {
    //using stack TC - O(n), SC - O(n)
    public int trap(int[] height) {
        if(height.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int trappedWater = 0 ;
        for(int i = 0 ; i < height.length ; i++){
            while(!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                int mid = height[stack.pop()];
                if(!stack.isEmpty()) {
                    int right = height[i];
                    int left = height[stack.peek()];
                    int wallHeight = Math.min(right, left) - mid;
                    int width = i - stack.peek() - 1;
                    trappedWater = trappedWater + (wallHeight * width);
                }
            }
            stack.push(i);
        }
        return trappedWater; 
    }
}
