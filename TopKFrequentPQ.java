// Time Complexity : O(n log k)
// Space Complexity : O(n)

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);   
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        
        for(int i : map.keySet()){
            pq.add(i);
            if(pq.size() > k)
                pq.poll();
        }
        
        for(int i = 0; i < k; i++){
            result[i] = pq.poll();
        }
        
        return result;
    }
}