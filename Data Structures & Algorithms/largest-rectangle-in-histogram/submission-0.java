class Solution {
    public int largestRectangleArea(int[] hist) {
        /*🔥 Intuition (Very Important) 
            Maintain increasing stack of indices
            When current height is smaller
                → we found the right boundary
                → compute area immediately
        stack store - indices of increasing heights
        current height < stack top height (right boundary)
        left boundary = new stack top
        right boundary = current index
        When a smaller bar comes, calculate area for all taller bars
        NOTE: We can precompute NSL & NSR, but we can optimize to single pass 
        using a monotonic stack.
        */

        int n= hist.length;

//STEP1:  find  indexes' array of smaller element to RIGHT

        Stack<Integer> stack= new Stack<>();
        int[] rightArr= new int[n];


        for(int i=n-1;i>=0;i--){

            while(!stack.empty() && hist[i]<=hist[stack.peek()]){
                stack.pop();
            }

            if(stack.empty()){
                rightArr[i] = n;
            }

            else if(!stack.empty() && hist[i]>hist[stack.peek()]){

                rightArr[i] = stack.peek();
            }
            stack.push(i);

        }

   //STEP2:  find  indexes' array of smaller element to LEFT
     
        Stack<Integer> stack1= new Stack<>();
        int[] leftArr= new int[n];


        for(int i=0; i<n; i++){

            while(!stack1.empty() && hist[i]<=hist[stack1.peek()]){
                stack1.pop();
            }

            if(stack1.empty()){
                leftArr[i] = -1;
            }

            else if(!stack1.empty() && hist[i]>hist[stack1.peek()]){

                leftArr[i] = stack1.peek();
            }
            stack1.push(i);

        }

// STEP3: now these arrays' element's difference will give you the  width, you can find area by multiplying into the actual array's   //element 
        int maxArea = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            int localArea = hist[i]*(rightArr[i]-leftArr[i]-1);

            if(maxArea<localArea){
               maxArea=localArea; 
            }

        }

        return maxArea;
        
    }
}
