class Solution {
    public int majorityElement(int[] nums) {
        // Map<Integer, Integer> freqMap = new HashMap();
        // int maxCount = 0, res = 0;
        // for(int num : nums) {
        //     freqMap.put(num, freqMap.getOrDefault(num,0)+1);
        //     if(freqMap.get(num) > maxCount) {
        //         res = num;
        //         maxCount = freqMap.get(num);
        //     }
        // }

        // Arrays.sort(nums);
        // return nums[nums.length/2] ;/

        int count = 0, candidate = -1;
        for (int num : nums) {
            if(count == 0) {
                count = 1;
                candidate = num;
            } else if(num == candidate) {
                count++;
            } else {
                count --;
            }
        }
        count = 0;
        for(int num : nums) {
            if(candidate == num) {
                count++;
            }
        }
        if(count > nums.length/2) {
            return candidate;
        } else {
            return -1;
        }
        
    }
}