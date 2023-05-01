class SmallestInfiniteSet {

    HashSet<Integer> removed;
    int min;
    public SmallestInfiniteSet() {
        removed = new HashSet();
        min = 1;
    }
    
    public int popSmallest() {
        removed.add(min);
        int currMin = min;
        while(removed.contains(min)){
            min++;
        }
        return currMin;
    }
    
    public void addBack(int num) {
        if(removed.contains(num)){
          removed.remove(num);
          if(num < min)
            min = num;
        }
        
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
