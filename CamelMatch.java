// Time Complexity : O(n * (k + l))  k - length of query and  l - length of pattern
// Space Complexity : O(1)

class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>();
        if(queries == null || queries.length == 0)
            return result;
        for(String query: queries) {
            int i = 0;
            boolean flag = false;
            for(int j = 0; j < query.length(); j++){
                if(i < pattern.length() && query.charAt(j) == pattern.charAt(i)){
                    i++;
                    if(i == pattern.length()){
                        flag = true;
                    }
                }
                else if(Character.isUpperCase(query.charAt(j))){
                    flag = false;
                    break;
                }
            }
            result.add(flag);
        }
        return result;
    }
}