class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++) {
            indexMap.put(nums[i], i);
        }
        for(int i = 0 ; i < nums.length ; i++) {
            int diff = target - nums[i];
            if(indexMap.containsKey(diff) && indexMap.get(diff) != i){
                return new int[]{i, indexMap.get(diff)};
            }
        }
        return new int[0];
        
    }
}
