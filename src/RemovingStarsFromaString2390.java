class Solution {
    public String removeStars(String s) {
        
        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++){
            char x = s.charAt(i);

            if(x == '*' && st.size() > 0)
            {
                st.pop();
                continue;
            }
            
            st.push(x);
        }
        String res="";
        while(st.size() != 0)
        {
            res = st.pop() + res;
        }

        return res;
    }
}
