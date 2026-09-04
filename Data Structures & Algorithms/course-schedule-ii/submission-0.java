class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];
            indegree[course]++;
            adj.get(prerequisite).add(course);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i< numCourses ; i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            int node = queue.poll();
            res.add(node);
            for(int nei : adj.get(node)) {
                indegree[nei]--;
                if(indegree[nei]==0) {
                    queue.add(nei);
                }
            }
        }
        if (res.size() != numCourses) {
            return new int[0];
        }
        int[] arr = new int[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
            arr[i] = res.get(i);
        }  
        
            return arr;  
          
    }
}
