class Solution {
    public boolean hasDuplicate(int[] nums) {
        // Set<Integer> seen = new HashSet<>();
        // for(int num : nums) {
        //     if(seen.contains(num)){
        //         return true;
        //     }
        //     seen.add(num);
        // }
        // return false;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length ; i++) {
           if(nums[i] == nums[i-1]){
            return true;
           }
        }
        return false;
    }
}