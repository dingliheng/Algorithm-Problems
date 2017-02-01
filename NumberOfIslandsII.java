public class NumberOfIslandsII {
    int[][] wards = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        //int[][] map = new int[m][n]; //record the states
        //use union to record the island
        int[] union = new int[m*n];
        Arrays.fill(union, -1);
        List<Integer> res = new LinkedList<Integer>();
        
        int numOfislands = 0;
        //traverse the positions
        for (int[] position: positions) {
            int row = position[0];
            int col = position[1];
            int root = row * n + col;
            union[root] = root;
            numOfislands++; 
            
            for (int[] ward: wards) {
                int nRow = row + ward[0]; //neighbor's row index
                int nCol = col + ward[1]; //neighbor's col index
                if ( nRow<m && nRow>=0 && nCol<n && nCol>=0 && union[nRow * n + nCol] != -1) { //check if the position is legal
                    int nRoot = findRoot(nRow * n + nCol, union);
                    if (union[root] != nRoot) { //to join two islands
                        union[root] = nRoot;
                        root = nRoot;
                        numOfislands--; //after join, number of islands decreases by 1
                    }
                }
            }
            res.add(numOfislands);
        }
        return res;
    }
    
    private int findRoot(int index, int[] tree) {
        while (tree[index] != index) {
            tree[index] = tree[tree[index]];
            index = tree[index];
        }
        return index;
    }
}
