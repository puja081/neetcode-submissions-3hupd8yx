class Solution {
    public int removeElement(int[] nums, int val) {
        // List<Integer> temp = new ArrayList<>();
        // int k = 0;
        // for (int num : nums) {
        //     if(num != val) {
        //         temp.add(num);
        //     }
        // }
        // for(int i = 0 ; i < temp.size() ; i++){
        //     nums[i] = temp.get(i);
        // }
        // return temp.size(); // TC = O(n) and SC = O(n)
       
       int i = 0 ;
       int n = nums.length;
       while(i < n) {
        if(nums[i] == val) {
            nums[i] = nums[--n];
        } else {
            i++;
        }

    }
      return n;
    }
}