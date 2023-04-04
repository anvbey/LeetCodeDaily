class Solution {
    public int partitionString(String s) {
        
        int count=1;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                count++;
                map.clear();
                map.put(ch, 1);
            }
            else{
                map.put(ch, 1);
            }
        }
        return count;
    }
}
