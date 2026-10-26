class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
     int ans = 0;
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] i : times) {
            int u = i[0];
            int v = i[1];
            int w = i[2];
            if (!map.containsKey(u))
                map.put(u, new ArrayList<>());
            map.get(u).add(new int[]{v, w});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, k});
        Set<Integer> seen = new HashSet<>();
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int w = temp[0];
            int d = temp[1];
            if (seen.contains(d))
                continue;
            ans = Math.max(ans, w);
            seen.add(d);
            if (!map.containsKey(d))
                continue;
            for (int[] i : map.get(d)) {
                int d2 = i[0];
                int w2 = i[1];
                pq.offer(new int[]{w + w2, d2});
            }
        }
        if (seen.size() == n)
            return ans;
        return -1;   
    }
}