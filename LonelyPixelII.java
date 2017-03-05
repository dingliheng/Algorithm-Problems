c class LonelyPixelII {
    public int findBlackPixel(char[][] picture, int N) {
        if (picture==null || picture.length==0 || picture[0].length==0) return 0;
        int m = picture.length;
        int n = picture[0].length;
        int[] colsBP = new int[n];
        Map<String, int[]> patToNum = new HashMap<>();
        int res = 0;
        for (int i=0; i<m; i++) {
            StringBuilder sb = new StringBuilder();
            int numOfB = 0;
            for (int j=0; j<n; j++) {
                sb.append(picture[i][j]);
                if (picture[i][j]=='B') {
                    colsBP[j]++;
                    numOfB++;
                }
            }
            String pat = sb.toString();
            int[] count = patToNum.getOrDefault(pat, new int[2]);
            count[0]++;
            count[1] = numOfB;
            patToNum.put(pat, count);
        }
        
        for (Map.Entry<String, int[]> entry: patToNum.entrySet()) {
            int[] count = entry.getValue();
            if (count[0]!=count[1] || count[0]!=N) continue;
            char[] pat = entry.getKey().toCharArray();
            for (int i=0; i<pat.length; i++) {
                if (pat[i]=='B') {
                    if (colsBP[i]==count[0]) res += count[0];
                }
            }
        }
        return res;
    }
}
