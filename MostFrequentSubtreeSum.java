public class MostFrequentSubtreeSum {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> sumFrequency = new HashMap<Integer, Integer>(); //record the frequency of a specified sum
        int[] dfsResult = findHelper(root, sumFrequency); 
        int maxFrequency = dfsResult[0]; //get the max frequency
        List<Integer> res = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry: sumFrequency.entrySet() ) {
            if (entry.getValue()==maxFrequency) {
                res.add(entry.getKey());
            }
        }
        int[] resArray = new int[res.size()];
        for (int i=0; i<resArray.length; i++) {
            resArray[i] = res.get(i);
        }
        return resArray;
    }
    
    //result[0] and result[1] is the max frequency and the sum of this subtree respectively
    private int[] findHelper(TreeNode root, Map<Integer, Integer> sumFrequency) {
        int[] res = new int[]{0, 0};
        if (root==null) return res;
        int[] leftRes = findHelper(root.left, sumFrequency);
        int[] rightRes = findHelper(root.right, sumFrequency);
        int curSum = leftRes[1] + rightRes[1] + root.val;
        if (!sumFrequency.containsKey(curSum)) sumFrequency.put(curSum, 0);
        int curFrequency = sumFrequency.get(curSum);
        sumFrequency.put(curSum, ++curFrequency);
        res[0] = Math.max(curFrequency, Math.max(leftRes[0], rightRes[0]));
        res[1] = curSum;
        return res;
    }
}
