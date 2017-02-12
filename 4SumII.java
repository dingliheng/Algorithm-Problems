public class 4SumII {
    // public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    //     Map<Integer, Integer> sumOfTwo = new HashMap<>(); //use a set to collect all sums of the 1st and 2nd array
    //     int res = 0;
    //     for (int a: A) {
    //         for (int b: B) {
    //             int sum = a+b;
    //             if (!sumOfTwo.containsKey(sum)) {
    //                 sumOfTwo.put(sum, 0);
    //             }
    //             sumOfTwo.put(sum, sumOfTwo.get(sum)+1);
    //         }
    //     }
    //     for (int c: C) {
    //         for (int d: D) {
    //             if (sumOfTwo.containsKey(-c-d)) res += sumOfTwo.get(-c-d);
    //         }
    //     }
    //     return res;
    // }
    
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    Map<Integer, Integer> map = new HashMap<>();
    
    for(int i=0; i<C.length; i++) {
        for(int j=0; j<D.length; j++) {
            int sum = C[i] + D[j];
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
    }
    
    int res=0;
    for(int i=0; i<A.length; i++) {
        for(int j=0; j<B.length; j++) {
            res += map.getOrDefault(-1 * (A[i]+B[j]), 0);
        }
    }
    
    return res;
}
}
