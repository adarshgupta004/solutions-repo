class Solution {
    public int shortestSubarray(int[] nums, int k) {
    int shortest = Integer.MAX_VALUE;
    Deque<Pair<Long, Integer>> queue = new ArrayDeque<>();
    long total = 0;
    int currLen = 0;

    for(int i = 0; i < nums.length; i++){
        int n = nums[i];
        if(n < 0){
            if(total + n <= 0){
                queue = new ArrayDeque<>();
                total = 0;
                currLen = 0;
                continue;
            }else{
                Pair<Long, Integer> removed = queue.removeLast();
                long curr = n + removed.getKey();
                int stackLength = 1 + removed.getValue();

                while(!queue.isEmpty() && curr < 0){
                    removed = queue.removeLast();
                    curr += removed.getKey();
                    stackLength += removed.getValue();
                }

                total += n;
                queue.addLast(new Pair<>(curr, stackLength));
                currLen += 1;
            }
        }else{
            queue.addLast(new Pair<>((long)n, 1));
            total += n;
            currLen += 1;
        }

        while(!queue.isEmpty() && total >= k){
            shortest = Math.min(shortest, currLen);
            Pair<Long, Integer> removed = queue.removeFirst();
            total -= removed.getKey();
            currLen -= removed.getValue();
        }
    }    
    return shortest <= nums.length ? shortest : -1;
    }

    private static class Pair<K, V>{
        private final K key;
        private final V value;

        public Pair(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
    }
}