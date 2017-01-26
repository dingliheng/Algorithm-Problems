c class ZigzagIterator {
    
    int counter;
    List<Integer> small;
    List<Integer> big;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        counter = 0;
        small = v1;
        big = v2;
    }

    public int next() {
        if (counter >= big.size() * 2) {
            return small.get(counter++ - big.size());
        }
        if (counter >= small.size() * 2) {
            return big.get(counter++ - small.size());
        }
        if (counter % 2 == 0) {
            return small.get(counter++ / 2);
        }else {
            return big.get(counter++ / 2);
        }
    }

    public boolean hasNext() {
        return counter < small.size() + big.size();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
