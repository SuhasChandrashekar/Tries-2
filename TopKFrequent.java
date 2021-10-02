// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);   
        }
        
        List[] list = new List[nums.length + 1];
        
        for(int i : map.keySet()){
            int count = map.get(i);
            if(list[count] == null){
                list[count] = new ArrayList<Integer>();
            }
            list[count].add(i);
        }
        
        int l = 0;
        for(int i = nums.length; i > 0 && k > 0; i--){
            if(list[i] != null){
                for(int j = 0; j < list[i].size() && k > 0; j++){
                    result[l++] = (int)list[i].get(j);
                    k--;
                }
            }
        }
        
        return result;
    }
}