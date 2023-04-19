class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i=0;
        int j=0;
        Stack<Integer> st = new Stack<>();

        while(i < pushed.length)
        {
            int x = pushed[i];
            st.push(x);
            int y = popped[j];
            if(x == y)
            {
                while(st.size() != 0 && st.peek() == popped[j])
                {
                    st.pop();
                    j++;
                }
            }
            i++;
        }

        while(st.size() != 0  && st.peek() == popped[j])
        {
            if(st.peek() != popped[j])
                return false;
            else
            {
                st.pop();
                j++;
            }
        }
        return st.size() == 0? true:false;
        
    }
}
