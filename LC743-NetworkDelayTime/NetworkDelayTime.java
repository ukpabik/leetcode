class Solution {

    // O(N) solution
    public int networkDelayTime(int[][] times, int n, int k) {
        // n nodes labeled 1 - n
        // times: directed edges -> times[i] = (u, v, w) -> u = source, v = target, w = time to get from source to target


        // send a signal from node k

        // min time for all nodes to receive signal
        // if impossible, return -1

        List<List<int[]>> graph = new ArrayList<>();
        graph.add(new ArrayList<>());

        for (int i = 1; i <= n; i++){
            graph.add(i, new ArrayList<>());
        }

        // Putting each source node to their target nodes with weights
        for (int[] edge : times){
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }


        // Create our minTime array
        int[] minTime = new int[n + 1];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        // k is our starting node
        minTime[k] = 0;

        dfs(graph, minTime, k, 0);

        int res = 0;
        for (int i = 1; i <= n; i++){
            if (minTime[i] == Integer.MAX_VALUE){
                return -1;
            }
            res = Math.max(res, minTime[i]);
        }

        return res;
        
    }

    public void dfs(List<List<int[]>> graph, int[] minTime, int node, int currTime){
        for (int[] edge : graph.get(node)){
            int neighbor = edge[0];
            int weight = edge[1];
            // Only visit nodes if the time is less than curr
            if (currTime + weight < minTime[neighbor]){
                minTime[neighbor] = currTime + weight;
                dfs(graph, minTime, neighbor, currTime + weight);
            }
        }
    }
}
