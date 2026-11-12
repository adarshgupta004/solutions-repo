class Solution {
    public int primeSubarray(int[] nums, int k) {
   TreeMap<Integer, Integer> map = new TreeMap<>();
   Deque<Integer> primes = new ArrayDeque<>();
   int n = nums.length;
   int ans = 0;
   int left = 0;
   for(int right = 0; right < n; right++){
    if(isPrime(nums[right])) {
        map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
        primes.add(right);
    }
    while(map.size() > 0 && map.lastKey() - map.firstKey() > k){
        if(isPrime(nums[left])){
            int freq = map.get(nums[left]);
            freq--;
            if(freq == 0)
            map.remove(nums[left]);
            else
            map.put(nums[left], freq);
            primes.poll();
        }
        left++;
    }
    if(primes.size() >= 2){
        int firstPos = primes.pollLast();
        int secondPos = primes.peekLast();
        ans += secondPos - left + 1;
        primes.add(firstPos);
    }
   }     
   return ans;
    }
    public static boolean isPrime(int n){
        if(n <= 1)
        return false;
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}