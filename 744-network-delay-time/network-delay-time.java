class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : times) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
        }
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;
        PriorityQueue<int[]> queue =
            new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.offer(new int[]{k, 0});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int time = current[1];
            if (time > distance[node]) {
                continue;
            }
            for (int[] edge : graph[node]) {
                int neighbor = edge[0];
                int newTime = time + edge[1];
                if (newTime < distance[neighbor]) {
                    distance[neighbor] = newTime;
                    queue.offer(new int[]{neighbor, newTime});
                }
            }
        }
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            }
            answer = Math.max(answer, distance[i]);
        }
        return answer;
    }
}
