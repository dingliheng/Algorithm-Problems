public class FreedomTrail {
    public int findRotateSteps(String ring, String key) {
        if (key==null) return 0;
        int len = ring.length();
        int kLen = key.length();
        int[][] dp = new int[key.length()+1][ring.length()];
        for (int i=0; i<dp.length; i++) {
            for (int j=0; j<dp[0].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        for (int i=0; i<key.length(); i++) {
            for (int j=0; j<ring.length(); j++) {
                if (key.charAt(i)==ring.charAt(j)) {
                    for (int k=0; k<ring.length(); k++) {
                        if (dp[i][k]==Integer.MAX_VALUE) continue;
                        int diff = Math.abs(k-j);
                        int dis = Math.min(diff, len-diff);
                        dp[i+1][j] = Math.min(dp[i+1][j], dis+dp[i][k]);
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i=0; i<ring.length(); i++) {
            res = Math.min(res, dp[kLen][i]);
        }
        return res+kLen;
    }
}
