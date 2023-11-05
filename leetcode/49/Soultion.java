class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, LinkedList<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] arr = str.toCharArray(); 
            Arrays.sort(arr); 


            String sortedStr = new String(arr);
            map.putIfAbsent(sortedStr, new LinkedList<String>());
            map.get(sortedStr).add(str);            
        }

        return new ArrayList<>(map.values());
    }
}