class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++)
        {
            char x = s.charAt(i);

            if(x == '{' || x == '(' || x == '[')
                st.push(x);
            else{
                if(st.size() == 0)
                    return false;
                if(x == '}' && st.peek() == '{')
                    st.pop();
                else if(x == ')' && st.peek() == '(')
                    st.pop();
                else if(x == ']' && st.peek() == '[')
                    st.pop();
                else
                    return false;
            }
        }

        return st.size()==0;
    }
}
