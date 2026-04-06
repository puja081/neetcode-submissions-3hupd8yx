class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> 
            a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i : nums) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> freqMap : mp.entrySet()) {
            pq.add(new int[]{ freqMap.getValue(), freqMap.getKey()});
            if(pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[1];
        }
        return res;
    }
}
