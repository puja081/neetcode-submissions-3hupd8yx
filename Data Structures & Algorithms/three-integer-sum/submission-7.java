class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] > 0){
                break;
            }
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            List<List<Integer>> pairs = (pair_sum_sorted_set(nums, i+1, -nums[i]));
            for(List<Integer> pair:pairs) {
                ArrayList<Integer> triplet = new ArrayList<>();
                triplet.add(nums[i]);
                triplet.addAll(pair);
                res.add(triplet);
            }
        }
        return res;
        
    }
    public List<List<Integer>> pair_sum_sorted_set(int[] nums, int start, int target) {
        int left = start, right = nums.length - 1;
        List<List<Integer>> list = new ArrayList<>();
        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum == target){
                list.add(Arrays.asList(nums[left], nums[right]));
                left++;
                right--;
                while(left < right && nums[left] == nums[left-1]){
                left++;
                }
            } else if(sum < target){
                left++;
            } else {
                right--;
            } }
        
        return list;
    }
}
